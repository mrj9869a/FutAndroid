package com.example.jerome.myfut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/***********************************************************
 *Activité secondaire permettant de lancer
 * OrderFut,OrderTir ou Order
 * @designPatern:listview
 ************************************************************/
public class MakeOrder extends Activity{

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //listView simple a 3 champs
        lv = (ListView) findViewById(R.id.lv);
        String[] listeStrings = new String[]{"Fut LaDecibelle","Bouteille partenaire","Tireuse"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,listeStrings);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                 // ListView Clicked item value, Lance l'activité  correspondante
                String itemValue =(String) lv.getItemAtPosition(position);
                switch(itemValue)
                {
                    case "Fut LaDecibelle":
                        Intent intent;
                        intent = new Intent(getApplicationContext(), OrderFut.class);
                        startActivity(intent);
                        break;
                    case "Bouteille partenaire":
                        Intent intentb;
                        intentb = new Intent(getApplicationContext(), Order.class);
                        startActivity(intentb);
                        break;
                    case "Tireuse":
                        Intent intentc;
                        intentc = new Intent(getApplicationContext(), OrderTir.class);
                        startActivity(intentc);
                        break;
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        getMenuInflater().inflate(R.menu.menu_order, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        switch (item.getItemId()) {
            case R.id.action_order:
                Intent intent = new Intent(this, MakeOrder.class);
                startActivity(intent);
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
