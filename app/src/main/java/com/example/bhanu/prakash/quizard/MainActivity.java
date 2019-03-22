package com.example.bhanu.prakash.quizard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score;
    int submitCount;
    RadioGroup que1Radio;
    RadioGroup que2Radio;
    EditText que3EditText;
    RadioGroup que4Radio;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    RadioGroup que6Radio;
    Button scoreButton;

    //CardView
    CardView que1;
    CardView que2;
    CardView que3;
    CardView que4;
    CardView que5;
    CardView que6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        que1Radio = findViewById(R.id.Que1_Radio);
        que2Radio = findViewById(R.id.Que2_Radio);
        que3EditText = findViewById(R.id.Ques3_EditText);
        que4Radio = findViewById(R.id.Que4_Radio);
        cb1 = findViewById(R.id.Que5_CB1);
        cb2 = findViewById(R.id.Que5_CB2);
        cb3 = findViewById(R.id.Que5_CB3);
        cb4 = findViewById(R.id.Que5_CB4);
        que6Radio = findViewById(R.id.Que6_Radio);
        que1 = findViewById(R.id.Que1_CardView);
        que2 = findViewById(R.id.Que2_CardView);
        que3 = findViewById(R.id.Que3_CardView);
        que4 = findViewById(R.id.Que4_CardView);
        que5 = findViewById(R.id.Que5_CardView);
        que6 = findViewById(R.id.Que6_CardView);
        scoreButton = findViewById(R.id.ScoreButton);

    }

    /**
     * This Method is invoked when Reset Button is Clicked.
     * This Reset's to the Default selection.
     *
     * @param view View
     */
    public void reset(View view) {
        //Question 1
        que1Radio.clearCheck();
        //Question 2
        que2Radio.clearCheck();
        //Question 3
        que3EditText.getText().clear();
        //Question 4
        que4Radio.clearCheck();
        //Question 5
        if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked() || cb4.isChecked()) {
            cb1.setChecked(false);
            cb2.setChecked(false);
            cb3.setChecked(false);
            cb4.setChecked(false);
        }
        //Question 6
        que6Radio.clearCheck();
        //Resetting Colors of CardView's
        que1.setBackgroundColor(this.getResources().getColor(R.color.gray_50));
        que2.setBackgroundColor(this.getResources().getColor(R.color.gray_50));
        que3.setBackgroundColor(this.getResources().getColor(R.color.gray_50));
        que4.setBackgroundColor(this.getResources().getColor(R.color.gray_50));
        que5.setBackgroundColor(this.getResources().getColor(R.color.gray_50));
        que6.setBackgroundColor(this.getResources().getColor(R.color.gray_50));

        //Resetting Score
        score = 0;
        submitCount = 0;

        //Enabling Score Button on RESET
        scoreButton.setEnabled(true);

        //Toast when quiz is Reset
        Toast.makeText(MainActivity.this, R.string.toast, Toast.LENGTH_SHORT).show();
    }

    /**
     * This method is invoked when Score Button is clicked.
     * This method display's the scores obtained in Quiz.
     *
     * @param view View
     */
    public void submit(View view) {
        submitCount++;

        //Displaying Result
        if (submitCount == 1) {
            evaluateQuiz();
            Toast.makeText(MainActivity.this, getString(R.string.resultScore) + score, Toast.LENGTH_SHORT).show();
        }
        if(submitCount == 2){
            Toast.makeText(MainActivity.this, getString(R.string.warn), Toast.LENGTH_LONG).show();
            scoreButton.setEnabled(false);
        }
    }

    /**
     * This method is invoked from "submit" method.
     * This evaluates the Score by comparing with Answers.
     */
    public void evaluateQuiz() {
        try {
            //Question 1
            String ans1 = ((RadioButton) findViewById(que1Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans1.equalsIgnoreCase("GreyHound")) {
                score += 1;
                que1.setBackgroundColor(this.getResources().getColor(R.color.green_100)); //Green 100
            } else {
                que1.setBackgroundColor(this.getResources().getColor(R.color.red_100)); //Red 100
            }

            //Question 2
            String ans2 = ((RadioButton) findViewById(que2Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans2.equalsIgnoreCase("Basenji")) {
                score += 1;
                que2.setBackgroundColor(this.getResources().getColor(R.color.green_100)); //Green 100
            } else {
                que2.setBackgroundColor(this.getResources().getColor(R.color.red_100)); //Red 100
            }

            //Question 3
            if (que3EditText.getText().toString().equalsIgnoreCase("Saluki")) {
                score += 1;
                que3.setBackgroundColor(this.getResources().getColor(R.color.green_100)); //Green 100
            } else {
                que3.setBackgroundColor(this.getResources().getColor(R.color.red_100)); //Red 100
            }

            //Question 4
            String ans4 = ((RadioButton) findViewById(que4Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans4.equalsIgnoreCase("Mastiff")) {
                score += 1;
                que4.setBackgroundColor(this.getResources().getColor(R.color.green_100)); //Green 100
            } else {
                que4.setBackgroundColor(this.getResources().getColor(R.color.red_100)); //Red 100
            }

            //Question 5
            boolean q5CB1 = cb1.isChecked();
            boolean q5CB2 = cb2.isChecked();
            boolean q5CB3 = cb3.isChecked();
            boolean q5CB4 = cb4.isChecked();
            boolean rightCB = q5CB1 && q5CB2 && q5CB4;
//            boolean wrongCB = q5CB3;
            if (rightCB && !q5CB3) {
                score += 1;
                que5.setBackgroundColor(this.getResources().getColor(R.color.green_100)); //Green 100
            } else {
                que5.setBackgroundColor(this.getResources().getColor(R.color.red_100)); //Red 100
            }

            //Question 6
            String ans6 = ((RadioButton) findViewById(que6Radio.getCheckedRadioButtonId())).getText().toString();
            if (ans6.equalsIgnoreCase("Yes")) {
                score += 1;
                que6.setBackgroundColor(this.getResources().getColor(R.color.green_100)); //Green 100
            } else {
                que6.setBackgroundColor(this.getResources().getColor(R.color.red_100)); //Red 100
            }
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_LONG).show();
        }
    }
}
