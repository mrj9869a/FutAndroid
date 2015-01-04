package com.example.jerome.myfut;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

/***********************************************************
 *Activité secondaire presentant les contacts de la decibelle
 ************************************************************/
public class Contact extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //Ajout d'un listener sur l'image/bouton afin de rediriger vers la page facebook
        ImageButton btn = (ImageButton) findViewById(R.id.imageButton);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.facebook.com/Ladecibelle"));
                startActivity(myWebLink);
            }
        });
        //Ajout d'un listener sur l'image/bouton afin de rediriger vers la page google+
        ImageButton btnG = (ImageButton) findViewById(R.id.imageButton2);
        btnG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://plus.google.com/113574984588059160193/posts"));
                startActivity(myWebLink);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // this add items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
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
