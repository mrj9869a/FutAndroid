package com.example.jerome.myfut;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class DownloadIntent extends IntentService {

    public DownloadIntent() {
        super("DownloadService");
     }

    @Override
    protected void onHandleIntent(Intent intent) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://binouze.fabrigli.fr/bieres.json");
        try {

            HttpResponse response = httpclient.execute(httpget);
            String jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
            if (jsonResult != null) {
                sendResultBroadcast(jsonResult);
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder inputStreamToString(InputStream is)throws IOException{
        String rLine = "";
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
