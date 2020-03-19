package com.example.dicerollerapp.Utilities.BottleSpinner;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.dicerollerapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;

public class BottleSpinner extends AppCompatActivity {

    private ImageView bottle;
    private Random random = new Random();
    private int lastDir;
    private boolean spinning;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle_spinner);

        loadAd();

        bottle = findViewById(R.id.bottle);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
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
                public void onAnimationRepeat(Animation animation) { }
            });

            lastDir = newDir;
            bottle.startAnimation(rotate);
        }
    }

    private void loadAd() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build());
    }
}
