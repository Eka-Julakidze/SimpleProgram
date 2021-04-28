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


public class isProperlyFragment extends Fragment {
    EditText userInput;
    TextView output;
    Button properButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        userInput=view.findViewById(R.id.inputId);
        output=view.findViewById(R.id.outputId);
        properButton=view.findViewById(R.id.doneId);

        properButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                done(v);
            }
        });
        return view;
    }

    protected void done(View view){
        String s = userInput.getText().toString();
        if(isProperly(s))
            output.setText("Braces Look Fine");
        else
            output.setText("Braces are not properly aligned");
        userInput.clearFocus();
        userInput.setText("");
    }

    // #4
    private boolean isProperly(String sequence) {
        if(sequence.charAt(0) == '(' && sequence.charAt(sequence.length()-1) == ')') {
            int openingBrace=0, closingBrace=0;
            for(int o=0; o<sequence.length(); o++) {
                if(sequence.charAt(o) == '(')
                    openingBrace++;
                else
                    closingBrace++;
            }
            return openingBrace == closingBrace;
        }
        return false;
    }
}