package com.example.vamashikrishna.drawer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

public class SigninActivity extends AppCompatActivity {
    private CommentsDataSource datasource;
    List<Login> list;
    private boolean login1 = false;
    SharedPreferences prefs,prefs2;
    SharedPreferences.Editor editor,editor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        prefs2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = prefs.edit();
        editor2 = prefs2.edit();


        datasource = new CommentsDataSource(this);
        try {
            datasource.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        list = datasource.getAllDetails();

        final EditText email = (EditText)findViewById(R.id.editText4);
        final EditText password = (EditText)findViewById(R.id.editText5);
        Button signin = (Button)findViewById(R.id.button6);
        final Button show = (Button)findViewById(R.id.button7);
        final String previouslyStoredUser = prefs.getString("our_user", "");
        String previouslyStoredPass = prefs2.getString("our_pass","");
        email.setText(previouslyStoredUser);
        password.setText(previouslyStoredPass);



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int j = 0;
                String user = email.getText().toString();
                String pass = password.getText().toString();
                editor.putString("our_user", user);
                editor2.putString("our_pass",pass);
                editor.commit();
                editor2.commit();

                for(int i = 1;i < list.size();i++)
                {
                    Login login = list.get(i);
                    if(login.getUser().equals(user) && login.getPassword().equals(pass))
                    {
                        Intent intent = new Intent(SigninActivity.this,AfterLogin.class);
                        String[] names = user.split("@");
                        String name = names[0];
                        intent.putExtra("name", name);
                        startActivity(intent);
                        j++;
                    }
                }
                if(j == 0)
                Toast.makeText(SigninActivity.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show.getText().equals("show")) {
                    show.setText("hide");
                    password.setTransformationMethod(null);
                } else {
                    show.setText("show");
                    password.setTransformationMethod(new PasswordTransformationMethod());

                }
            }
        });
    }
}