package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EventActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        Button music = (Button) findViewById(R.id.music);
        Button dance = (Button) findViewById(R.id.dance);
        Button literary = (Button) findViewById(R.id.literary);
        Button drama = (Button) findViewById(R.id.drama);
        Button fine_arts = (Button) findViewById(R.id.fine_arts);
        Button informal = (Button) findViewById(R.id.informals);
        Button online = (Button) findViewById(R.id.online);
        Button photography = (Button) findViewById(R.id.photography);


        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(MusicActivity.class);
            }
        });

        dance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(DanceActivity.class);
            }
        });

        literary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(LiteraryActivity.class);
            }
        });

        drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(DramaActivity.class);
            }
        });

        informal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(InformalActivity.class);
            }
        });

        fine_arts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(FineArtsActivity.class);
            }
        });

        online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(OnlineActivity.class);
            }
        });

        photography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun(PhotoActivity.class);
            }
        });

    }


    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }

    public void Intentfun (Class Activity){
        Intent intent = new Intent(EventActivity.this,Activity);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go, R.anim.enter_right).toBundle();
        startActivity(intent, bndlanimation);
    }

}

