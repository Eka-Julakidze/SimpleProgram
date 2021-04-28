package com.example.simpleprogram;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BigOhStructure extends AppCompatActivity {
    private static final String TAG = "BigOhStructure";
    ListView listView;
    Map<String,String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_oh);
        Log.d(TAG,"onCreate");

        listView=findViewById(R.id.listViewId);

        map = new Map<>();
        map.add("green planet", "Earth");
        map.add("red planet", "Mars");
        map.add("largest planet", "Jupiter");
        map.add("brightest", "Venus");
        map.add("has rings", "Saturn");
        map.add("coldest", "Uranus");
        map.add("smallest", "Mercury");
        map.add("farthest", "Neptune");
        map.add("asteroid", "Ceres");
        map.add("comet", "CometMcNaught");
        map.add("meteorid", "Hoba");
        map.add("satelite", "moon");
        map.add("dwarf planet", "Ceres");
        map.add("star", "Sun");
        map.add("space", "speed of light");
        map.add("milkey way", "galaxy");

        Adapter ad = new Adapter(this, R.layout.adapter, map.values());
        listView.setAdapter(ad);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(BigOhStructure.this, map.keys().get(position), Toast.LENGTH_SHORT).show();
                buildAlert(position);
                map.delete(map.keys().get(position));
                listView.setAdapter(new Adapter(getApplicationContext(), R.layout.adapter, map.values()));

                return true;
            }
        });

    }

    private void buildAlert(int i){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_baseline_delete_24);
        builder.setTitle("Deleting an Element in O(1)");
        builder.setMessage("KEY: "
                +map.keys().get(i)
                + "\nVALUE: "+map.values().get(i));
        builder.setCancelable(true);
        builder.setPositiveButton("Done",null);
        builder.setNeutralButton("cancel", null);
        builder.show();
    }

}