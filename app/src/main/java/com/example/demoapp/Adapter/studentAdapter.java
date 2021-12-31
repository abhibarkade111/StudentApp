package com.example.demoapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demoapp.R;
import com.example.demoapp.Registrations;

import java.util.List;

public class studentAdapter extends ArrayAdapter<Registrations> {

    private Context context;
    private List<Registrations> list;

    public studentAdapter(Context context, List<Registrations> list) {
        super(context, R.layout.student_model, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_model,null,true);

        TextView sName = view.findViewById(R.id.name);
        sName.setText(list.get(position).getName());

        return view;
    }
}
