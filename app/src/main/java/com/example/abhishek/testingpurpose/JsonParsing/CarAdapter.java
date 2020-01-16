package com.example.abhishek.testingpurpose.JsonParsing;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abhishek.testingpurpose.R;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.Inner> {

    ArrayList<Car> ak = new ArrayList<>();
    Context cnt;
    CarNameAdapter rad;

    public CarAdapter(ArrayList<Car> ak, Context cnt) {
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
        inner.tv_3.setText(ak.get(i).name);
        rad = new CarNameAdapter(ak.get(i).models,cnt);
        inner.cars_list.setHasFixedSize(true);
        inner.cars_list.setLayoutManager(new LinearLayoutManager(cnt));
        inner.cars_list.setAdapter(rad);

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
