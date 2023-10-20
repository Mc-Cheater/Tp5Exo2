package com.example.tp5exo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends AppCompatActivity {
    Intent askModification;
    Intent exer3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button modify=findViewById(R.id.button);
        askModification=new Intent(this, ReceiverFrame.class);
        exer3=new Intent(this,Exo3.class);
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("intent is sent");
                startActivityForResult(askModification,1);
            }
        });

        Button Exo3=findViewById(R.id.exo3);
    Exo3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(exer3);
        }
    });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


       /*
        */TextView vi=findViewById(R.id.textviewtm);
        String result=data.getStringExtra("data");
        switch (requestCode){
            case 1:
                vi.setText(result);
                System.out.println("this should never happen");
                break;
            default:
                System.out.println("this should never happen");

        }
        super.onActivityResult(requestCode, resultCode, getIntent());


    }
}