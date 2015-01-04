package com.example.jerome.myfut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/***********************************************************
 * MainActivity, appelle les autres activity
 * @designPatern:actionBar
 ************************************************************/
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        switch (item.getItemId())
        {
            case R.id.action_settings:
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    /**Called when the user clicks on "button2" button**/
    public void ourBeer (View view){
        Intent intent = new Intent(this, OurBeer.class);
        startActivity(intent);
    }

    /**Called when the user clicks on "button3" button**/
    public void concept (View view){
        Intent intent = new Intent(this, Concept.class);
        startActivity(intent);
    }

    /**Called when the user clicks on "button4" button**/
    public void order (View view){
        Intent intent = new Intent(this, MakeOrder.class);
        startActivity(intent);
    }

       /**Called when the user clicks on "contact" button**/
    public void contact (View view){
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }
}
