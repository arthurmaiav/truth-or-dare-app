package com.example.dicerollerapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dicerollerapp.Activities.BottleSpinner.BottleSpinner;
import com.example.dicerollerapp.Activities.DiceRoller.DiceRoller;
import com.example.dicerollerapp.MenuItem.ItemMenu;
import com.example.dicerollerapp.MenuItem.RVItemMenuAdapter;
import com.example.dicerollerapp.Activities.ScoreCounter.ScoreCounter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

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

        loadAd();

        initializeData();

        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        RVItemMenuAdapter adapter = new RVItemMenuAdapter(itens);
        rv.setAdapter(adapter);
    }

    private void loadAd() {
        AdView adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        adView.loadAd(adRequest);
    }

}