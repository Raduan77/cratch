package ru.cretch.app.ui.checksplitter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import ru.cretch.app.R;

public class CheckSplitterAdapter extends RecyclerView.Adapter<CheckSplitterAdapter.MyViewHolder> {
    private ProductModel[] mDataset;

    CheckSplitterAdapter(ProductModel[] myDataset) {
        mDataset = myDataset;
    }

    public void setDataset(ProductModel[] mDataset) {
        this.mDataset = mDataset;
        notifyDataSetChanged();
    }

    @Override
    public CheckSplitterAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ckeck_product, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(mDataset[position].name);
        holder.subtitle.setText(mDataset[position].price + "\u20BD");
        holder.itemView.setOnClickListener(v -> {
            mDataset[position].select();
            holder.checkBox.setImageDrawable(mDataset[position].selected ?
                    holder.itemView.getContext().getResources().getDrawable(R.drawable.ic_home_black_24dp) :
                    null);
        });
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
