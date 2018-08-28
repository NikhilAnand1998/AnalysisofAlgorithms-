package com.example.android.crickit;

import android.content.Intent;
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
import java.util.Stack;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView team_a_score;
    TextView team_b_score;
    TextView over_numb;
    TextView outnumb;
    TextView nameayy;
    TextView namebay;
    Stack<Integer> teamAstack = new Stack<>();
    Stack<Integer> teamBstack = new Stack<>();
    //EditText team_a_score;
    Button   btnfour, btnsix, btnwide, btnreset, btnone,btntwo,btnthree,btnfive,btnnoball,btnout;
    ToggleButton btnwhobats;
    ImageView team_a_bat_image, team_b_bat_image, blackballone,blackballtwo,blackballthree,blackballfour,blackballfive,blackballsix;
    int Ascore = 0;
    int Bscore = 0;
    int balls = 0;
    int aouts = 0;
    int lastballout = 99;
    int lastballwide = 39;
    int makeneg = -1;
    int lastval;
    int truthval = 55;
    int bouts = 0;
    float newballs = 0;

    int overs = 0;
    float newovers = 0;
    boolean isTeamABatting = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team_a_score =  findViewById(R.id.team_a_score);
        team_b_score =  findViewById(R.id.team_b_score);
        outnumb = findViewById(R.id.outnumb);
        over_numb = findViewById(R.id.over_numb);
        btnfour = findViewById(R.id.btnfour);
        btnsix = findViewById(R.id.btnsix);
        btnone = findViewById(R.id.btnone);
        btntwo = findViewById(R.id.btntwo);
        btnthree = findViewById(R.id.btnthree);
        btnfive = findViewById(R.id.btnfive);
        btnnoball = findViewById(R.id.btnnoball);
        btnwide = findViewById(R.id.btnwide);
        btnwide = findViewById(R.id.btnwide);
        btnreset = findViewById(R.id.btnreset);
        btnout = findViewById(R.id.btnout);
        btnwhobats = findViewById(R.id.btnwhobats);
        team_a_bat_image = findViewById(R.id.team_a_bat_image);
        team_b_bat_image = findViewById(R.id.team_b_bat_image);
        blackballone = findViewById(R.id.blackballone);
        blackballtwo = findViewById(R.id.blackballtwo);
        blackballthree = findViewById(R.id.blackballthree);
        blackballfour = findViewById(R.id.blackballfour);
        blackballfive = findViewById(R.id.blackballfive);
        blackballsix = findViewById(R.id.blackballsix);
        nameayy = findViewById(R.id.teamAname);
        nameayy.setText(getIntent().getExtras().getString("teamonename"));
        namebay = findViewById(R.id.teamBname);
        namebay.setText(getIntent().getExtras().getString("teamtwoname"));
        Intent intent = getIntent();
        truthval = intent.getIntExtra("isAfirst",1000);

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

        if(truthval == 1){
            team_a_bat_image.setVisibility(View.VISIBLE);
            team_b_bat_image.setVisibility(View.INVISIBLE);
            isTeamABatting = true;
        }
        else if(truthval == 0){
            team_b_bat_image.setVisibility(View.VISIBLE);
            team_a_bat_image.setVisibility(View.INVISIBLE);
            isTeamABatting = false;
        }


        btnfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 4;
                    team_a_score.setText(Ascore+"");
                    teamAstack.push(4);
                }
                else {
                    Bscore += 4;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(4);
                }
                if(balls != 5){
                    balls+=1;
                    newballs +=0.1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    if(balls == 1){
                        blackballone.setImageResource(R.drawable.rball);
                    }
                    if(balls == 2){
                        blackballtwo.setImageResource(R.drawable.rball);
                    }
                    if(balls == 3){
                        blackballthree.setImageResource(R.drawable.rball);
                    }
                    if(balls == 4){
                        blackballfour.setImageResource(R.drawable.rball);
                    }
                    if(balls == 5){
                        blackballfive.setImageResource(R.drawable.rball);
                    }


                }
                else{
                    balls = 0;
                    newballs = 0;
                    overs +=1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    blackballone.setImageResource(R.drawable.bball);
                    blackballtwo.setImageResource(R.drawable.bball);
                    blackballthree.setImageResource(R.drawable.bball);
                    blackballfour.setImageResource(R.drawable.bball);
                    blackballfive.setImageResource(R.drawable.bball);
                    blackballsix.setImageResource(R.drawable.bball);

                }
            }
        });
        btnsix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 6;
                    team_a_score.setText(Ascore+"");
                    teamAstack.push(6);
                }
                else {
                    Bscore += 6;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(6);
                }
                if(balls != 5){
                    balls+=1;
                    newballs +=0.1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    if(balls == 1){
                        blackballone.setImageResource(R.drawable.rball);
                    }
                    if(balls == 2){
                        blackballtwo.setImageResource(R.drawable.rball);
                    }
                    if(balls == 3){
                        blackballthree.setImageResource(R.drawable.rball);
                    }
                    if(balls == 4){
                        blackballfour.setImageResource(R.drawable.rball);
                    }
                    if(balls == 5){
                        blackballfive.setImageResource(R.drawable.rball);
                    }
                }
                else{
                    balls = 0;
                    newballs = 0;
                    overs +=1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    blackballone.setImageResource(R.drawable.bball);
                    blackballtwo.setImageResource(R.drawable.bball);
                    blackballthree.setImageResource(R.drawable.bball);
                    blackballfour.setImageResource(R.drawable.bball);
                    blackballfive.setImageResource(R.drawable.bball);
                    blackballsix.setImageResource(R.drawable.bball);
                    //changes ball color
                }
            }
        });
        btnwide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 1;
                    team_a_score.setText(Ascore+"");
                    teamAstack.push(1);
                    teamAstack.push(lastballwide);

                }
                else {
                    Bscore += 1;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(1);
                    teamBstack.push(lastballwide);
                }
            }
        });
