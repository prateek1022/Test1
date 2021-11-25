package com.iap.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main_game extends AppCompatActivity {
    TextView your_score,highest_score_tv,machine_score_tv;
    Integer highest_score,current_score=0;
    Button rock,paper,sci;
    String name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        your_score=findViewById(R.id.your_score);
        highest_score_tv=findViewById(R.id.highest_score);
        rock=findViewById(R.id.rock);
        paper=findViewById(R.id.paper);
        sci=findViewById(R.id.scissors);
        machine_score_tv=findViewById(R.id.machine);

        SharedPreferences prefs = getSharedPreferences("MY_PREF", MODE_PRIVATE);
        name = prefs.getString("name", "No name defined");
        highest_score = prefs.getInt("highest", 0);
        your_score.setText(name+"'s Score: --");
        highest_score_tv.setText("Highest Score:  "+highest_score);

        rock.setOnClickListener(v->{
            Integer user=play_game(1);
            result(user);
            System.out.println(user+" machine");
        });
        paper.setOnClickListener(v->{
            Integer user=play_game(2);
            result(user);
            System.out.println(user+" machine");
        });
        sci.setOnClickListener(v->{
            Integer user=play_game(3);
            result(user);
            System.out.println(user+" user");
        });
    }

    public Integer play_game(Integer user){
        Random ran = new Random();
        int machine = ran.nextInt(3) + 1;
        System.out.println(user+" uuuser");
        System.out.println(machine+" machine");
        switch (machine){
            case 1:machine_score_tv.setText("ROCK");
            break;
            case 2:machine_score_tv.setText("PAPER");
            break;
            case 3:machine_score_tv.setText("SCISSORS");
            break;
        }
        if(user==machine){
            return 0;
        }
        else if(user<machine) {
            return 666;
        }
        else{
            return 888;
        }
    }

    public void result(Integer res){
        if(res==888) {
            //user won
            Toast.makeText(this, name+" has won!!!!!", Toast.LENGTH_SHORT).show();
            current_score++;
            your_score.setText(name+"'s Score:  "+current_score);
            if(current_score>highest_score){
                highest_score_tv.setText("Highest Score:  "+current_score);
            }
        }
        else if(res==666){
            //computer won
            current_score=0;
            your_score.setText(name+"'s Score:  "+current_score);
            Toast.makeText(this, "Computer win!!!!!\nYOU LOOSE", Toast.LENGTH_SHORT).show();
        }
        else{
            //draw
            Toast.makeText(this, "Its a DRAW!!!!!!", Toast.LENGTH_SHORT).show();
        }
    }

}