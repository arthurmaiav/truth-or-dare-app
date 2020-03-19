package com.example.dicerollerapp.Utilities.ScoreCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dicerollerapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class ScoreCounter extends AppCompatActivity {

    private TextView rightSide;
    private TextView leftSide;
    private int rightSidePoints = 0;
    private int leftSidePoints = 0;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_counter);

        loadAd();

        rightSide = findViewById(R.id.right_side_score);
        leftSide = findViewById(R.id.left_side_score);
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

    public void rightSidePoint(View v) {
        rightSidePoints++;
        rightSide.setText(String.valueOf(rightSidePoints));
    }

    public void leftSidePoint(View v) {
        leftSidePoints++;
        leftSide.setText(String.valueOf(leftSidePoints));
    }

    public void refreshScore(View v) {
        rightSidePoints = 0;
        leftSidePoints = 0;
        rightSide.setText(String.valueOf(rightSidePoints));
        leftSide.setText(String.valueOf(leftSidePoints));
    }

    private void loadAd() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build());
    }
}
