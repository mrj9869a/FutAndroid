package com.example.jerome.myfut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/***********************************************************
 *Activité secondaire presentant la biere de la decibelle
 ************************************************************/
public class OurBeer extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_beer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        getMenuInflater().inflate(R.menu.menu_our_beer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
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
}
