package com.example.simpleprogram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Split extends Fragment {
    Button splitButton;
    EditText useramount;
    TextView output;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number, container, false);
        useramount=view.findViewById(R.id.inputNumberId);
        output=view.findViewById(R.id.outputNumberId);
        splitButton=view.findViewById(R.id.calculateId);

        splitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                splitTheAmount(v);
            }
        });
        return view;
    }

    public void splitTheAmount(View view){
        String s = "";
        s = useramount.getText().toString();
        int a = Integer.parseInt(s);
        output.setText("Minimum number \nof coins required: "+minSplit(a));
        useramount.setText("");
        useramount.clearFocus();
    }

    // #2
    private int minSplit(int amount) {
        int minSplitNumber=0;
        minSplitNumber += amount/50;
        amount = amount%50;

        minSplitNumber += amount/20;
        amount = amount%20;

        minSplitNumber += amount/10;
        amount = amount%10;

        minSplitNumber += amount/5;
        amount = amount%5;

        minSplitNumber += amount/1;

        return minSplitNumber;
    }
}