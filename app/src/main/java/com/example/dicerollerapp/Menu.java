package com.example.dicerollerapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dicerollerapp.BottleSpinner.BottleSpinner;
import com.example.dicerollerapp.DiceRoller.DiceRoller;
import com.example.dicerollerapp.RecyclerMenu.ItemMenu;
import com.example.dicerollerapp.RecyclerMenu.RVItemMenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    private List<ItemMenu> itens;

    private void initializeData() {
        itens = new ArrayList<>();
        itens.add(new ItemMenu("Dice Roller", R.drawable.dice2, DiceRoller.class));
        itens.add(new ItemMenu("Bottle Spinner", R.drawable.bottle, BottleSpinner.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initializeData();

        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        RVItemMenuAdapter adapter = new RVItemMenuAdapter(itens);
        rv.setAdapter(adapter);
    }

}
