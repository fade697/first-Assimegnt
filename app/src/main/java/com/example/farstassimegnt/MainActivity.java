package com.example.farstassimegnt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView  t1;
    TextView  t2;
    TextView  t3;
    Button btn;
    EditText ans1;
    EditText ans2;
    EditText ans3;
    DAQuestions question = new DAQuestions();
    Questions currentQ1;
    Questions currentQ2;
    Questions currentQ3;
    private int score=0;
    private int questionNo =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.q1);
        t2 = findViewById(R.id.q2);
        t3 = findViewById(R.id.q3);

        ans1 =findViewById(R.id.tx_input1);
        ans2 =findViewById(R.id.tx_input2);
        ans3 =findViewById(R.id.tx_input3);

        btn =findViewById(R.id.btncheck);


        fillQuestions();


    }

    public void Check(View view) {
        try{
            int a1 = Integer.parseInt(ans1.getText().toString());
            int a2 = Integer.parseInt(ans2.getText().toString());
            int a3 = Integer.parseInt(ans3.getText().toString());

            if( a1 == currentQ1.getElectronNumber()){
                score+=5;
            }
            if( a2 == currentQ2.getElectronNumber()){
                score+=5;
            }
            if( a3 == currentQ3.getElectronNumber()){
                score+=5;
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Please fill in all answers", Toast.LENGTH_SHORT).show();
        }
        fillQuestions();
    }
    public void fillQuestions(){
        ArrayList<Questions> list = question.getQuestionsList();
        if(questionNo < list.size()){
            currentQ1 = list.get(questionNo++);
            currentQ2 = list.get(questionNo++);
            currentQ3 = list.get(questionNo++);
            t1.setText(currentQ1.getElement());
            t2.setText(currentQ2.getElement());
            t3.setText(currentQ3.getElement());
        }else {
            questionNo =0;
            Toast.makeText(getApplicationContext(),"Congrats you finished with score\n"+score, Toast.LENGTH_SHORT).show();
            try {
                Thread.sleep(3000); // pause for 5 seconds (5000 milliseconds)
            } catch (InterruptedException e) {
            }
            fillQuestions();
        }





    }
}