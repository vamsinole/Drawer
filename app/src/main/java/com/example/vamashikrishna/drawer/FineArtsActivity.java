package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FineArtsActivity extends AppCompatActivity {
    private String[] fine_events = {"Graffiti","The Sketcher","Toon Con","Story Pic"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine_arts);


        ListView listView = (ListView)findViewById(R.id.listView5);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fine_events);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String arts = "";
                String string = "";
                String Name = "";
                String phone = "";
                String date = "";
                String time = "";

                switch (position) {
                    case 0:
                        arts = "GRAFFITI" ;
                        string = "A event will be conducted in which participants have to use color spray to transform there ideas into reality. " +
                                "The event will be theme based. The best two will be selected and awarded the prize money." ;
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 1:
                        arts = "THE SKETCHER" ;
                        string = "An Event will be conducted on Facebook Page of Effervescence. Students from around the world will be able to participate in this event. " +
                                "The event will be theme based. The best will be selected and awarded the prize money.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 2:
                        arts = "TOON CON" ;
                        string = "The participant have to draw the cartoon sketches. The event has no pre-defined theme. The best will be selected and awarded the prize money";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 3:
                        arts = "STORY PIC" ;
                        string = "It is a group event of maximum 2 people. One has to paint the ideas and another has to pen it down. " +
                                "The best will be selected and awarded the prize money.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                }
                startArtsService(arts,string,Name,phone,date,time);
            }
        });
    }


    private void startArtsService(String arts,String string,String Name,String phone,String date,String time) {
        Intent intent = new Intent(FineArtsActivity.this, FineActivity.class);
        intent.putExtra("info", arts);
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
