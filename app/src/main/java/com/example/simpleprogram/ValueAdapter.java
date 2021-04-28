package com.example.simpleprogram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ValueAdapter extends RecyclerView.Adapter<ValueAdapter.ValueViewHolder> {
    public List<String> localList;

    public ValueAdapter(ArrayList<String> values) {
        this.localList=values;
    }


    @Override
    public ValueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element, parent, false);
        return new ValueViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ValueViewHolder holder, int position) {
        holder.getTextView().setText(localList.get(position));

    }

    @Override
    public int getItemCount() {
        return localList.size();
    }

    public static class ValueViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;
        public ValueViewHolder(View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.IdforValue);

        }
        public TextView getTextView(){
            return textView;
        }
    }
}
