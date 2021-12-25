package com.harssiii.assignment3_emissionpoints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class McqScreen<message> extends AppCompatActivity {

    TextView tv;
    Button next ;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;
    int flag=0;
    String[] questions = {
            "How Many Total Emission(makhārij al-ḥurūf) Points Are Present",
            "Which Letters Sound Is Produced from end Of Throat",
            "Which Letters Sound Is Produced from Middle Of Throat",
            "Which Letters Sound Is Produced from Start Of Throat",
            "Which Letters Sound Is Produced from Base of Tongue which is near touching the mouth roof",
            "Which Letters Sound Is Produced from Portion of Tongue near its base touching the roof of mouth ",
            "Which Letters Sound Is Produced from Tongue touching the center of the mouth roof",
            "Which Letters Sound Is Produced from One side of the tongue touching the molar teeth",
            "Which Letters Sound Is Produced from Rounded tip of the tongue touching the base of the Frontal 8 teeth",
            "Which Letters Sound Is Produced from Rounded tip of the tongue touching the base of the frontal teeth "
    };
    String[] answers = {"17","أ ہ","ع ح","غ خ ","ق","ک","ج ش ی","ض","ل","ن"};
    String[] opt = {
            "5","10","15","17",
            "أ ہ","ع ح","غ خ","None Of Above",
            "ع ح","ج ش ی","ق","None Of Above",
            "غ خ","ل","ج ش ی","None Of Above",
            "ق","ل","أ ہ","All of the mentioned",
            "ک","أ ہ","ج ش ی"," None Of Above",
            "ج ش ی","أ ہ","ج ش ی","None of the mentioned",
            "ض","ج ش ی","غ خ","None Of Above",
            "ل","غ خ","أ ہ","None Of Above",
            "ن","أ ہ","غ خ","None Of Above"
    };

    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq_screen);
        TextView t3,t4;
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);

        Intent intent = getIntent();

        t3.setText(intent.getStringExtra("roll"));
        t4.setText(intent.getStringExtra("name"));

        Button next = (Button)findViewById(R.id.next);
        tv=(TextView) findViewById(R.id.quest);
        radio_g=(RadioGroup)findViewById(R.id.answers);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);

        tv.setText(questions[0]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        next.setOnClickListener(this::onClick);


    }

    public void onClick(View v) {


        if (radio_g.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton sans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
        String ansText = sans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
        if (ansText.equals(answers[flag])) {
            correct++;
            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
        } else {
            wrong++;
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
        }

        flag++;


        if (flag < questions.length) {
            tv.setText(questions[flag]);
            rb1.setText(opt[flag * 4]);
            rb2.setText(opt[flag * 4 + 1]);
            rb3.setText(opt[flag * 4 + 2]);
            rb4.setText(opt[flag * 4 + 3]);
        } else {
            marks = correct;
            Intent in = new Intent(getApplicationContext(), ResultScreen.class);
            startActivity(in);
        }
        radio_g.clearCheck();
    }
}