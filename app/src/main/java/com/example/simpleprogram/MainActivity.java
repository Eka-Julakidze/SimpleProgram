package com.example.simpleprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.fragmentId);
    }

    public void palindrome(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentId, new palindrome()).commit();
        frameLayout.setVisibility(View.VISIBLE);
    }

    public void split(View view){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentId, new Split()).commit();
      frameLayout.setVisibility(View.VISIBLE);
    }

    public void notContain(View view){
        Intent i = new Intent(MainActivity.this, NotContain.class);
        startActivity(i);
    }

    public void isProperlyFragment(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentId, new isProperlyFragment()).commit();
        frameLayout.setVisibility(View.VISIBLE);
    }

    public void countVariantsFragment(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentId, new CountVariantsFragment()).commit();
        frameLayout.setVisibility(View.VISIBLE);
    }

    public void bigO(View view) {
        Intent i = new Intent(MainActivity.this, BigOstructure.class);
        startActivity(i);
    }
}

