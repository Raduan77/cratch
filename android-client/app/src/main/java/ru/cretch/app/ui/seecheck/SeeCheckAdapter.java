package ru.cretch.app.ui.seecheck;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import ru.cretch.app.R;

public class SeeCheckAdapter extends RecyclerView.Adapter<SeeCheckAdapter.MyViewHolder> {
    private ProductModel[] mDataset;

    SeeCheckAdapter(ProductModel[] myDataset) {
        mDataset = myDataset;
    }

    public void setDataset(ProductModel[] mDataset) {
        this.mDataset = mDataset;
        notifyDataSetChanged();
    }

    @Override
    public SeeCheckAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ckeck_product, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(mDataset[position].name);
        holder.subtitle.setText(mDataset[position].price + "\u20BD");
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;
        ImageView checkBox;

        MyViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.product_name);
            subtitle = v.findViewById(R.id.product_price);
            checkBox = v.findViewById(R.id.check_box);
        }
    }
}
