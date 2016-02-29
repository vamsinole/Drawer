package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);


        ImageView gate = (ImageView)findViewById(R.id.gate);
        ImageView vlcc = (ImageView)findViewById(R.id.vlcc);
        ImageView ril = (ImageView)findViewById(R.id.ril);
        ImageView rf = (ImageView)findViewById(R.id.rf);
        ImageView gk = (ImageView)findViewById(R.id.gk);
        ImageView ub = (ImageView)findViewById(R.id.ub);
        ImageView ab = (ImageView)findViewById(R.id.ab);
        ImageView ir = (ImageView)findViewById(R.id.ir);
        ImageView pfc = (ImageView)findViewById(R.id.pfc);
        ImageView uti = (ImageView)findViewById(R.id.uti);
        ImageView as = (ImageView)findViewById(R.id.as);
        ImageView ar = (ImageView)findViewById(R.id.ar);
        ImageView lakme = (ImageView)findViewById(R.id.lakme);


        gate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun("http://www.gateforum.com");
            }
        });

        vlcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Intentfun("http://www.vlccwellness.com/India/");
            }
        });

        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun("http://gokrazee.com");
            }
        });

        ril.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun("http://www.ril.com");
            }
        });

        rf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Intentfun("http://reliancefootprint.com/");
            }
        });

        ub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun("http://www.unikbazar.co.in/");
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun("http://www.zebronics.com/");
            }
        });

        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Intentfun("http://www.indiareads.com/home");
            }
        });

        pfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intentfun("http://www.pfcindia.com/");
            }
        });

        uti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Intentfun("http://www.utimf.com/Pages/default.aspx");
            }
        });

        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Intentfun("https://www.facebook.com/AstronomiaShoppe");
            }
        });

        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Intentfun("https://www.facebook.com/AnimeRide?ref=br_rs");}
        });

        lakme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {Intentfun("http://www.lakmeindia.com/lakme-salon");
            }
        });
    }


    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }

    public void Intentfun(String string){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(string));
        Bundle bundle =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go, R.anim.enter_right).toBundle();
        startActivity(intent, bundle);
    }
}
