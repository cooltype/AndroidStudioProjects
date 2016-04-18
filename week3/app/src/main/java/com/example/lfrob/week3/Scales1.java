package com.example.lfrob.week3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Scales1 extends AppCompatActivity {
    private final String[] defaultKeys = {"C", "D", "E", "F Sharp", "B Flat", "A Flat"};
    private ArrayList<String> scales = new ArrayList<String>();
    private int ScaleIndex = 0;

    private Button Choose_button;
    private Button Shuffle_button;
    private TextView PracticeScaleText;
    private Button SetScales_button;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // o 1
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout.activity_scales1);

        SetDefaultScales();

        Intent intent = new Intent(getApplicationContext(),
                Scales2.class);

        startActivity(intent);


        Choose_button = (Button) findViewById(R.id.Choose_button);
        Shuffle_button = (Button) findViewById(R.id.Shuffle_button);
        PracticeScaleText = (TextView) findViewById(R.id.PracticeScaleText);
        SetScales_button = (Button) findViewById(R.id.SetScales_button);

        Choose_button.setOnClickListener(new View.OnClickListener() {  // o 2 , o 3
            public void onClick(View view) { // o 4
                if (ScaleIndex >= scales.size()) { //5
                    ScaleIndex = 0;
                }// o 5

                PracticeScaleText.setText(scales.get(ScaleIndex));
                ScaleIndex++;
            } // c 4
        }); // c 2 , c 3

        Shuffle_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(scales);
                ScaleIndex = 0;
            }
        });

        SetScales_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Scales2.class);
                startActivity(intent);
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    } // c 1

    private void SetDefaultScales() {
        for (int i = 0; i < defaultKeys.length; i++) {
            scales.add(defaultKeys[i] + " Major");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Scales1 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.lfrob.week3/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Scales1 Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.lfrob.week3/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
