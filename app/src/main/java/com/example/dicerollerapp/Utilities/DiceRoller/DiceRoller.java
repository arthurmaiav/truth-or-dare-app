package com.example.dicerollerapp.Utilities.DiceRoller;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.dicerollerapp.R;

import java.util.Random;

public class DiceRoller extends AppCompatActivity {

    private ImageView imageViewDice;
    private Random rng = new Random();

    private boolean rolling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);

        imageViewDice = findViewById(R.id.image_view_dice);
        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        rollDiceAnimation();
        int randomNumber = rng.nextInt(6) + 1; //Numero aleatorio de 1 a 6
        switch (randomNumber) {
            case 1:
                imageViewDice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.dice6);
                break;
        }
    }

    public void rollDiceAnimation() {
        if (!rolling) {
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_roll_sfx);
            mp.start();

            float pivotX = imageViewDice.getWidth() / 2;
            float pivotY = imageViewDice.getHeight() / 2;

            Animation rotate = new RotateAnimation(0,360, pivotX, pivotY);
            rotate.setDuration(300);
            rotate.setFillAfter(true);

            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    rolling = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    rolling = false;
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });

            imageViewDice.startAnimation(rotate);
        }
    }
}