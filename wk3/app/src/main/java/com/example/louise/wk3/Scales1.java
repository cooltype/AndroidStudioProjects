package com.example.louise.wk3;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Scales1 extends AppCompatActivity {
    private final String[] defaultKeys={"C","D","E","F Sharp","B Flat","A Flat"};
    private ArrayList<String> scales = new ArrayList<String>();
    private int ScaleIndex=0;

    private Button Choose_button;
    private Button Shuffle_button;
    private TextView PracticeScaleText;
    private Button SetScales_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // o 1
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scales1);

        SetDefaultScales();

        Intent intent = new Intent( getApplicationContext(),
                Scales2.class);

        startActivity(intent);


        Choose_button = (Button) findViewById(R.id.Choose_button);
        Shuffle_button = (Button) findViewById(R.id.Shuffle_button);
        PracticeScaleText = (TextView) findViewById(R.id.PracticeScaleText);
        SetScales_button = (Button) findViewById(R.id.SetScales_button);

        Choose_button.setOnClickListener(new View.OnClickListener(){  // o 2 , o 3
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
    } // c 1

    private void SetDefaultScales(){
        for(int i=0;i<defaultKeys.length;i++)
        {
            scales.add(defaultKeys[i] + " Major");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scales1, menu);
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
}
