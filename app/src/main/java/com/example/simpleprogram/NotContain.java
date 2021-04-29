package com.example.simpleprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        String s = null;
        s=ed.getText().toString();
        if(s != null) {
            int a = Integer.parseInt(s);
            inputNumbers.add(a);
            ed.setText("");
            tv.setText("");
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
        tv.setText("Min integer, not contained\nin your array is: "+notContains(list) + " ");
        inputNumbers=new ArrayList<>();
        list=new int [inputNumbers.size()];
        ed.clearFocus();
        ed.setText("");
    }

    // #3
    private int notContains(int[] array) {
        if(array.length==1 && array[0]>0){
            if(array[0] == 1)
                return 2;
            return 1;
        }
        int length = array.length;
        boolean[] isHere = new boolean[length+1];
        for(int i=0; i<length; i++){
            if(array[i]>0 && array[i]<=length)
                isHere[array[i]]=true;
        }
        for(int i=1; i<length; i++){
            if(!isHere[i])
                return i;
        }
        // contains at least one negative
        for(int i=0; i<length; i++){
            if(array[i]<=0)
                return length;
        }
        return length+1; // contains only positives from 1 to arrary.length
    }
}