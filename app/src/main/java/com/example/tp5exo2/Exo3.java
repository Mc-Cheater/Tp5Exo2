package com.example.tp5exo2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class Exo3 extends AppCompatActivity {
    Intent smsIntent;
    Intent webIntent;
    Intent dialIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exo3);

        smsIntent=new Intent(Intent.ACTION_SEND);
        webIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        dialIntent= new Intent(Intent.ACTION_DIAL);
        Button sms=findViewById(R.id.buttonSMS);
        Button dial=findViewById(R.id.buttonDial);
        Button web=findViewById(R.id.buttonWeb);

        Snackbar smsBar=Snackbar.make(sms,"Are you sure?",Snackbar.LENGTH_LONG);

        Snackbar dialBar=Snackbar.make(sms,"Are you sure?",Snackbar.LENGTH_LONG);

        Snackbar webBar=Snackbar.make(sms,"Are you sure?",Snackbar.LENGTH_LONG);

        dialBar.setAction("Call", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Intent.createChooser(dialIntent,"make a call"));
            }
        });

        webBar.setAction("browse", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Intent.createChooser(webIntent,"browse the web"));
            }
        });

        smsBar.setAction("sendSMS", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(Intent.createChooser(smsIntent,"Send sms using"));
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            smsBar.show();
            }
        });
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialBar.show();
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webBar.show();
            }
        });


    }
}
