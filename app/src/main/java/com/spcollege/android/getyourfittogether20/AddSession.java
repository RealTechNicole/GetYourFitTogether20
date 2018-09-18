package com.spcollege.android.getyourfittogether20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class AddSession extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.menu.menu_main).setIntent(
                new Intent(AddSession.this, LoginActivity.class));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
        if (id == R.menu.menu_main) {
            Toast.makeText(this, "Logging you off", Toast.LENGTH_SHORT).show();
            super.onOptionsItemSelected(item);
            startActivity(item.getIntent());

        }
        return true;
    }

    public void onClickReceipt(View view) {

        Intent intent = new Intent(AddSession.this, Receipt.class);
        startActivity(intent);
    }

}