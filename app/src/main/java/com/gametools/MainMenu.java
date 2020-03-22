package com.gametools;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gametools.R;
import com.gametools.Activities.BottleSpinner.BottleSpinner;
import com.gametools.Activities.DiceRoller.DiceRoller;
import com.gametools.MenuItem.ItemMenu;
import com.gametools.MenuItem.RVItemMenuAdapter;
import com.gametools.Activities.ScoreCounter.ScoreCounter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {

    private List<ItemMenu> itens;
    private CardView itemCard;

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

        itemCard = findViewById(R.id.cv);

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