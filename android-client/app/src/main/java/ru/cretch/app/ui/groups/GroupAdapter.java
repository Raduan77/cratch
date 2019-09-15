package ru.cretch.app.ui.groups;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import ru.cretch.app.R;
import ru.cretch.app.ui.groupinfo.GroupInfo;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.MyViewHolder> {
    private ArrayList<GroupModel> mDataset = new ArrayList<>();
    private Context context;

    GroupAdapter(Context context) {
        this.context = context;
    }

    public void setDataset(ArrayList<GroupModel> mDataset) {
        this.mDataset = mDataset;
        notifyDataSetChanged();
    }

    @Override
    public GroupAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_group_card, parent, false);

        v.setOnClickListener(v1 -> context.startActivity(new Intent(context, GroupInfo.class)));
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(mDataset.get(position).title);
        holder.subtitle.setText(mDataset.get(position).subtitle);
        holder.large.setImageDrawable(getDrawable(mDataset.get(position).largeIcon));
        holder.medium.setImageDrawable(getDrawable(mDataset.get(position).mediumItem));
        holder.small.setImageDrawable(getDrawable(mDataset.get(position).smallItem));
    }

    private Drawable getDrawable(Integer id){
        return context.getDrawable(id);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;
        CircleImageView large, medium,small;

        MyViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.group_title);
            subtitle = v.findViewById(R.id.group_subtitle);
            large = v.findViewById(R.id.profile_image_large);
            medium = v.findViewById(R.id.profile_image_medium);
            small = v.findViewById(R.id.profile_image_small);
        }
    }
}
