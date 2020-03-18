package com.example.dicerollerapp.Utilities.ScoreCounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dicerollerapp.R;

public class ScoreCounter extends AppCompatActivity {

    LinearLayout mainLayout;
    TextView rightSideTV;
    TextView leftSideTV;
    int rightSidePoints = 0;
    int leftSidePoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_counter);

        mainLayout = findViewById(R.id.main_layout);
        rightSideTV = findViewById(R.id.right_side_score);
        leftSideTV = findViewById(R.id.left_side_score);

    }

    public void rightSidePoint(View v) {
        rightSidePoints++;
        rightSideTV.setText(String.valueOf(rightSidePoints));
    }

    public void leftSidePoint(View v) {
        leftSidePoints++;
        leftSideTV.setText(String.valueOf(leftSidePoints));
    }
}
