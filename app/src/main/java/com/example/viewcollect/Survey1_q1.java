package com.example.viewcollect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Survey1_q1 extends AppCompatActivity {

    private Button next;
    private String questions[]= {"Do you think you use social media much more than you should?","Are you satisfied with your daily lifestyle?","Do you find playing sports a waste of time?",
            "Is app development the toughest for you?","Did you like the app?"};
    private String options[][]={{"Yes","No","Neither","Can't say"},{"Yes","No","Neither","Can't say"},{"Yes","No","Neither","Can't say"},
            {"Yes","No","Neither","Can't say"},{"Yes","No","Neither","Can't say"}};
    private CheckBox first;
    private CheckBox second;
    private CheckBox third;
    private CheckBox fourth;
    int l=questions.length;
    private String answers[][]=new String[l][4];
    int index=0;
    TextView text;
    private ProgressBar progress;
    private TextView progressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey1_q1);
        text=findViewById(R.id.textview);
        text.setText(questions[index]);
        progress = findViewById(R.id.progressBarS1);
        progressText = findViewById(R.id.progressBarTextS1);
        next = findViewById(R.id.survey1b1n);
        first=findViewById(R.id.checkBox1Survey1Q1);
        second=findViewById(R.id.checkBox2Survey1Q1);
        third=findViewById(R.id.checkBox3Survey1Q1);
        fourth=findViewById(R.id.checkBox4Survey1Q1);
        first.setText(options[index][0]);
        second.setText(options[index][1]);
        third.setText(options[index][2]);
        fourth.setText(options[index][3]);
        progress.setProgress(index);
        String ptext = "Questions Done: " + (index) + " / " + String.valueOf(l);
        progressText.setText(ptext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<l)
                {
                    answers[index][0]=(first.isChecked())?"Yes":"No";
                    answers[index][1]=(second.isChecked())?"Yes":"No";
                    answers[index][2]=(third.isChecked())?"Yes":"No";
                    answers[index][3]=(fourth.isChecked())?"Yes":"No";
                    index++;
                    progress.setProgress(index);
                    String ptext = "Questions Done: " + (index) + " / " + String.valueOf(l);
                    progressText.setText(ptext);
                }
                if(index<l)
                {
                    text.setText(questions[index]);
                    first.setText(options[index][0]);
                    second.setText(options[index][1]);
                    third.setText(options[index][2]);
                    fourth.setText(options[index][3]);
                    if(first.isChecked())
                        first.toggle();
                    if(second.isChecked())
                        second.toggle();
                    if(third.isChecked())
                        third.toggle();
                    if(fourth.isChecked())
                        fourth.toggle();
                }
                else
                {
                    Toast.makeText(Survey1_q1.this,"You have finished the survey. Please reload the app.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}