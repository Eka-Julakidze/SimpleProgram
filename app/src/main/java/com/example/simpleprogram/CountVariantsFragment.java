package com.example.simpleprogram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;


public class CountVariantsFragment extends Fragment {

    EditText userInput;
    TextView output;
    Button countVariantsButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number, container, false);
        userInput=view.findViewById(R.id.inputNumberId);
        output=view.findViewById(R.id.outputNumberId);
        countVariantsButton=view.findViewById(R.id.calculateId);
        countVariantsButton.setText("Count Variants");

        output.setHint("The number of possible\nvariants is...");

        countVariantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                done(v);
            }
        });
        return view;
    }

    protected void done(View view){
        String s = userInput.getText().toString();
        int a = Integer.parseInt(s);
        output.setText("There are "+countVariants(a)
            + " different variants for " + a + " stairs");
        userInput.clearFocus();
        userInput.setText("");
    }

    // #5
    private int countVariants(int stairsCount) {
        if(stairsCount == 1)
            return 1;
        if(stairsCount == 2)
            return 2;
        return countVariants(stairsCount-1)+countVariants(stairsCount-2);
    }
}