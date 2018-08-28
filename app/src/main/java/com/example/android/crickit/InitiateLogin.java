package com.example.android.crickit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class InitiateLogin extends AppCompatActivity {
    TextView batsfirsttest;
    String nameone, nametwo;
    int     numbovers;
    int     afirst;
    Button  btnsubmit;
    EditText teamone, teamtwo, maxovers;
    RadioButton radioButton, radioButtonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initiate_login);

        teamone = findViewById(R.id.teamone);
        teamtwo = findViewById(R.id.teamtwo);
        maxovers = findViewById(R.id.maxovers);
        btnsubmit = findViewById(R.id.btnsubmit);
        batsfirsttest = findViewById(R.id.batsfirst);
        radioButton = findViewById(R.id.teamonebat);
        radioButtonB = findViewById(R.id.teamtwobat);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameone = teamone.getText().toString();
                nametwo = teamtwo.getText().toString();
                numbovers = Integer.valueOf(maxovers.getText().toString());




                Intent intent = new Intent(InitiateLogin.this,MainActivity.class);
                intent.putExtra("teamonename",teamone.getText().toString());
                intent.putExtra("teamtwoname",teamtwo.getText().toString());
               // intent.putExtra("maxoversgame",numbovers);
                if(radioButton.isChecked())
                {
                     afirst = 1;
                     intent.putExtra("isAfirst",afirst);
                }
                else if(radioButtonB.isChecked())
                {
                    afirst =0;
                    intent.putExtra("isAfirst",afirst);
                }
                ///

                startActivity(intent);
              //  startActivity(new Intent(InitiateLogin.this,MainActivity.class));

            }

        });







    }



}
