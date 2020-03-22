package com.gametools.Activities.BottleSpinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.gametools.MainMenu;
import com.example.gametools.R;
import com.gametools.Util.OnSwipeTouchListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

public class BottleSpinner extends AppCompatActivity {

    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;
    private InterstitialAd mInterstitialAd;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle_spinner);

        layout = findViewById(R.id.bottle_spinner_layout);
        bottle = findViewById(R.id.bottle);

        layout.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeRight() {
                Intent intent = new Intent(BottleSpinner.this, MainMenu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                if (mInterstitialAd.isLoaded())
                    mInterstitialAd.show();
            }
        });

        loadAd();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        if (mInterstitialAd.isLoaded())
            mInterstitialAd.show();
    }

    public void spinBottle(View v) {
        if (!spinning) {
            final MediaPlayer mp = MediaPlayer.create(this, R.raw.bottle_spinning_sfx);
            mp.start();

            int newDir = random.nextInt(2000) + 1000;
            float pivotX = bottle.getWidth() / 2;
            float pivotY = bottle.getHeight() / 2;

            Animation rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(3000);
            rotate.setFillAfter(true);

            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                    mp.stop();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });

            lastDir = newDir;
            bottle.startAnimation(rotate);
        }
    }

    private void loadAd() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1244092820470940/8341011256");
        mInterstitialAd.loadAd(new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build());
    }
}
