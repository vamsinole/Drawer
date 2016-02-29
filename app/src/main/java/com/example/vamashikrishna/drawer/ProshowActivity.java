package com.example.vamashikrishna.drawer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ProshowActivity extends AppCompatActivity {
    private Integer[] images = {R.drawable.djn, R.drawable.ala, R.drawable.incendary, R.drawable.celeb};
    public  static final int NOTIFICATION_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proshow);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textView = (TextView)findViewById(R.id.textView35);
        TextView textView1 = (TextView)findViewById(R.id.textView36);
        Button reminder = (Button)findViewById(R.id.button5);


        setSupportActionBar(toolbar);
        String string = getIntent().getStringExtra("info");
        String string1 = getIntent().getStringExtra("msg");
        int image = getIntent().getIntExtra("image",R.drawable.ala);
        textView.setText(string);
        textView1.setText(string1);
        setTitle(string);


//        final Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.set(Calendar.HOUR_OF_DAY, 12);


        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ProshowActivity.this , NotificationService.class);
                AlarmManager alarmManager = (AlarmManager)getSystemService(ProshowActivity.ALARM_SERVICE);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(ProshowActivity.this, 0, myIntent, 0);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                //calendar.set(Calendar.HOUR_OF_DAY, 13);
                //calendar.set(Calendar.MINUTE, 14);
                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                Toast.makeText(ProshowActivity.this, "Reminder is set", Toast.LENGTH_SHORT).show();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.setData(Uri.parse("mailto:"));
                String string = "Hello This is Vamshikrishna";
                String[] string1 = {"effervescence@iiita.ac.in"};
                intent.putExtra(Intent.EXTRA_SUBJECT, string);
                intent.putExtra(Intent.EXTRA_EMAIL, string1);
                startActivity(intent);
            }
        });
    }


    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }
}
