package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DanceActivity extends AppCompatActivity {
    private String[] dance_events = {"La Frenze","Carpe Diem","Footloose","Dance Charades","Showoff"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance);


        ListView listView = (ListView)findViewById(R.id.listView2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dance_events);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dancer = "";
                String detail = "";
                String Name = "";
                String phone = "";
                String date = "";
                String time = "";
                switch (position) {
                    case 0:
                        dancer = "LA FRENZE ";
                        detail = "One of the most electrifying and enthralling dance events of Effervescence organised by the Dance club, this event is a duet dance event." ;
                        Name = "Vamshikrishna";
                        phone = "7897336949";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 1:
                        dancer = "CARPE DIEM";
                        detail = "This event is a solo dance competition of Effervescence where the participants set the stage on fire. ";
                        Name = "Aman";
                        phone = "7095965380";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 2:
                        dancer = "FOOTLOOSE";
                        detail = "The spectacular Group dance competition that will test your synchronisation and dancing skills.";
                        Name = "Ankur";
                        phone = "9177865426";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 3:
                        dancer = "DANCE CHARADES";
                        detail = "It is an informal dance event .";
                        Name = "Sandeep";
                        phone = "7897568559";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 4:
                        dancer = "SHOWOFF";
                        detail = "It is an online dance event .";
                        Name = "Tarang";
                        phone = "9966319857";
                        date = "17-10-2016";
                        time = "04:30 PM";
                }
                startDancingService(dancer,detail,Name,phone,date,time);
            }
        });
    }


    private void startDancingService(String dancer,String detail,String Name,String phone,String date,String time) {
        Intent intent = new Intent(DanceActivity.this, DancingActivity.class);
        intent.putExtra("info", dancer);
        intent.putExtra("info2",detail);
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
