package com.example.android.courtcounter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreLakers = 0; // Sets Laker's initial score to zero
    int scoreCeltics = 0; // Sets Celtic's inital score to zero

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets references to the ImageViews
        ImageView LakersImg = (ImageView)findViewById(R.id.lakersImageView);
        ImageView CelticsImg = (ImageView)findViewById(R.id.celticsImageView);

        // Sets the animation
        Animation floatingLakers = AnimationUtils.loadAnimation(this, R.anim.floatinglakers);
        Animation floatingCeltics = AnimationUtils.loadAnimation(this, R.anim.floatingceltics);

        // Sets animations to the ImageViews
        LakersImg.startAnimation(floatingLakers);
        CelticsImg.startAnimation(floatingCeltics);

        displayForLakers(0);
        displayForCeltics(0);
    }

    /***************************************
     * Laker's Scores Board
     * @param score Displays Laker's scores
     * *************************************/
    public void displayForLakers(int score) {
        TextView scoreView = (TextView) findViewById(R.id.lakers_score_txtview);
        scoreView.setText(String.valueOf(score));
        totalScores();
    }

    /****************************************
     * Celtics Score Board
     * @param score Displays Celtics's scores
     ****************************************/
    public void displayForCeltics(int score) {
        TextView scoreView = (TextView) findViewById(R.id.celtics_score_txtview);
        scoreView.setText(String.valueOf(score));
        totalScores();
    }

    /********* Beginning of Lakers's score buttons **********************/
    public void addThreeForLakers(View view) {
        scoreLakers = scoreLakers + 3;
        displayForLakers(scoreLakers);
    }

    public void addTwoForLakers(View view) {
        scoreLakers = scoreLakers + 2;
        displayForLakers(scoreLakers);
    }

    public void addOneForLakers(View view) {
        scoreLakers = scoreLakers + 1;
        displayForLakers(scoreLakers);
    }
    /********* Ending of Lakers's score buttons **********************/



    /********* Beginning of Celtics's score buttons **********************/
    public void addThreeForCeltics(View view) {
        scoreCeltics = scoreCeltics + 3;
        displayForCeltics(scoreCeltics);
    }

    public void addTwoForCeltics(View view) {
        scoreCeltics = scoreCeltics + 2;
        displayForCeltics(scoreCeltics);
    }

    public void addOneForCeltics(View view) {
        scoreCeltics = scoreCeltics + 1;
        displayForCeltics(scoreCeltics);
    }
    /********* Ending of Celtics's score buttons **********************/



    /******* Resets scores for both teams **************/
    public void setBothTeamsToZero(View view) {
        scoreLakers = 0;
        displayForLakers(scoreLakers);

        // Sets references to Lakers Buttons
        Button lakersThreePointsBtn  = (Button)findViewById(R.id.lakersThreePoints);
        Button lakersTwoPointsBtn  = (Button)findViewById(R.id.lakersTwoPoints);
        Button lakersOnePointBtn  = (Button)findViewById(R.id.lakersOnePoint);
        lakersThreePointsBtn.setEnabled(true); // Makes it clickable again
        lakersTwoPointsBtn.setEnabled(true); // Makes it clickable again
        lakersOnePointBtn.setEnabled(true); // Makes it clickable again

        // Sets references to Celtics Buttons
        Button celticsThreePointsBtn = (Button)findViewById(R.id.celticsThreePoints);
        Button celticsTwoPointsBtn = (Button)findViewById(R.id.celticsTwoPoints);
        Button celticsOnePointBtn = (Button)findViewById(R.id.celticsOnePoint);
        celticsThreePointsBtn.setEnabled(true); // Makes it clickable again
        celticsTwoPointsBtn.setEnabled(true); // Makes it clickable again
        celticsOnePointBtn.setEnabled(true); // Makes it clickable again

        scoreCeltics = 0;
        displayForCeltics(scoreCeltics);
    }


    /******** Declares who wins **********************/
    public void totalScores(){
        if (scoreLakers>=100){
            Toast.makeText(this, "Los Angeles Lakers won! Try again?", Toast.LENGTH_LONG).show();
            disableButtons();
        }
        if (scoreCeltics >= 100){
            Toast.makeText(this, "Boston Celtics won! Try again?", Toast.LENGTH_LONG).show();
            disableButtons();
        }
    }

    /****** Disables scoring buttons after a win has been declared **************/
    public void disableButtons(){
        // Sets references to Lakers Buttons
        Button lakersThreePointsBtn  = (Button)findViewById(R.id.lakersThreePoints);
        Button lakersTwoPointsBtn  = (Button)findViewById(R.id.lakersTwoPoints);
        Button lakersOnePointBtn  = (Button)findViewById(R.id.lakersOnePoint);
        lakersThreePointsBtn.setEnabled(false); // Disables the button
        lakersTwoPointsBtn.setEnabled(false); // Disables the button
        lakersOnePointBtn.setEnabled(false); // Disables the button

        // Sets references to Celtics Buttons
        Button celticsThreePointsBtn = (Button)findViewById(R.id.celticsThreePoints);
        Button celticsTwoPointsBtn = (Button)findViewById(R.id.celticsTwoPoints);
        Button celticsOnePointBtn = (Button)findViewById(R.id.celticsOnePoint);
        celticsThreePointsBtn.setEnabled(false); // Disables the button
        celticsTwoPointsBtn.setEnabled(false); // Disables the button
        celticsOnePointBtn.setEnabled(false); // Disables the button

    }
}
