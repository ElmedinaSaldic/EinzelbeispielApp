package com.example.einzelbeispielapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends AsyncTask<String, Void, String> {

    private String returnValue = null;
    private Socket clientSocket = null;
    private EditText editTextServer;

    public void run(String matrikelnummer) {
        Log.i("Test", matrikelnummer);

        BufferedReader bufferedReader = null;
        DataOutputStream dataOutputStream = null;
        try {
            clientSocket = new Socket("se2-isys.aau.at", 53212); //Mit Server kommunizieren wollen

            bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            dataOutputStream.writeBytes(matrikelnummer + "\n");
            dataOutputStream.flush();

            // Initiales lesen von Daten vom Server (ein Character)
            returnValue = bufferedReader.readLine();
            Log.i("Test" , returnValue);
        }  catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(clientSocket != null) {
                try {
                    bufferedReader.close();
                    dataOutputStream.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setEditTextServer(EditText editTextServer) {
        this.editTextServer = editTextServer;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        editTextServer.setText(returnValue);
    }

    @Override
    protected String doInBackground(String... strings) {
        run(strings[0]);
        return null;
    }
}
