package ru.rentateam.rttestapp.ui.menu.pizza;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import ru.rentateam.rttestapp.R;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.MyViewHolder> {
    private String[] mDataset;

    public void setDataset(String[] mDataset) {
        this.mDataset = mDataset;
        notifyDataSetChanged();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView countTW;
        TextView contentTw;

        MyViewHolder(View v) {
            super(v);
            countTW = v.findViewById(R.id.count);
            contentTw = v.findViewById(R.id.content);
        }
    }

    PizzaAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public PizzaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.countTW.setText(String.valueOf(position + 1));
        holder.contentTw.setText(mDataset[position]);

    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}