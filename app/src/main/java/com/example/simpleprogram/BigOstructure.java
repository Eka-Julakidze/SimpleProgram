package com.example.simpleprogram;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.annotation.ElementType;
import java.util.logging.ErrorManager;

public class BigOstructure extends AppCompatActivity {
    RecyclerView recyclerView;
    Map<String, String> map;
    ValueAdapter valueAdapter;

    EditText elementToDelete;
    Button deleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_o);

        recyclerView=findViewById(R.id.tecyclerViewId);
        elementToDelete=findViewById(R.id.elementDeleteId);
        deleteButton=findViewById(R.id.deleteButtonId);

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

        //recyclerView.setAdapter(new ValueAdapter());
        valueAdapter = new ValueAdapter(map.values());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(valueAdapter);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteElement();
            }
        });

    }
    public void deleteElement(){
        String s = elementToDelete.getText().toString();
        if(map.values().contains(s)) {
            int i = map.values().indexOf(s);

            buildAlert(i);
            map.delete(map.keys().get(i));
            recyclerView.setAdapter(new ValueAdapter(map.values()));
            elementToDelete.clearFocus();
            elementToDelete.setText("");
        } else{
            elementToDelete.clearFocus();
            elementToDelete.setText("");
            Toast.makeText(this, "NO SUCH ELEMENT", Toast.LENGTH_SHORT).show();


        }
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