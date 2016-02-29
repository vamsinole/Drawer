package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MusicActivity extends AppCompatActivity {
    private String[] music_events = {"Melodiux", "Unplugged", "Antakshiri", "Psychadelia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, music_events);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String songName = "";
                String detail = "";
                String Name = "";
                String phone = "";
                String date = "";
                String time = "";
                switch (position) {
                    case 0:
                        songName = "MELODIUX";
                        detail = "\"There\"s music in the sighing of a reed; There\"s music in the gushing of a rill; " +
                                "There\"s music in all things, if men had ears: Their earth is but an echo of the spheres. " ;
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 1:
                        songName = "UNPLUGGED";
                        detail = "Tone down the distortion, let the unadulterated melody of the strings take control in this Western Acoustic event." +
                                " No technical snags, no loud sounds. ";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 2:
                        songName = "ANTAKSHIRI";
                        detail =  "Music speaks what cannot be expressed, soothes the mind and gives it rest, flows from heaven to the soul!";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 3:
                        songName = "PSYCHADELIA";
                        detail =  "Great music is that which penetrates the ear with ease and leaves the memory with difficulty.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                }
                startMusicianService(songName,detail,Name,phone,date,time);
            }
        });
    }


    private void startMusicianService(String songName,String detail,String Name,String phone,String date,String time) {
        Intent intent = new Intent(MusicActivity.this, ScrollingActivity.class);
        intent.putExtra("info", songName);
        intent.putExtra("info2",detail);
        intent.putExtra("info3", Name);
        intent.putExtra("info4", phone);
        intent.putExtra("info5", date);
        intent.putExtra("info6", time);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go, R.anim.enter_right).toBundle();
        startActivity(intent, bndlanimation);
    }


    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }
}
