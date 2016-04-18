package com.example.lfrob.phone4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by lfrob on 18/04/2016.
 */
public class MakeNewUser extends MainActivity{
private Button cancelbutton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen1a);

        cancelbutton=(Button) findViewById(R.id.cancelbutton);
        cancelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }



}
