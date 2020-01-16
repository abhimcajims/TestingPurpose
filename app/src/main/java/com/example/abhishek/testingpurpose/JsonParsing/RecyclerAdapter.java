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
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.InsideClass> {

    ArrayList<Person> jj = new ArrayList<>();
    Context cnt;
    CarAdapter rad;

    public RecyclerAdapter(List<Person> jj, Context cnt) {
        this.jj.addAll(jj);
        this.cnt = cnt;
    }

    @NonNull
    @Override
    public InsideClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new InsideClass(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InsideClass insideClass, int i) {
        try {
            insideClass.tv_1.setText(jj.get(i).name);
            insideClass.tv_2.setText(jj.get(i).age);
            //for (int j = 0; i < jj.get(j).cars.size(); j++) {
               // insideClass.tv_3.setText(jj.get(i).cars.get(i).name);
                rad = new CarAdapter(jj.get(i).cars,cnt);
                insideClass.cars_list.setHasFixedSize(true);
                insideClass.cars_list.setLayoutManager(new LinearLayoutManager(cnt));
                insideClass.cars_list.setAdapter(rad);

            //}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jj.size();
    }

    public class InsideClass extends RecyclerView.ViewHolder {
        TextView tv_1, tv_2, tv_3;
        RecyclerView cars_list;

        public InsideClass(@NonNull View itemView) {
            super(itemView);
            tv_1 = (TextView) itemView.findViewById(R.id.tv_1);
            tv_2 = (TextView) itemView.findViewById(R.id.tv_2);
            tv_3 = (TextView) itemView.findViewById(R.id.tv_3);
            cars_list = (RecyclerView) itemView.findViewById(R.id.cars_list);

        }
    }
}
