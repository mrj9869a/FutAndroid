package com.example.jerome.myfut;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;


public class Order extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        new DLTask().execute("http://fabrigli.fr/cours/example.json");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_order, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class DLTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page, URL may be invalid.";
            }
        }

        @Override
        protected void onPostExecute(String result){
            Toast.makeText(getApplication().getApplicationContext(),result,Toast.LENGTH_LONG).show();
        }

        private String downloadUrl(String myurl) throws IOException {
            InputStream is = null;
            try{
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();
                int response = conn.getResponseCode();

                //Convert the InputStream into a string
                String contentAsString = readIt(is,500);
                return contentAsString;
            } finally{
                if (is !=null){
                    is.close();
                }
            }
        }

        public String readIt(InputStream stream, int len) throws IOException, UnsupportedOperationException{
            Reader reader = null;
            reader = new InputStreamReader(stream,"UTF-8");
            char[] buffer = new char [len];
            reader.read(buffer);
            return new String(buffer);
        }
    }
}