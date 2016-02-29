package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ProshowsActivity extends AppCompatActivity {
    private Integer[] images = {R.drawable.djn, R.drawable.ala, R.drawable.incendary, R.drawable.celeb};
    String[] web = {"Edm Night", "Alamode", "Incendary", "Celeb"} ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proshow);


        CustomList adapter = new CustomList(ProshowsActivity.this, web, images);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String proshow = "";
                String detail = "";
                switch(position){
                    case 0:
                        proshow = "EDM NIGHT";
                        detail = "The sound of youth is here." + "The bashy DJ night will take your enthusiasm and energy to an altogether new level." +
                                "Effe presents you " + "\"The Best Party Of The Year\"";
                        break;
                    case 1:
                        proshow = "ALAMODE";
                        detail = "\"If you're tired of fashion,you're tired of life\".Fashion encompasses the total spectrum of human activity. " +
                                "Being the prime platform to score for the best uprising talent , A'la Mode is back with bigger and better stakes." +
                                " A'la Mode is your chance to set the stage on fire with your elegance, compassion, style and professionalism. " +
                                "If you're a total fashion freak, come lead the trend with your creativity and moves in front of huge exciting audience.";
                        break;
                    case 2:
                        proshow = "INCENDARY";
                        detail = "Rock is musical freedom. It's saying, doing and playing what you want. Freedom from pain, " +
                                "suffering and the external world, and that's pretty close to my definition of rock. For all rock lovers, " +
                                "Virtuosi organises 'Incendiary - the rock night'. The bands set the stage on fire as the crowd witnesses the clash of the gladiators to establish their supremacy in rock music and entertain the crowd as well." +
                                " Calling it only a head bangers or a rocker's haven would be an understatement.";
                        break;
                    case 3:
                        proshow = "CELEBRITY NIGHT";
                        detail = "The Most awaited stage event where the best of the Bollywood mesmerize us with their soulful performances." +
                                "Effervescence proudly presents Celbrity Night.Get ready for the ultimate Experience.";

                }

                proshows(proshow,detail);
            }
        });
    }


    public void proshows (String proshow,String detail){
        Intent intent = new Intent(ProshowsActivity.this,ProshowActivity.class);
        intent.putExtra("info", proshow);
        intent.putExtra("msg", detail);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go, R.anim.enter_right).toBundle();
        startActivity(intent, bndlanimation);
    }


    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }
}