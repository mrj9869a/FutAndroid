package com.example.jerome.myfut;

import android.app.IntentService;
import android.content.Intent;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/***********************************************************
 *Classe chargé de recuperer les données de l'interface Rest
 *@designPatern:intentservice
 * @designPatern:BroadcastReceiver
 ************************************************************/
public class DownloadIntent extends IntentService {
    public DownloadIntent() {
        super("DownloadService");
     }

    @Override
    protected void onHandleIntent(Intent intent) {
        HttpClient httpclient = new DefaultHttpClient();
        //Nous avons choisi votre interface car elle correspondait au theme de notre application
        HttpGet httpget = new HttpGet("http://binouze.fabrigli.fr/bieres.json");
        try {
            HttpResponse response = httpclient.execute(httpget);
            String jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
            sendResultBroadcast(jsonResult);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Ecrit les données recupperée dans une string
    private StringBuilder inputStreamToString(InputStream is)throws IOException{
        String rLine;
        StringBuilder answer = new StringBuilder();
        InputStreamReader isr = new InputStreamReader(is,"UTF-8");
        BufferedReader rd = new BufferedReader(isr);
        try {
            while ((rLine = rd.readLine()) != null) {
                answer.append(rLine);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    void sendResultBroadcast(String jsonResult) {
        Intent in = new Intent();
        in.putExtra("jsonresult", jsonResult);
        in.setAction("com.ram.CUSTOM_BROADCAST");
        sendBroadcast(in);
    }
}
