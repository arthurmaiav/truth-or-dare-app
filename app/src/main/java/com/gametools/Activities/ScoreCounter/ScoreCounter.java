package com.gametools.Activities.ScoreCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.gametools.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class ScoreCounter extends AppCompatActivity {

    private TextView rightSideTV;
    private TextView leftSideTV;
    private int rightSidePoints = 0;
    private int leftSidePoints = 0;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_counter);

        rightSideTV = findViewById(R.id.right_side_score);
        leftSideTV = findViewById(R.id.left_side_score);

        loadAd();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        if (mInterstitialAd.isLoaded())
            mInterstitialAd.show();
    }

    public void rightSidePoint(View v) {
        rightSidePoints++;
        rightSideTV.setText(String.valueOf(rightSidePoints));
    }

    public void leftSidePoint(View v) {
        leftSidePoints++;
        leftSideTV.setText(String.valueOf(leftSidePoints));
    }

    public void refreshScore(View v) {
        rightSidePoints = 0;
        leftSidePoints = 0;
        rightSideTV.setText(String.valueOf(rightSidePoints));
        leftSideTV.setText(String.valueOf(leftSidePoints));
    }

    private void loadAd() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1244092820470940/6477265244");
        mInterstitialAd.loadAd(new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build());
    }
}
