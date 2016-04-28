package com.example.lfrob.phone4;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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

        String[]  myStringArray={"Branch 1","Branch 2"};
        ArrayAdapter<String> myAdapter=new
                ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myStringArray);
        ListView myList=(ListView) findViewById(R.id.BranchList);
        myList.setAdapter(myAdapter);



    }



}
