package com.example.abhishek.testingpurpose.RetrofitExample;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.abhishek.testingpurpose.R;

import java.util.List;

public class RetroAdapter extends RecyclerView.Adapter<RetroAdapter.Inner> {

    List<Hero> lh;
    Context cnt;

    public RetroAdapter(Context cnt, List<Hero> lh) {
        this.cnt = cnt;
        this.lh = lh;
    }

    @NonNull
    @Override
    public Inner onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View inv = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_image, viewGroup, false);
        return new Inner(inv);
    }

    @Override
    public void onBindViewHolder(@NonNull Inner inner, int i) {

        try {
            inner.tv1.setText(lh.get(i).getName());
            inner.tv2.setText(lh.get(i).getRealname());
            inner.tv3.setText(lh.get(i).getFirstappearance());

            Glide.with(cnt).load(lh.get(i).imageurl)
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(inner.img);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return lh.size();
    }

    public class Inner extends RecyclerView.ViewHolder {

        TextView tv3, tv2, tv1;
        ImageView img;

        public Inner(@NonNull View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
            tv3 = (TextView) itemView.findViewById(R.id.tv3);
            img = itemView.findViewById(R.id.img);
        }
    }
}
