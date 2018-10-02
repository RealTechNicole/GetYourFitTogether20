package com.spcollege.android.getyourfittogether20;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.security.cert.LDAPCertStoreParameters;

public class AddClient extends AppCompatActivity {

    protected static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 0;

    Uri imageUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.findItem(R.menu.menu_main).setIntent(
                new Intent(AddClient.this, LoginActivity.class));

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

    public void onClickBillingInfo(View view) {

        Intent intent = new Intent(AddClient.this, BillingInfo.class);
        startActivity(intent);
    }

    public void onClickSessionDisplay(View view) {

        Intent intent = new Intent(AddClient.this, SessionDisplay.class);
        startActivity(intent);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {

                Bundle extras = data.getExtras();

                Log.e("URI",imageUri.toString());

                Bitmap bmp = (Bitmap) extras.get("data");

            }
            else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Picture was not taken", Toast.LENGTH_SHORT);
            }
        }
        
    }

    public void onClickTakePhoto(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"fname_" +
                String.valueOf(System.currentTimeMillis()) + ".jpg"));
        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

}