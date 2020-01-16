package com.example.abhishek.testingpurpose.JsonParsing;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abhishek.testingpurpose.R;

import java.util.ArrayList;

public class CarNameAdapter extends RecyclerView.Adapter<CarNameAdapter.Inner> {

    ArrayList<String> ak = new ArrayList<>();
    Context cnt;

    public CarNameAdapter(ArrayList<String> ak, Context cnt) {
        this.ak.addAll(ak);
        this.cnt = cnt;
    }

    @NonNull
    @Override
    public Inner onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new Inner(itemView);

    }


    @Override
    public void onBindViewHolder(@NonNull Inner inner, int i) {
        inner.tv_3.setText(ak.get(i));

    }

    @Override
    public int getItemCount() {
        return ak.size();
    }

    public class Inner extends RecyclerView.ViewHolder {
        TextView tv_3;
        RecyclerView cars_list;

        public Inner(@NonNull View itemView) {
            super(itemView);
            tv_3 = (TextView) itemView.findViewById(R.id.tv_3);
            cars_list = (RecyclerView) itemView.findViewById(R.id.cars_list);
        }
    }
}

