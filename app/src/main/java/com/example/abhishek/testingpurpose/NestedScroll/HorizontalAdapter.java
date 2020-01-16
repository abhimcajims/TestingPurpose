package com.example.abhishek.testingpurpose.NestedScroll;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abhishek.testingpurpose.R;


public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.InnerClass> {
    Context cnt;

    public HorizontalAdapter(Context cnt) {
        this.cnt = cnt;
    }

    @NonNull
    @Override
    public InnerClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
        return new InnerClass(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerClass innerClass, int i) {
        try {
            innerClass.tv_1.setTextColor(cnt.getResources().getColor(R.color.orange));
            innerClass.tv_1.setText("Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class InnerClass extends RecyclerView.ViewHolder {

        TextView tv_1;

        public InnerClass(@NonNull View itemView) {
            super(itemView);
            tv_1 = itemView.findViewById(R.id.tv_1);

        }
    }
}
