package com.example.jerome.myfut;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class Order extends Activity {

    String[] listNames={"Fut","Biere","Tireuse"};
    ArrayList<String> list = new ArrayList<String>();
    ListView lvS;
    TextView textView;
    ProgressDialog pd;
    ArrayAdapter<String> adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_beer);

       lvS = (ListView) findViewById(R.id.lvS);
       getData(textView);
       registerReceiver(new WebServiceBroadcast(), new IntentFilter("com.ram.CUSTOM_BROADCAST"));
       adapters = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
       lvS.setAdapter(adapters);
        lvS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // ListView Clicked item value
                String itemValue =(String) lvS.getItemAtPosition(position);
                // Show Alert
                Toast.makeText(getApplicationContext(), itemValue+ " est en rupture de stock :( " , Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getData(View v) {
        pd = ProgressDialog.show(Order.this, "loading", "wait");
        Intent intentService = new Intent(getApplicationContext(),DownloadIntent.class);
        startService(intentService);
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
        switch (item.getItemId())
        {
            case R.id.action_order:
                Intent intent = new Intent(this, MakeOrder.class);
                startActivity(intent);
                return true;
            case R.id.action_settings:
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    class WebServiceBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            pd.cancel();
            String jsonResult = intent.getStringExtra("jsonresult");
            JSONArray jsonArray = null;
            try {

                jsonArray = new JSONArray(jsonResult);
                for (int i = 0; i < jsonArray.length(); i++) {

                    String test = jsonArray.getJSONObject(i).getString("name").toString();
                    list.add(jsonArray.getJSONObject(i).getString("name").toString());
                    adapters.notifyDataSetChanged();
                //    textView.append("category: "+ jsonArray.getJSONObject(i).getString("category").toString() + "\n");
               //     textView.append("name: "+ jsonArray.getJSONObject(i).getString("name").toString() + "\n");
                //    textView.append("" + "\n");
                }
            } catch (JSONException e) {
                 e.printStackTrace();
            }
        }
    }
}