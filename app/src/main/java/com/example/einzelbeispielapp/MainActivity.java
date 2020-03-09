package com.example.einzelbeispielapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView2;
    private EditText editTextServer;

    public void enterPrim (View view){
        textView2.setText(editTextServer.getText());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =findViewById(R.id.button); //Referenz zum Button mit ID
        //button.setOnClickListener;
        }

    }


