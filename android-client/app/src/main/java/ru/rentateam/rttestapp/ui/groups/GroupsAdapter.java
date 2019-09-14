package ru.rentateam.rttestapp.ui.groups;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import ru.rentateam.rttestapp.R;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.MyViewHolder> {
    private GroupModel[] mDataset;

    GroupsAdapter(GroupModel[] myDataset) {
        mDataset = myDataset;
    }

    public void setDataset(GroupModel[] mDataset) {
        this.mDataset = mDataset;
        notifyDataSetChanged();
    }

    @Override
    public GroupsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_group_card, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(mDataset[position].title);
        holder.subtitle.setText(mDataset[position].subtitle);
        holder.large.setImageDrawable(mDataset[position].largeIcon);
        holder.medium.setImageDrawable(mDataset[position].mediumItem);
        holder.small.setImageDrawable(mDataset[position].smallItem);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
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
