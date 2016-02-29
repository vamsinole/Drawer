package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DramaActivity extends AppCompatActivity {
    private String[] drama_events = {"Director's Cut","Double Trouble","Innovation","Bindaas Bol","Tongues on Fire","Kahani"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drama);


        ListView listView = (ListView)findViewById(R.id.listView3);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,drama_events);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dramatics = "";
                String drama = "";
                String Name = "";
                String phone = "";
                String date = "";
                String time = "";
                switch (position) {
                    case 0:
                        dramatics = "DIRECTOR'S CUT";
                        drama = "Ever dreamt of directing movies like 3 Idiots,Rang De Basanti,The Dark Night,Pulp Fiction or Interstellar?" ;
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 1:
                        dramatics = "DOUBLE TROUBLE" ;
                        drama = "The objective of this event is to find the imagination and creativity amongst the participants.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 2:
                        dramatics = "INNOVATION";
                        drama = "The main dramatics event of Effervescence which will be held on the main stage.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 3:
                        dramatics = "BINDAAS BOL" ;
                        drama = "A variation of Nukkad Natak, Bindaas Bol features outspoken acts. The participants are given the complete freedom over the subject of their play in this informal event.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 4:
                        dramatics = "TONGUES ON FIRE" ;
                        drama = "An informal event to bring out the real leg pulling ability of people in front of their opponents.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 5:
                        dramatics = "KAHANI" ;
                        drama = "It is a script writing event organised to bring into action the writer behind every student.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                }
                startDramaticsService(dramatics,drama,Name,phone,date,time);
            }
        });
    }


    private void startDramaticsService(String dramatics,String drama,String Name,String phone,String date,String time) {
        Intent intent = new Intent(DramaActivity.this, DramasActivity.class);
        intent.putExtra("info", dramatics);
        intent.putExtra("info2",drama);
        intent.putExtra("info3", Name);
        intent.putExtra("info4", phone);
        intent.putExtra("info5",date);
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
