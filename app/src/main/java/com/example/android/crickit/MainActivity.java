package com.example.android.crickit;

import android.content.Intent;
import android.support.annotation.Nullable;
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
    Button   btnfour, btnsix, btnwide, btnreset, btnone,btntwo,btnthree,btnfive,btnnoball,btnout,btnend;
    ToggleButton btnwhobats;
    ImageView team_a_bat_image, team_b_bat_image, blackballone,blackballtwo,blackballthree,blackballfour,blackballfive,blackballsix;
    int Ascore = 0;
    int Bscore = 0;
    int balls = 0;
    int balls_int_a =0;
    int balls_int_b =0;
    int aouts = 0;
    int lastballout = 99;
    int lastballwide = 39;
    int makeneg = -1;
    int lastval;
    int truthval = 55;
    int bouts = 0;

    float aballs = 0;
    float bballs = 0;
    int aovers =0;
    int bovers =0;

    float newovers = 0;
    boolean isTeamABatting = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team_a_score =  findViewById(R.id.team_a_score);
        team_b_score =  findViewById(R.id.team_b_score);
        btnend = findViewById(R.id.btnend);
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
//                    outnumb.setText(aouts+"");
//                    newovers = aovers + aballs;
//                    over_numb.setText(newovers + "");
                }
                else {
                    team_a_bat_image.setVisibility(View.VISIBLE);
                    team_b_bat_image.setVisibility(View.INVISIBLE);
                    isTeamABatting = true;
//                    outnumb.setText(bouts+"");
//                    newovers = bovers + bballs;
//                    over_numb.setText(newovers + "");
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
                if (isTeamABatting) {
                    Ascore += 4;
                    team_a_score.setText(Ascore + "");
                    teamAstack.push(4);
                    if (aballs != 0.5) {
                        balls += 1;
                        balls_int_a +=1;
                        aballs += 0.1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_a == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        balls_int_a =0;
                        aballs = 0;
                        aovers += 1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);

                    }
                } else {
                    Bscore += 4;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(4);
                    if (bballs != 0.5) {
                        balls += 1;
                        balls_int_b +=1;
                        bballs += 0.1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_b == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        bballs = 0;
                        balls_int_b =0;
                        bovers += 1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);
                    }

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
                    if (aballs != 0.5) {
                        balls += 1;
                        balls_int_a +=1;
                        aballs += 0.1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_a == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        aballs = 0;
                        balls_int_a = 0;
                        aovers += 1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);

                    }
                }
                else {
                    Bscore += 6;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(6);
                    if (bballs != 0.5) {
                        balls += 1;
                        balls_int_b +=1;
                        bballs += 0.1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_b == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        bballs = 0;
                        balls_int_b = 0;
                        bovers += 1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);
                    }
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

        //New Code for runs
        btnone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTeamABatting) {
                    Ascore += 1;
                    team_a_score.setText(Ascore+"");
                    teamAstack.push(1);
                    if (aballs != 0.5) {
                        balls += 1;
                        balls_int_a +=1;
                        aballs += 0.1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_a == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        aballs = 0;
                        balls_int_a =0;
                        aovers += 1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);

                    }
                }
                else {
                    Bscore += 1;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(1);
                    if (bballs != 0.5) {
                        balls += 1;
                        bballs += 0.1;
                        balls_int_b +=1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_b == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        bballs = 0;
                        balls_int_b = 0;
                        bovers += 1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);
                    }
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
                    if (aballs != 0.5) {
                        balls += 1;
                        aballs += 0.1;
                        balls_int_a +=1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_a == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        aballs = 0;
                        balls_int_a = 0;
                        aovers += 1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);

                    }
                }
                else {
                    Bscore += 2;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(2);
                    if (bballs != 0.5) {
                        balls += 1;
                        bballs += 0.1;
                        balls_int_b +=1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_b == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }

                    } else {
                        balls = 0;
                        bballs = 0;
                        balls_int_b = 0;
                        bovers += 1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);
                    }
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
                    if (aballs != 0.5) {
                        balls += 1;
                        balls_int_a +=1;
                        aballs += 0.1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_a == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        aballs = 0;
                        balls_int_a = 0;
                        aovers += 1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);

                    }
                }
                else {
                    Bscore += 3;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(3);
                    if (bballs != 0.5) {
                        balls += 1;
                        balls_int_b +=1;
                        bballs += 0.1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_b == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        bballs = 0;
                        balls_int_b = 0;
                        bovers += 1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);
                    }
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
                    if (aballs != 0.5) {
                        balls += 1;
                        aballs += 0.1;
                        balls_int_a +=1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_a == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        aballs = 0;
                        balls_int_a =0;
                        aovers += 1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);

                    }
                }
                else {
                    Bscore += 5;
                    team_b_score.setText(Bscore + "");
                    teamBstack.push(5);
                    if (bballs != 0.5) {
                        balls += 1;
                        bballs += 0.1;
                        balls_int_b +=1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_b == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        bballs = 0;
                        bovers += 1;
                        balls_int_b =0;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);
                    }
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
                    if (aballs != 0.5) {
                        balls += 1;
                        aballs += 0.1;
                        balls_int_a +=1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_a == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_a == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        aballs = 0;
                        aovers += 1;
                        balls_int_a =0;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);

                    }

                }
                else {
                    bouts += 1;
                    outnumb.setText(bouts + "");
                    teamBstack.push(lastballout);
                    if (bballs != 0.5) {
                        balls += 1;
                        balls_int_b +=1;
                        bballs += 0.1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        if (balls_int_b == 1) {
                            blackballone.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 2) {
                            blackballtwo.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 3) {
                            blackballthree.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 4) {
                            blackballfour.setImageResource(R.drawable.rball);
                        }
                        if (balls_int_b == 5) {
                            blackballfive.setImageResource(R.drawable.rball);
                        }


                    } else {
                        balls = 0;
                        bballs = 0;
                        balls_int_b =0;
                        bovers += 1;
                        newovers = bovers + bballs;
                        over_numb.setText(newovers + "");
                        blackballone.setImageResource(R.drawable.bball);
                        blackballtwo.setImageResource(R.drawable.bball);
                        blackballthree.setImageResource(R.drawable.bball);
                        blackballfour.setImageResource(R.drawable.bball);
                        blackballfive.setImageResource(R.drawable.bball);
                        blackballsix.setImageResource(R.drawable.bball);
                    }
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
                            teamAstack.push(39);
                            return;
                        } else {
                            aouts -= 1;
                            outnumb.setText(aouts + "");
                            teamAstack.push(99);
                            if (aballs == 0) {
                                blackballone.setImageResource(R.drawable.rball);
                                blackballtwo.setImageResource(R.drawable.rball);
                                blackballthree.setImageResource(R.drawable.rball);
                                blackballfour.setImageResource(R.drawable.rball);
                                blackballfive.setImageResource(R.drawable.rball);
                                blackballsix.setImageResource(R.drawable.bball);
                                aballs += 0.5;
                                balls = 5;
                                aovers -= 1;
                                newovers = aovers + aballs;
                                over_numb.setText(newovers + "");
                            } else if (aballs == 0.1) {
                                blackballone.setImageResource(R.drawable.bball);
                                aballs -= 0.1;
                                balls = 0;
                                newovers = aovers + aballs;
                                over_numb.setText(newovers + "");
                            } else if (aballs == 0.2) {
                                blackballtwo.setImageResource(R.drawable.bball);
                                aballs -= 0.1;
                                balls = 1;
                                newovers = aovers + aballs;
                                over_numb.setText(newovers + "");
                            } else if (aballs == 0.3) {
                                blackballthree.setImageResource(R.drawable.bball);
                                aballs -= 0.1;
                                newovers = aovers + aballs;
                                balls = 2;
                                over_numb.setText(newovers + "");
                            } else if (aballs == 0.4) {
                                blackballfour.setImageResource(R.drawable.bball);
                                aballs -= 0.1;
                                balls = 3;
                                newovers = aovers + aballs;
                                over_numb.setText(newovers + "");
                            } else if (aballs == 0.5) {
                                blackballfive.setImageResource(R.drawable.bball);
                                aballs -= 0.1;
                                balls = 4;
                                newovers = aovers + aballs;
                                over_numb.setText(newovers + "");
                            }
                            return;
                        }
                    }
                    lastval = lastval * makeneg;
                    Ascore = Ascore + lastval;
                    team_a_score.setText(Ascore + "");
                    //to revert the balls
                    if (aballs == 0) {
                        blackballone.setImageResource(R.drawable.rball);
                        blackballtwo.setImageResource(R.drawable.rball);
                        blackballthree.setImageResource(R.drawable.rball);
                        blackballfour.setImageResource(R.drawable.rball);
                        blackballfive.setImageResource(R.drawable.rball);
                        blackballsix.setImageResource(R.drawable.bball);
                        aballs += 0.5;
                        balls = 5;
                        aovers -= 1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                    } else if (aballs == 0.1) {
                        blackballone.setImageResource(R.drawable.bball);
                        aballs = 0;
                        balls = 0;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                    } else if (aballs == 0.2) {
                        blackballtwo.setImageResource(R.drawable.bball);
                        aballs -= 0.1;
                        balls = 1;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                    } else if (aballs == 0.3) {
                        blackballthree.setImageResource(R.drawable.bball);
                        aballs -= 0.1;
                        newovers = aovers + aballs;
                        balls = 2;
                        over_numb.setText(newovers + "");
                    } else if (aballs == 0.4) {
                        blackballfour.setImageResource(R.drawable.bball);
                        aballs -= 0.1;
                        balls = 3;
                        newovers = aovers + aballs;
                        over_numb.setText(newovers + "");
                    } else if (aballs == 0.5) {
                        blackballfive.setImageResource(R.drawable.bball);
                        aballs -= 0.1;
                        balls = 4;
                        newovers = aovers + aballs;
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
                                teamBstack.push(39);
                                return;
                            } else {
                                bouts -= 1;
                                outnumb.setText(bouts + "");
                                teamBstack.push(99);
                                if (bballs == 0) {
                                    blackballone.setImageResource(R.drawable.rball);
                                    blackballtwo.setImageResource(R.drawable.rball);
                                    blackballthree.setImageResource(R.drawable.rball);
                                    blackballfour.setImageResource(R.drawable.rball);
                                    blackballfive.setImageResource(R.drawable.rball);
                                    blackballsix.setImageResource(R.drawable.bball);
                                    bballs += 0.5;
                                    balls = 5;
                                    bovers -= 1;
                                    newovers = bovers + bballs;
                                    over_numb.setText(newovers + "");
                                } else if (bballs == 0.1) {
                                    blackballone.setImageResource(R.drawable.bball);
                                    bballs -= 0.1;
                                    balls = 0;
                                    newovers = bovers + bballs;
                                    over_numb.setText(newovers + "");
                                } else if (bballs == 0.2) {
                                    blackballtwo.setImageResource(R.drawable.bball);
                                    bballs -= 0.1;
                                    balls = 1;
                                    newovers = bovers + bballs;
                                    over_numb.setText(newovers + "");
                                } else if (bballs == 0.3) {
                                    blackballthree.setImageResource(R.drawable.bball);
                                    bballs -= 0.1;
                                    newovers = bovers + bballs;
                                    balls = 2;
                                    over_numb.setText(newovers + "");
                                } else if (bballs == 0.4) {
                                    blackballfour.setImageResource(R.drawable.bball);
                                    bballs -= 0.1;
                                    balls = 3;
                                    newovers = bovers + bballs;
                                    over_numb.setText(newovers + "");
                                } else if (bballs == 0.5) {
                                    blackballfive.setImageResource(R.drawable.bball);
                                    bballs -= 0.1;
                                    balls = 4;
                                    newovers = bovers + bballs;
                                    over_numb.setText(newovers + "");
                                }
                                return;
                            }
                        }
                        lastval = lastval * makeneg;
                        Bscore = Bscore + lastval;
                        team_b_score.setText(Bscore + "");
                        //to revert the balls
                        if (bballs == 0) {
                            blackballone.setImageResource(R.drawable.rball);
                            blackballtwo.setImageResource(R.drawable.rball);
                            blackballthree.setImageResource(R.drawable.rball);
                            blackballfour.setImageResource(R.drawable.rball);
                            blackballfive.setImageResource(R.drawable.rball);
                            blackballsix.setImageResource(R.drawable.bball);
                            bballs += 0.5;
                            balls = 5;
                            bovers -= 1;
                            newovers = bovers + bballs;
                            over_numb.setText(newovers + "");
                        } else if (bballs == 0.1) {
                            blackballone.setImageResource(R.drawable.bball);
                            bballs = 0;
                            balls = 0;
                            newovers = bovers + bballs;
                            over_numb.setText(newovers + "");
                        } else if (bballs == 0.2) {
                            blackballtwo.setImageResource(R.drawable.bball);
                            bballs -= 0.1;
                            balls = 1;
                            newovers = bovers + bballs;
                            over_numb.setText(newovers + "");
                        } else if (bballs == 0.3) {
                            blackballthree.setImageResource(R.drawable.bball);
                            bballs -= 0.1;
                            newovers = bovers + bballs;
                            balls = 2;
                            over_numb.setText(newovers + "");
                        } else if (bballs == 0.4) {
                            blackballfour.setImageResource(R.drawable.bball);
                            bballs -= 0.1;
                            balls = 3;
                            newovers = bovers + bballs;
                            over_numb.setText(newovers + "");
                        } else if (bballs == 0.5) {
                            blackballfive.setImageResource(R.drawable.bball);
                            bballs -= 0.1;
                            balls = 4;
                            newovers = bovers + bballs;
                            over_numb.setText(newovers + "");
                        }
                    }
                }
            }
        });

            btnend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,GameReview.class);
                    intent.putExtra("stack1",teamAstack);
                    intent.putExtra("stack2",teamBstack);
                    intent.putExtra("teamAScore", Ascore);
                    intent.putExtra("teamBScore", Bscore);
                    intent.putExtra("teamOneName", nameayy.getText());
                    intent.putExtra("teamTwoName", namebay.getText());
                    startActivity(intent);
                }
            });
    }
}
