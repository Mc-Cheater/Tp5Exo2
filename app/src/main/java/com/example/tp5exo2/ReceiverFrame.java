package com.example.tp5exo2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReceiverFrame extends AppCompatActivity {
    Intent sendIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiverframe);
        //received=getIntent();
        sendIntent=new Intent(this, MainActivity.class);

        Button send=findViewById(R.id.sender);

    send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            sendIntent.putExtra("data",((EditText)findViewById(R.id.texttosend)).getText().toString());
            setResult(1,sendIntent);
            System.out.println("we are sending the result");
            //startActivity(sendIntent);
            finish();

        }
    });


    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        received=getIntent();
        super.onActivityResult(1, RESULT_OK, received);
    }*/
}
