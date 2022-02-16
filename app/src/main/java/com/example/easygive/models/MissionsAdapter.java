package com.example.easygive.models;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.easygive.R;

import java.util.ArrayList;

public class MissionsAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Mission> arrayList;

    public MissionsAdapter(Context context, ArrayList<Mission> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        final TextView name = convertView.findViewById(R.id.name);
        final TextView city = convertView.findViewById(R.id.city);
        final TextView date = convertView.findViewById(R.id.date);
        final TextView description = convertView.findViewById(R.id.description);
        name.setText(arrayList.get(position).getName());
        city.setText(arrayList.get(position).getCity());
        date.setText(arrayList.get(position).getDate());
        description.setText(arrayList.get(position).getDescription());
        convertView.setOnClickListener(view -> {
            Log.i("MyAdapter", "getView: " + description);
            if (description.getVisibility() == View.GONE)
                description.setVisibility(View.VISIBLE);
            else
                description.setVisibility(View.GONE);
        });
        return convertView;
    }
}