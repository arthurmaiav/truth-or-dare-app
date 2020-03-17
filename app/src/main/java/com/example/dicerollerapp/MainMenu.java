package com.example.dicerollerapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dicerollerapp.Utilities.BottleSpinner.BottleSpinner;
import com.example.dicerollerapp.Utilities.DiceRoller.DiceRoller;
import com.example.dicerollerapp.MenuItem.ItemMenu;
import com.example.dicerollerapp.MenuItem.RVItemMenuAdapter;
import com.example.dicerollerapp.Utilities.ScoreCounter.ScoreCounter;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {

    private List<ItemMenu> itens;

    private void initializeData() {
        itens = new ArrayList<>();
        itens.add(new ItemMenu("Dice Roller", R.drawable.dice2, DiceRoller.class));
        itens.add(new ItemMenu("Bottle Spinner", R.drawable.bottle, BottleSpinner.class));
        itens.add(new ItemMenu("Score Counter", R.drawable.score_icon, ScoreCounter.class));
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
