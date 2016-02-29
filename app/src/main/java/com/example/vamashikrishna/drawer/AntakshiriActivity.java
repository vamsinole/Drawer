package com.example.vamashikrishna.drawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.widget.TextView;

public class AntakshiriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antakshiri);
        TextView textView = (TextView)findViewById(R.id.textView13);
        textView.setText("Hello ");
        String name = getIntent().getStringExtra("name");
        textView.append(name);
        String string = getIntent().getStringExtra("phone");
        String sms = "Hello " + name + ".Thank you for Registring for Effervescence.";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(string,null, sms, null, null);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }
}
