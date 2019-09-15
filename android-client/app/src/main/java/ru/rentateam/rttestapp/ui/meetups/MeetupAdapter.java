package ru.rentateam.rttestapp.ui.meetups;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import ru.rentateam.rttestapp.R;
import ru.rentateam.rttestapp.ui.groups.GroupModel;

public class MeetupAdapter extends RecyclerView.Adapter<MeetupAdapter.MyViewHolder> {
    private MeetupModel[] mDataset;

    MeetupAdapter(MeetupModel[] myDataset) {
        mDataset = myDataset;
    }

    public void setDataset(MeetupModel[] mDataset) {
        this.mDataset = mDataset;
        notifyDataSetChanged();
    }

    @Override
    public MeetupAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meetup_card, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(mDataset[position].title);
        holder.subtitle.setText(mDataset[position].subtitle);
        holder.time.setText(mDataset[position].time);
        holder.place.setText(mDataset[position].place);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle, time, place;

        MyViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.meetup_title);
            subtitle = v.findViewById(R.id.meetup_subtitle);
            time = v.findViewById(R.id.meetup_time);
            place = v.findViewById(R.id.meetup_place);
        }
    }
}
