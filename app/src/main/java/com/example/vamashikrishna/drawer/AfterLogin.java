package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AfterLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);


        TextView textView = (TextView)findViewById(R.id.textView40);
        textView.setText("Hello ");
        textView.append(getIntent().getStringExtra("name"));


        Button Home = (Button)findViewById(R.id.button8);
        Button Proshows = (Button)findViewById(R.id.button9);
        Button Events = (Button)findViewById(R.id.button10);
        Button Sponcers = (Button)findViewById(R.id.button11);
        Button Gallery = (Button)findViewById(R.id.button12);
        Button Contact = (Button)findViewById(R.id.button13);
        Button Signout = (Button)findViewById(R.id.button14);

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(DrawerActivity.class);
            }
        });

        Proshows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(ProshowsActivity.class);
            }
        });

        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(EventActivity.class);
            }
        });

        Gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://effervescence.iiita.ac.in/gallery.html");
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                Bundle bndlanimation =
                        ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go, R.anim.enter_right).toBundle();
                startActivity(intent, bndlanimation);
            }
        });

        Sponcers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(NextActivity.class);
            }
        });

        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(ContactActivity.class);
            }
        });

        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(DrawerActivity.class);
                Toast.makeText(AfterLogin.this,"Signed out Successfully",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void Intentfun (Class Activity){
        Intent intent = new Intent(AfterLogin.this,Activity);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go, R.anim.enter_right).toBundle();
        startActivity(intent, bndlanimation);
    }
}
