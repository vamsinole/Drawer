package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

import java.io.InputStream;
import java.sql.SQLException;

public class RegActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private CommentsDataSource datasource;
    SharedPreferences prefs,prefs2;
    SharedPreferences.Editor editor,editor2;
    private ConnectionResult mConnectionResult;
    GoogleApiClient mGoogleApiClient;
    private boolean mIntentInProgress;
    private boolean mSignInClicked;
    private SignInButton btnSignIn;
    private static final int RC_SIGN_IN = 0;
    private ImageView imgProfilePic;
    private TextView txtName, txtEmail;
    private static final String TAG = "RegActivity";
    private static final int PROFILE_PIC_SIZE = 400;
    private LinearLayout linearLayout;
    private TextView register,Email,Pass,Phone;
    private Button login,signup,show;
    private EditText email,phone,password;
    private Button btnSignOut, btnRevokeAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prefs2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = prefs.edit();
        editor2 = prefs2.edit();

        btnSignIn = (SignInButton) findViewById(R.id.btn_sign_in);
        String previouslyStoredUser = prefs.getString("our_user", "");
        String previouslyStoredPass = prefs2.getString("our_pass", "");

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApiIfAvailable(Drive.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).addApi(Plus.API, Plus.PlusOptions.builder().build())
                .addScope(Plus.SCOPE_PLUS_LOGIN).build();

        datasource = new CommentsDataSource(this);
        try {
            datasource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        btnSignOut = (Button) findViewById(R.id.btn_sign_out);
        btnRevokeAccess = (Button) findViewById(R.id.btn_revoke_access);
        login = (Button)findViewById(R.id.button2);
        signup = (Button)findViewById(R.id.button);
        register = (TextView)findViewById(R.id.textView2);
        Email = (TextView)findViewById(R.id.textView3);
        Pass = (TextView)findViewById(R.id.textView4);
        Phone = (TextView)findViewById(R.id.textView5);
        show = (Button)findViewById(R.id.button3);
        email = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        phone = (EditText)findViewById(R.id.editText3);
        imgProfilePic = (ImageView) findViewById(R.id.imgProfilePic);
        txtName = (TextView) findViewById(R.id.txtName);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        linearLayout = (LinearLayout) findViewById(R.id.llProfile);


        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mGoogleApiClient.isConnected()) {
                    Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                    mGoogleApiClient.disconnect();
                    mGoogleApiClient.connect();
                    updateUI(false);
                }
            }
        });


        btnRevokeAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mGoogleApiClient.isConnected()) {
                    Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
                    Plus.AccountApi.revokeAccessAndDisconnect(mGoogleApiClient)
                            .setResultCallback(new ResultCallback<Status>() {
                                @Override
                                public void onResult(Status status) {
                                    Log.e(TAG, "User access revoked!");
                                    mGoogleApiClient.connect();
                                    updateUI(false);
                                }

                            });
                }
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().equals("") || password.getText().toString().equals("") ||
                        phone.getText().toString().equals(""))
                {
                    Toast.makeText(RegActivity.this, "Credentials can't be empty", Toast.LENGTH_LONG).show();
                }

                else if (phone.getText().toString().length() < 10 || phone.getText().toString().length() > 10)
                {
                    Toast.makeText(RegActivity.this, "Enter a valid Phone Number", Toast.LENGTH_LONG).show();
                }

                else if (password.getText().toString().length() < 6)
                {
                    Toast.makeText(RegActivity.this, "Password should contain atleast 6 letters", Toast.LENGTH_LONG).show();
                }

                else if(!email.getText().toString().endsWith("@iiita.ac.in") &&
                        !email.getText().toString().endsWith("@gmail.com"))
                {
                    Toast.makeText(RegActivity.this,"Enter a valid Email",Toast.LENGTH_LONG).show();
                }

                else
                {
                    String[] strings = email.getText().toString().split("@");
                    Intent intent = new Intent(RegActivity.this,AntakshiriActivity.class);
                    datasource.createLogin(email.getText().toString(), password.getText().toString());
//                    List<Login> list = datasource.getAllDetails();
                    intent.putExtra("name",strings[0]);
                    intent.putExtra("phone",phone.getText().toString());
                    startActivity(intent);
                }
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show.getText().equals("show")) {
                    show.setText("hide");
                    password.setTransformationMethod(null);
                }
                else {
                    show.setText("show");
                    password.setTransformationMethod(new PasswordTransformationMethod());

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(RegActivity.this,SigninActivity.class);
                Bundle bndlanimation =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go2, R.anim.enter_right2).toBundle();
                startActivity(intent1, bndlanimation);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mGoogleApiClient.isConnecting()) {
                    mSignInClicked = true;
                    resolveSignInError();
                }
            }
        });
    }

    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }


    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode,
                                    Intent intent) {
        if (requestCode == RC_SIGN_IN) {
            if (responseCode != RESULT_OK) {
                mSignInClicked = false;
            }

            mIntentInProgress = false;

            if (!mGoogleApiClient.isConnecting()) {
                mGoogleApiClient.connect();
            }
        }
    }

    @Override
    public void onConnected(Bundle arg0) {
        mSignInClicked = false;
        Toast.makeText(this, "User is connected!", Toast.LENGTH_LONG).show();

        // Get user's information
        getProfileInformation();

        // Update the UI after signin
        updateUI(true);
    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();
        updateUI(false);
    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (!connectionResult.hasResolution()) {
            GooglePlayServicesUtil.getErrorDialog(connectionResult.getErrorCode(), this,
                    0).show();
            return;
        }

        if (!mIntentInProgress) {
            // Store the ConnectionResult for later usage
            mConnectionResult = connectionResult;

            if (mSignInClicked) {
                // The user has already clicked 'sign-in' so we attempt to
                // resolve all
                // errors until the user is signed in, or they cancel.
                resolveSignInError();
            }
        }
    }

    private void updateUI(boolean isSignedIn) {
        if (isSignedIn) {
            btnSignIn.setVisibility(View.GONE);
            linearLayout.setVisibility(View.VISIBLE);
            register.setVisibility(View.GONE);
            show.setVisibility(View.GONE);
            email.setVisibility(View.GONE);
            Email.setVisibility(View.GONE);
            phone.setVisibility(View.GONE);
            Pass.setVisibility(View.GONE);
            Phone.setVisibility(View.GONE);
            phone.setVisibility(View.GONE);
            login.setVisibility(View.GONE);
            signup.setVisibility(View.GONE);
            btnSignOut.setVisibility(View.VISIBLE);
            btnRevokeAccess.setVisibility(View.VISIBLE);

        } else {
            btnSignIn.setVisibility(View.VISIBLE);
            btnSignOut.setVisibility(View.GONE);
            btnRevokeAccess.setVisibility(View.GONE);
            linearLayout.setVisibility(View.GONE);
            register.setVisibility(View.VISIBLE);
            show.setVisibility(View.VISIBLE);
            email.setVisibility(View.VISIBLE);
            Email.setVisibility(View.VISIBLE);
            phone.setVisibility(View.VISIBLE);
            Pass.setVisibility(View.VISIBLE);
            Phone.setVisibility(View.VISIBLE);
            phone.setVisibility(View.VISIBLE);
            login.setVisibility(View.VISIBLE);
            signup.setVisibility(View.VISIBLE);
        }
    }

    private void resolveSignInError() {
        if (mConnectionResult.hasResolution()) {
            try {
                mIntentInProgress = true;
                mConnectionResult.startResolutionForResult(this, RC_SIGN_IN);
            } catch (IntentSender.SendIntentException e) {
                mIntentInProgress = false;
                mGoogleApiClient.connect();
            }
        }
    }

    private void getProfileInformation() {
        try {
            if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) != null) {
                Person currentPerson = Plus.PeopleApi
                        .getCurrentPerson(mGoogleApiClient);
                String personName = currentPerson.getDisplayName();
                String personPhotoUrl = currentPerson.getImage().getUrl();
                String personGooglePlusProfile = currentPerson.getUrl();
                String email = Plus.AccountApi.getAccountName(mGoogleApiClient);

                Log.e(TAG, "Name: " + personName + ", plusProfile: "
                        + personGooglePlusProfile + ", email: " + email
                        + ", Image: " + personPhotoUrl);

                txtName.setText(personName);
                txtEmail.setText(email);

                // by default the profile url gives 50x50 px image only
                // we can replace the value with whatever dimension we want by
                // replacing sz=X
                personPhotoUrl = personPhotoUrl.substring(0,
                        personPhotoUrl.length() - 2)
                        + PROFILE_PIC_SIZE;

                new LoadProfileImage(imgProfilePic).execute(personPhotoUrl);

            } else {
                Toast.makeText(getApplicationContext(),
                        "Person information is null", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class LoadProfileImage extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public LoadProfileImage(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

