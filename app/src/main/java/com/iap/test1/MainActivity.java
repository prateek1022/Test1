package com.iap.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Ro-Pe-Si");
        et=findViewById(R.id.name_et);
        bt=findViewById(R.id.bt);

        bt.setOnClickListener(v->{
            SharedPreferences.Editor editor = getSharedPreferences("MY_PREF", MODE_PRIVATE).edit();
            editor.putString("name", et.getText().toString());
            editor.apply();
            startActivity(new Intent(MainActivity.this,Main_game.class));
        });
    }
}