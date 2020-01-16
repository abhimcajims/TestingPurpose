package com.example.abhishek.testingpurpose.NestedScroll;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abhishek.testingpurpose.R;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.InnerClass> {
    Context cnt;

    public VerticalAdapter(Context cnt) {
        this.cnt = cnt;
    }

    @NonNull
    @Override
    public InnerClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nested_child, viewGroup, false);
        return new InnerClass(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerClass innerClass, int i) {
        try {
            HorizontalAdapter rad = new HorizontalAdapter(cnt);
            innerClass.recycler_horizontal.setHasFixedSize(true);
            innerClass.recycler_horizontal.setLayoutManager(new LinearLayoutManager(cnt, LinearLayoutManager.HORIZONTAL, true));
            innerClass.recycler_horizontal.setAdapter(rad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class InnerClass extends RecyclerView.ViewHolder {

        RecyclerView recycler_horizontal;

        public InnerClass(@NonNull View itemView) {
            super(itemView);
            recycler_horizontal = itemView.findViewById(R.id.recycler_horizontal);
        }
    }
}
