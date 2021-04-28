package com.example.simpleprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NotContain extends AppCompatActivity {
    List<Integer> inputNumbers;
    int[] list;

    EditText ed;
    TextView tv, currentArray;
    Button addButton, resultButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_contain);

        ed=findViewById(R.id.arrayEditId);
        tv=findViewById(R.id.arrayAddButtonId);
        currentArray=findViewById(R.id.currentArrayId);
        resultButton=findViewById(R.id.arrayResultButtonId);
        addButton=findViewById(R.id.arrayAddButtonId);
        tv=findViewById(R.id.outputArrayId);

        inputNumbers = new ArrayList<Integer>();
        list = new int[inputNumbers.size()];

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(v);
            }
        });

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeResult(v);
            }
        });

    }

    public void add(View view){
        String s = "";
        s=ed.getText().toString();
        if(s != null) {
            int a = Integer.parseInt(s);
            inputNumbers.add(a);
            ed.setText("");
        } else {
            Toast.makeText(NotContain.this, "Type Number", Toast.LENGTH_SHORT).show();
        }
    }

    public void seeResult(View view){
        //currentArray.setText(printArray(list));
        list = new int[inputNumbers.size()];
        for(int j = 0; j<list.length; j++) {
            list[j]=inputNumbers.get(j);
        }
        tv.setText(notContains(list) + " ");
        inputNumbers=new ArrayList<>();
        list=new int[inputNumbers.size()];
        ed.clearFocus();
        ed.setText("");
    }

    // #3
    private int notContains(int[] array) {
        int m=Integer.MAX_VALUE;
        for(int a=0; a<array.length; a++) {
            if(array[a] > 1 && array[a] < m)
                m = array[a];
        }
        if(m != Integer.MAX_VALUE)
            return m-1;
        Toast.makeText(NotContain.this, "No such element", Toast.LENGTH_SHORT).show();
        return -1;

    }
}