package com.example.einzelbeispielapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMatrikelnummer;
    private EditText editTextServer;

    public void enterPrim (View view){ //Lifecycle von Android - View

    }

    public void enterTCP (View view){
        Client client = new Client();
        client.setEditTextServer(editTextServer);
        client.execute(editTextMatrikelnummer.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMatrikelnummer = findViewById(R.id.editTextMatrikelnummer);
        editTextServer = findViewById(R.id.editTextServer);

        Button buttonPrim = findViewById(R.id.buttonPrim); //Referenz zum Button mit ID
        buttonPrim.setOnClickListener(new View.OnClickListener() { //hört...
            @Override
            public void onClick(View v) { //führt aus... --> Methode aufrufen
                enterPrim(v);
            }
        });

        Button buttonTCP =findViewById(R.id.buttonTCP); //Referenz zum Button zur TCP
        buttonTCP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //führt aus... --> Methode aufrufen
                enterTCP(v);

            }
        });
    }
}


