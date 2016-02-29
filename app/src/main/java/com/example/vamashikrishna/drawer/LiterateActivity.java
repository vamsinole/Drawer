package com.example.vamashikrishna.drawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LiterateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_literate);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textView = (TextView)findViewById(R.id.textView27);
        TextView textView1 = (TextView)findViewById(R.id.textView28);
        TextView textView2 = (TextView)findViewById(R.id.text7);
        TextView textView3 = (TextView)findViewById(R.id.text8);
        TextView date = (TextView)findViewById(R.id.date4);
        TextView time = (TextView)findViewById(R.id.time4);
        Button button = (Button)findViewById(R.id.contact4);


        setSupportActionBar(toolbar);
        String string = getIntent().getStringExtra("info");
        String string1 = getIntent().getStringExtra("info2");
        String string2 = getIntent().getStringExtra("info3");
        final String string3 = getIntent().getStringExtra("info4");
        String date1 = getIntent().getStringExtra("info5");
        String time1 = getIntent().getStringExtra("info6");


        textView1.setText(string1);
        textView.setText(string);
        textView2.append(string2);
        textView3.append(string3);
        date.append(date1);
        time.append(time1);
        setTitle(string);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharing = new Intent(Intent.ACTION_DIAL);
                sharing.setData(Uri.parse("tel:" + string3));
                sharing.putExtra(Intent.EXTRA_PHONE_NUMBER, string3);
                startActivity(Intent.createChooser(sharing, "share via"));
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
                intent.putExtra(Intent.EXTRA_SUBJECT,string);
                intent.putExtra(Intent.EXTRA_EMAIL,string1);
                startActivity(intent);
            }
        });
    }


    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }
}
