package com.example.simpleprogram;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class palindrome extends Fragment {
    EditText userInput;
    TextView output;
    Button doneButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        userInput=view.findViewById(R.id.inputId);
        output=view.findViewById(R.id.outputId);
        doneButton=view.findViewById(R.id.doneId);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                done(v);
            }
        });
        return view;
    }
    @SuppressLint("LongLogTag")
    protected void done(View view){
        String s=userInput.getText().toString();
        s.split(" ");
        if(isPalindrome(s))
            output.setText("\""+s +"\" is palindrome");
        else
            output.setText("\""+s +"\" is not palindrome");
        userInput.setText("");
        userInput.clearFocus();
        Log.i("fragmentOne, palindrome ", ""+isPalindrome(s));
    }

    // #1
    private boolean isPalindrome(String text) {
        for(int i=0; i<text.length()/2; i++) {
            if(text.charAt(i) == text.charAt(text.length()-i-1))
                continue;
            else
                return false;
        }
        return true;
    }

}