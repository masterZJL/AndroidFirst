package com.example.viewpagerstudy;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder> {

    @NonNull
    @Override
    public ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.e("ViewPagerHolder", "onCreateViewHolder: create a viewPagerHolder.", null);
        return new ViewPagerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerHolder holder, int position) {
        holder.getTv().setText("你好" + position);
    }

    class ViewPagerHolder extends RecyclerView.ViewHolder {

        private TextView tv;
        private RelativeLayout rl;
        public ViewPagerHolder(@NonNull View itemView) {
            super(itemView);
            rl = itemView.findViewById(R.id.container);
            tv = itemView.findViewById(R.id.vptv);
        }

        public TextView getTv() {
            return tv;
        }

        public void setTv(TextView tv) {
            this.tv = tv;
        }

    }
}
