package com.example.dicerollerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dicerollerapp.BottleSpinner.BottleSpinner;
import com.example.dicerollerapp.DiceRoller.DiceRoller;

import java.util.List;

public class Menu extends AppCompatActivity {

    List<ItemMenu> listaItensMenu;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void MenuAdapter(List<ItemMenu> listaItensMenu, Context context) {
        this.listaItensMenu = listaItensMenu;
        this.context = context;
    }
}

//    @Override
//    public void onClick(View v) {
//        if (v == buttonDiceRoller)
//            startActivity(new Intent(this, DiceRoller.class));
//        else if (v == buttonBottleSpinner)
//            startActivity(new Intent(this, BottleSpinner.class));
//    }
//}

