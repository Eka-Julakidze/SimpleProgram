package com.example.simpleprogram;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Adapter extends ArrayAdapter<String> {


    ArrayList<String> mObjects;
    Context mcontext;
    int mresource;

    public Adapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        mcontext=context;
        mresource=resource;
        this.mObjects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //String v =     // getItem(position).toString();
        String v = getItem(position).toString();
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        convertView=inflater.inflate(mresource, parent, false);

        //TextView key = (convertView).findViewById(R.id.keyId);
        TextView value = (convertView).findViewById(R.id.valueId);
        value.setText(v);


        return convertView;


    }
}
