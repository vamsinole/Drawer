package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LiteraryActivity extends AppCompatActivity {
    private String[] literary_events = {"MUN","Cognoscencia","Feathers","Dum Charades"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_literary);


        ListView listView = (ListView)findViewById(R.id.listView4);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,literary_events);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String literature = "";
                String string = "";
                String Name = "";
                String phone = "";
                String date = "";
                String time = "";
                switch (position) {
                    case 0:
                        literature = "MUN" ;
                        string = "MUN,the flagship event of Sarasva,is a two day conference that will test your ability to research,persuade and lead, fetching out the diplomat in you. " ;
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 1:
                        literature = "COGNOSCENCIA" ;
                        string = "One of the most awaited events of Effervescence features a mind boggling quiz where the best of the brains compete for the crown. ";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 2:
                        literature = "FEATHERS" ;
                        string = "“Start writing, no matter what. The water does not flow until the faucet is turned on.”This event is for all the buzzing writers out there.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 3:
                        literature = "DUMB CHARADES" ;
                        string = "Everything is petty in front of the feeling which you get when you get your act right.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                }
                startLiteratureService(literature,string,Name,phone,date,time);
            }
        });
    }


    private void startLiteratureService(String literature,String string,String Name,String phone,String date,String time) {
        Intent intent = new Intent(LiteraryActivity.this, LiterateActivity.class);
        intent.putExtra("info", literature);
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
