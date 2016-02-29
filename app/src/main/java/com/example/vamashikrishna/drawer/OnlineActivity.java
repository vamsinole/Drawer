package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OnlineActivity extends AppCompatActivity {
    private String[] online_events = {"Perplexus","Platzen","Stegolica","Konqueror"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);


        ListView listView = (ListView)findViewById(R.id.listView7);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,online_events);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String offline = "";
                String string = "";
                String Name = "";
                String phone = "";
                String date = "";
                String time = "";
                switch (position) {
                    case 0:
                        offline = "PERPLEXUS" ;
                        string = "Ever thought of cracking secret codes? Ever got awed by cryptography? " +
                                "This event is for you then." ;
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 1:
                        offline = "PLATZEN" ;
                        string = "This is an event of numbers and ciphers. " +
                                "You will be given an encrypted message and a key and a little bit of our support via hint of the problem.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 2:
                        offline = "STEGOLICA" ;
                        string = "Hiding in plain sight is the theme of this event." +
                                " Answers would be in front of your eyes but hidden and concealed to ensure you put on your ‘thinking caps’ and figure out the answer.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 3:
                        offline = "KONQUEROR";
                        string = "Ahoy comrades! " +
                                "This is an online treasure hunt event where you have to fight for the ultimate crown and solve all the questions to win the grand prize.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                }
                startArtsService(offline,string,Name,phone,date,time);
            }
        });
    }


    private void startArtsService(String offline,String string,String Name,String phone,String date,String time) {
        Intent intent = new Intent(OnlineActivity.this, OnlineOneActivity.class);
        intent.putExtra("info", offline);
        intent.putExtra("info2",string);
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
