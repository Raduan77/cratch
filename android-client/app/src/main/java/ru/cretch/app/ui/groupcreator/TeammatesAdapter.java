package ru.cretch.app.ui.groupcreator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import ru.cretch.app.R;

public class TeammatesAdapter extends RecyclerView.Adapter<TeammatesAdapter.MyViewHolder> {

    List<TeammatesModel> mDataset = new ArrayList<>();
    public TeammatesAdapter(TeammatesModel[] myDataset) {
        mDataset = Arrays.asList(myDataset);
    }

    public void setDataset(TeammatesModel[] teammate) {
        mDataset = Arrays.asList(teammate);
        notifyDataSetChanged();
    }

    public void addTeammate(TeammatesModel teammate) {
        mDataset.remove(mDataset.size()-1);
        this.mDataset.add(teammate);
        mDataset.add(new TeammatesModel());
        notifyDataSetChanged();
    }

    @Override
    public TeammatesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_teammates, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (position != mDataset.size() - 1) {
            holder.name.setText(mDataset.get(position).name);
            holder.tag.setText(mDataset.get(position).tag);
            holder.image.setImageDrawable(mDataset.get(position).avatarIcon);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, tag;
        CircleImageView image;

        MyViewHolder(View v) {
            super(v);
            tag = v.findViewById(R.id.teammates_name);
            name = v.findViewById(R.id.teammates_tag);
            image = v.findViewById(R.id.teammates_image);
        }
    }
}
