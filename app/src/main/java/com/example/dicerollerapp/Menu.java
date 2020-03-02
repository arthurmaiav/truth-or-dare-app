package com.example.dicerollerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dicerollerapp.BottleSpinner.BottleSpinner;
import com.example.dicerollerapp.DiceRoller.DiceRoller;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    Button buttonDiceRoller;
    Button buttonBottleSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonDiceRoller = findViewById(R.id.buttonDiceRoller);
        buttonBottleSpinner = findViewById(R.id.buttonBottleSpinner);

        buttonDiceRoller.setOnClickListener(this);
        buttonBottleSpinner.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == buttonDiceRoller)
            startActivity(new Intent(this, DiceRoller.class));
        else if (v == buttonBottleSpinner)
            startActivity(new Intent(this, BottleSpinner.class));
    }
}

