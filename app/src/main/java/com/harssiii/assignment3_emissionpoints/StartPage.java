package com.harssiii.assignment3_emissionpoints;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class StartPage extends AppCompatActivity {

    public static final String EXTRA_MESSAGE ="" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
    }
    public void startQuiz(View view) {
        Intent intent = new Intent(this, McqScreen.class);
        EditText editText = findViewById(R.id.PersonName);
        EditText editText11 = findViewById(R.id.EmailAddress);
        String message = editText.getText().toString();
        String message1 = editText11.getText().toString();
        intent.putExtra("name", message);
        intent.putExtra("roll", message1);
        startActivity(intent);
    }
    public void Qcontent(View view) {
        String url = "https://www.makincerdas.com/khazanah/mc-97/makharijul-huruf-tempat-keluarnya-huruf-hijaiyah";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);



    }


}