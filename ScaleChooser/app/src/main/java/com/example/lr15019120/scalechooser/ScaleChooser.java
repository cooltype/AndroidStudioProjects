package com.example.lr15019120.scalechooser;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class ScaleChooser extends AppCompatActivity {

    private Random Ran = new Random();
    private Button scalebutton;
    private TextView textView2;
    private String Scales[] = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};


    public String PickScale() {
        int ScaleIndex = Ran.nextInt(Scales.length);
        return Scales[ScaleIndex] + " Major";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scalebutton = (Button)findViewById(R.id.Scalebutton);
        textView2 = (TextView)findViewById(R.id.textView2);

        scalebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scale = PickScale();
                textView2.setText(scale);
            }
        });
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














}
