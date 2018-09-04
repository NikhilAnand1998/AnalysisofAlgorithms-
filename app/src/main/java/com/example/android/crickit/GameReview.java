package com.example.android.crickit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Stack;

public class GameReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_review);
        TextView teamOneNameField, teamTwoNameField, whoWinsField;
        int Ascore, Bscore;
        String teamAName, teamBName, message = "It's a tie!";
        teamOneNameField = findViewById(R.id.team1name);
        teamTwoNameField = findViewById(R.id.team2name);
        whoWinsField = findViewById(R.id.whowins);
        teamAName = getIntent().getExtras().getString("teamOneName");
        teamBName = getIntent().getExtras().getString("teamTwoName");
        teamOneNameField.setText(teamAName);
        teamTwoNameField.setText(teamBName);
        Ascore = getIntent().getExtras().getInt("teamAScore");
        Bscore = getIntent().getExtras().getInt("teamBScore");
        if (Ascore > Bscore) {
            message = teamAName + " win!";
        } else if (Bscore > Ascore) {
            message = teamBName + " win!";
        }
        whoWinsField.setText(message);
//        Stack<Integer> stack11 = (Stack<Integer>)getIntent().getSerializableExtra("stack1");
//        Stack<Integer> stack22 = (Stack<Integer>)getIntent().getSerializableExtra("stack2");
    }
}
