package com.example.viewcollect;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Survey2_q1 extends AppCompatActivity {

    private Button next;
    private String questions[]= {"Java is a person?","Java was introduced in 1233?","Java was created using Phython",
            "Java has abstract classes?","Java supports interface"};
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey2_q1);
        text=findViewById(R.id.textview2);
        text.setText(questions[index]);
        next = findViewById(R.id.survey2b1n);
        first=findViewById(R.id.checkBoxSurvey2Q1);
        second=findViewById(R.id.checkBoxSurvey2Q2);
        third=findViewById(R.id.checkBoxSurvey2Q3);
        fourth=findViewById(R.id.checkBoxSurvey2Q4);
        first.setText(options[index][0]);
        second.setText(options[index][1]);
        third.setText(options[index][2]);
        fourth.setText(options[index][3]);
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
                    Toast.makeText(Survey2_q1.this,"You have finished the survey. Please reload the app.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}