//        btnreset.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(isTeamABatting) {
//                    Ascore = 0;
//                    team_a_score.setText(Ascore+"");
//                }
//                else {
//                    Bscore += 0;
//                    team_b_score.setText(Bscore + "");
//                }
//            }
//        });
        //New Code for runs
        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 1;
                    team_a_score.setText(Ascore+"");
                    teamAstack.push(1);
                }
                else {
                    Bscore += 1;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(1);
                }
                if(balls != 5){
                    balls+=1;
                    newballs +=0.1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    if(balls == 1){
                        blackballone.setImageResource(R.drawable.rball);
                    }
                    if(balls == 2){
                        blackballtwo.setImageResource(R.drawable.rball);
                    }
                    if(balls == 3){
                        blackballthree.setImageResource(R.drawable.rball);
                    }
                    if(balls == 4){
                        blackballfour.setImageResource(R.drawable.rball);
                    }
                    if(balls == 5){
                        blackballfive.setImageResource(R.drawable.rball);
                    }
                }
                else{
                    balls = 0;
                    newballs = 0;
                    overs +=1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    blackballone.setImageResource(R.drawable.bball);
                    blackballtwo.setImageResource(R.drawable.bball);
                    blackballthree.setImageResource(R.drawable.bball);
                    blackballfour.setImageResource(R.drawable.bball);
                    blackballfive.setImageResource(R.drawable.bball);
                    blackballsix.setImageResource(R.drawable.bball);
                    //changes ball color
                }
            }
        });
        btntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 2;
                    team_a_score.setText(Ascore+"");
                    teamAstack.push(2);
                }
                else {
                    Bscore += 2;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(2);
                }
                if(balls != 5){
                    balls+=1;
                    newballs +=0.1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    if(balls == 1){
                        blackballone.setImageResource(R.drawable.rball);
                    }
                    if(balls == 2){
                        blackballtwo.setImageResource(R.drawable.rball);
                    }
                    if(balls == 3){
                        blackballthree.setImageResource(R.drawable.rball);
                    }
                    if(balls == 4){
                        blackballfour.setImageResource(R.drawable.rball);
                    }
                    if(balls == 5){
                        blackballfive.setImageResource(R.drawable.rball);
                    }
                }
                else{
                    balls = 0;
                    newballs = 0;
                    overs +=1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    blackballone.setImageResource(R.drawable.bball);
                    blackballtwo.setImageResource(R.drawable.bball);
                    blackballthree.setImageResource(R.drawable.bball);
                    blackballfour.setImageResource(R.drawable.bball);
                    blackballfive.setImageResource(R.drawable.bball);
                    blackballsix.setImageResource(R.drawable.bball);
                    //changes ball color
                }
            }
        });

        btnthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 3;
                    team_a_score.setText(Ascore+"");
                    teamAstack.push(3);
                }
                else {
                    Bscore += 3;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(3);
                }
                if(balls != 5){
                    balls+=1;
                    newballs +=0.1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");

                    if(balls == 1){
                        blackballone.setImageResource(R.drawable.rball);
                    }
                    if(balls == 2){
                        blackballtwo.setImageResource(R.drawable.rball);
                    }
                    if(balls == 3){
                        blackballthree.setImageResource(R.drawable.rball);
                    }
                    if(balls == 4){
                        blackballfour.setImageResource(R.drawable.rball);
                    }
                    if(balls == 5){
                        blackballfive.setImageResource(R.drawable.rball);
                    }
                }
                else{
                    balls = 0;
                    newballs = 0;
                    overs +=1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    blackballone.setImageResource(R.drawable.bball);
                    blackballtwo.setImageResource(R.drawable.bball);
                    blackballthree.setImageResource(R.drawable.bball);
                    blackballfour.setImageResource(R.drawable.bball);
                    blackballfive.setImageResource(R.drawable.bball);
                    blackballsix.setImageResource(R.drawable.bball);
                    //changes ball color
                }
            }
        });
        btnfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 5;
                    team_a_score.setText(Ascore+"");
                    teamAstack.push(5);
                }
                else {
                    Bscore += 5;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(5);
                }
                if(balls != 5){
                    balls+=1;
                    newballs +=0.1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    if(balls == 1){
                        blackballone.setImageResource(R.drawable.rball);
                    }
                    if(balls == 2){
                        blackballtwo.setImageResource(R.drawable.rball);
                    }
                    if(balls == 3){
                        blackballthree.setImageResource(R.drawable.rball);
                    }
                    if(balls == 4){
                        blackballfour.setImageResource(R.drawable.rball);
                    }
                    if(balls == 5){
                        blackballfive.setImageResource(R.drawable.rball);
                    }
                }
                else{
                    balls = 0;
                    newballs = 0;
                    overs +=1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    blackballone.setImageResource(R.drawable.bball);
                    blackballtwo.setImageResource(R.drawable.bball);
                    blackballthree.setImageResource(R.drawable.bball);
                    blackballfour.setImageResource(R.drawable.bball);
                    blackballfive.setImageResource(R.drawable.bball);
                    blackballsix.setImageResource(R.drawable.bball);
                    //changes ball color
                }
            }
        });
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    aouts += 1;
                    outnumb.setText(aouts+"");
                    teamAstack.push(lastballout);
                }
                else {
                    bouts += 1;
                    outnumb.setText(bouts + "");
                    teamBstack.push(lastballout);
                }

                if(balls != 5){
                    balls+=1;
                    newballs +=0.1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    if(balls == 1){
                        blackballone.setImageResource(R.drawable.rball);
                    }
                    if(balls == 2){
                        blackballtwo.setImageResource(R.drawable.rball);
                    }
                    if(balls == 3){
                        blackballthree.setImageResource(R.drawable.rball);
                    }
                    if(balls == 4){
                        blackballfour.setImageResource(R.drawable.rball);
                    }
                    if(balls == 5){
                        blackballfive.setImageResource(R.drawable.rball);
                    }
                }
                else{
                    balls = 0;
                    newballs -= 0.5;
                    overs +=1;
                    newovers = overs + newballs;
                    over_numb.setText(newovers+"");
                    blackballone.setImageResource(R.drawable.bball);
                    blackballtwo.setImageResource(R.drawable.bball);
                    blackballthree.setImageResource(R.drawable.bball);
                    blackballfour.setImageResource(R.drawable.bball);
                    blackballfive.setImageResource(R.drawable.bball);
                    blackballsix.setImageResource(R.drawable.bball);
                    //changes ball color
                }
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isTeamABatting) {
                if (!teamAstack.empty()) {
                    lastval = teamAstack.pop();
                    if (lastval == 39 || lastval == 99) {
                        if (lastval == 39) {
                            lastval = teamAstack.pop();
                            Ascore = Ascore - lastval;
                            team_a_score.setText(Ascore + "");
                            return;
                        } else {
                            aouts -= 1;
                            outnumb.setText(aouts + "");
                            if (balls == 0) {
                                blackballone.setImageResource(R.drawable.rball);
                                blackballtwo.setImageResource(R.drawable.rball);
                                blackballthree.setImageResource(R.drawable.rball);
                                blackballfour.setImageResource(R.drawable.rball);
                                blackballfive.setImageResource(R.drawable.rball);
                                blackballsix.setImageResource(R.drawable.bball);
                                newballs += 0.5;
                                balls = 5;
                                overs -= 1;
                                newovers = overs + newballs;
                                over_numb.setText(newovers + "");
                            } else if (balls == 1) {
                                blackballone.setImageResource(R.drawable.bball);
                                newballs -= 0.1;
                                balls = 0;
                                newovers = overs + newballs;
                                over_numb.setText(newovers + "");
                            } else if (balls == 2) {
                                blackballtwo.setImageResource(R.drawable.bball);
                                newballs -= 0.1;
                                balls = 1;
                                newovers = overs + newballs;
                                over_numb.setText(newovers + "");
                            } else if (balls == 3) {
                                blackballthree.setImageResource(R.drawable.bball);
                                newballs -= 0.1;
                                newovers = overs + newballs;
                                balls = 2;
                                over_numb.setText(newovers + "");
                            } else if (balls == 4) {
                                blackballfour.setImageResource(R.drawable.bball);
                                newballs -= 0.1;
                                balls = 3;
                                newovers = overs + newballs;
                                over_numb.setText(newovers + "");
                            } else if (balls == 5) {
                                blackballfive.setImageResource(R.drawable.bball);
                                newballs -= 0.1;
                                balls = 4;
                                newovers = overs + newballs;
                                over_numb.setText(newovers + "");
                            }
                            return;
                        }
                    }
                    lastval = lastval * makeneg;
                    Ascore = Ascore + lastval;
                    team_a_score.setText(Ascore + "");
                    //to revert the balls
                    if (balls == 0) {
                        blackballone.setImageResource(R.drawable.rball);
                        blackballtwo.setImageResource(R.drawable.rball);
                        blackballthree.setImageResource(R.drawable.rball);
                        blackballfour.setImageResource(R.drawable.rball);
                        blackballfive.setImageResource(R.drawable.rball);
                        blackballsix.setImageResource(R.drawable.bball);
                        newballs += 0.5;
                        balls = 5;
                        overs -= 1;
                        newovers = overs + newballs;
                        over_numb.setText(newovers + "");
                    } else if (balls == 1) {
                        blackballone.setImageResource(R.drawable.bball);
                        newballs = 0;
                        balls = 0;
                        newovers = overs + newballs;
                        over_numb.setText(newovers + "");
                    } else if (balls == 2) {
                        blackballtwo.setImageResource(R.drawable.bball);
                        newballs -= 0.1;
                        balls = 1;
                        newovers = overs + newballs;
                        over_numb.setText(newovers + "");
                    } else if (balls == 3) {
                        blackballthree.setImageResource(R.drawable.bball);
                        newballs -= 0.1;
                        newovers = overs + newballs;
                        balls = 2;
                        over_numb.setText(newovers + "");
                    } else if (balls == 4) {
                        blackballfour.setImageResource(R.drawable.bball);
                        newballs -= 0.1;
                        balls = 3;
                        newovers = overs + newballs;
                        over_numb.setText(newovers + "");
                    } else if (balls == 5) {
                        blackballfive.setImageResource(R.drawable.bball);
                        newballs -= 0.1;
                        balls = 4;
                        newovers = overs + newballs;
                        over_numb.setText(newovers + "");
                    }
                }
            }
            else{
                    if (!teamBstack.empty()) {
                        lastval = teamBstack.pop();
                        if (lastval == 39 || lastval == 99) {
                            if (lastval == 39) {
                                lastval = teamBstack.pop();
                                Bscore = Bscore - lastval;
                                team_b_score.setText(Bscore + "");
                                return;
                            } else {
                                bouts -= 1;
                                outnumb.setText(bouts + "");
                                if (balls == 0) {
                                    blackballone.setImageResource(R.drawable.rball);
                                    blackballtwo.setImageResource(R.drawable.rball);
                                    blackballthree.setImageResource(R.drawable.rball);
                                    blackballfour.setImageResource(R.drawable.rball);
                                    blackballfive.setImageResource(R.drawable.rball);
                                    blackballsix.setImageResource(R.drawable.bball);
                                    newballs += 0.5;
                                    balls = 5;
                                    overs -= 1;
                                    newovers = overs + newballs;
                                    over_numb.setText(newovers + "");
                                } else if (balls == 1) {
                                    blackballone.setImageResource(R.drawable.bball);
                                    newballs -= 0.1;
                                    balls = 0;
                                    newovers = overs + newballs;
                                    over_numb.setText(newovers + "");
                                } else if (balls == 2) {
                                    blackballtwo.setImageResource(R.drawable.bball);
                                    newballs -= 0.1;
                                    balls = 1;
                                    newovers = overs + newballs;
                                    over_numb.setText(newovers + "");
                                } else if (balls == 3) {
                                    blackballthree.setImageResource(R.drawable.bball);
                                    newballs -= 0.1;
                                    newovers = overs + newballs;
                                    balls = 2;
                                    over_numb.setText(newovers + "");
                                } else if (balls == 4) {
                                    blackballfour.setImageResource(R.drawable.bball);
                                    newballs -= 0.1;
                                    balls = 3;
                                    newovers = overs + newballs;
                                    over_numb.setText(newovers + "");
                                } else if (balls == 5) {
                                    blackballfive.setImageResource(R.drawable.bball);
                                    newballs -= 0.1;
                                    balls = 4;
                                    newovers = overs + newballs;
                                    over_numb.setText(newovers + "");
                                }
                                return;
                            }
                        }
                        lastval = lastval * makeneg;
                        Bscore = Bscore + lastval;
                        team_b_score.setText(Bscore + "");
                        //to revert the balls
                        if (balls == 0) {
                            blackballone.setImageResource(R.drawable.rball);
                            blackballtwo.setImageResource(R.drawable.rball);
                            blackballthree.setImageResource(R.drawable.rball);
                            blackballfour.setImageResource(R.drawable.rball);
                            blackballfive.setImageResource(R.drawable.rball);
                            blackballsix.setImageResource(R.drawable.bball);
                            newballs += 0.5;
                            balls = 5;
                            overs -= 1;
                            newovers = overs + newballs;
                            over_numb.setText(newovers + "");
                        } else if (balls == 1) {
                            blackballone.setImageResource(R.drawable.bball);
                            newballs = 0;
                            balls = 0;
                            newovers = overs + newballs;
                            over_numb.setText(newovers + "");
                        } else if (balls == 2) {
                            blackballtwo.setImageResource(R.drawable.bball);
                            newballs -= 0.1;
                            balls = 1;
                            newovers = overs + newballs;
                            over_numb.setText(newovers + "");
                        } else if (balls == 3) {
                            blackballthree.setImageResource(R.drawable.bball);
                            newballs -= 0.1;
                            newovers = overs + newballs;
                            balls = 2;
                            over_numb.setText(newovers + "");
                        } else if (balls == 4) {
                            blackballfour.setImageResource(R.drawable.bball);
                            newballs -= 0.1;
                            balls = 3;
                            newovers = overs + newballs;
                            over_numb.setText(newovers + "");
                        } else if (balls == 5) {
                            blackballfive.setImageResource(R.drawable.bball);
                            newballs -= 0.1;
                            balls = 4;
                            newovers = overs + newballs;
                            over_numb.setText(newovers + "");
                        }
                    }
                }
            }
        });

    }
}
