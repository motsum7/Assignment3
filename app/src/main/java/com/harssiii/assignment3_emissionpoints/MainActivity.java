package com.harssiii.assignment3_emissionpoints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView noteView = (TextView) findViewById(R.id.noteView);
        noteView.setText("https://github.com/Harssiii/Assignment3MC");
        Linkify.addLinks(noteView, Linkify.WEB_URLS);

    }




    public void startapp(View view) {
        Intent intent = new Intent(this, StartPage.class);
        startActivity(intent);
    }
}