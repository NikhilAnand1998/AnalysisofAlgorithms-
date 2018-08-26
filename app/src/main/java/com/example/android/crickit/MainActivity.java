package com.example.android.crickit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView team_a_score;
    TextView team_b_score;
    TextView ball_numb;
    TextView over_numb;
    //EditText team_a_score;
    Button   btnfour, btnsix, btnwide, btnreset;
    ToggleButton btnwhobats;
    ImageView team_a_bat_image, team_b_bat_image;
    int Ascore = 0;
    int Bscore = 0;
    int balls = 0;
    int overs = 0;
    boolean isTeamABatting = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team_a_score =  findViewById(R.id.team_a_score);
        team_b_score =  findViewById(R.id.team_b_score);
        ball_numb = findViewById(R.id.ball_numb);
        over_numb = findViewById(R.id.over_numb);
        btnfour = findViewById(R.id.btnfour);
        btnsix = findViewById(R.id.btnsix);
        btnwide = findViewById(R.id.btnwide);
        btnwide = findViewById(R.id.btnwide);
        btnreset = findViewById(R.id.btnreset);
        btnwhobats = findViewById(R.id.btnwhobats);
        team_a_bat_image = findViewById(R.id.team_a_bat_image);
        team_b_bat_image = findViewById(R.id.team_b_bat_image);

        btnwhobats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnwhobats.isChecked()) {
                    team_b_bat_image.setVisibility(View.VISIBLE);
                    team_a_bat_image.setVisibility(View.INVISIBLE);
                    isTeamABatting = false;
                }
                else {
                    team_a_bat_image.setVisibility(View.VISIBLE);
                    team_b_bat_image.setVisibility(View.INVISIBLE);
                    isTeamABatting = true;
                }
            }
        });

        btnfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 4;
                    team_a_score.setText(Ascore+"");
                }
                else {
                    Bscore += 4;
                    team_b_score.setText(Bscore + "");
                }
                if(balls != 5){
                    balls+=1;
                    ball_numb.setText(balls+"");
                }
                else{
                    balls = 0;
                    ball_numb.setText(balls+"");
                    overs +=1;
                    over_numb.setText(overs+"");
                }
            }
        });
        btnsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 6;
                    team_a_score.setText(Ascore+"");
                }
                else {
                    Bscore += 6;
                    team_b_score.setText(Bscore + "");
                }
                if(balls != 5){
                    balls+=1;
                    ball_numb.setText(balls+"");
                }
                else{
                    balls = 0;
                    ball_numb.setText(balls+"");
                    overs +=1;
                    over_numb.setText(overs+"");
                }
            }
        });
        btnwide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 1;
                    team_a_score.setText(Ascore+"");
                }
                else {
                    Bscore += 1;
                    team_b_score.setText(Bscore + "");
                }
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore = 0;
                    team_a_score.setText(Ascore+"");
                }
                else {
                    Bscore += 0;
                    team_b_score.setText(Bscore + "");
                }
            }
        });


    }
}
