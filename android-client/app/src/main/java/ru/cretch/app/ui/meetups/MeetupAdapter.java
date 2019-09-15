package ru.cretch.app.ui.meetups;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import ru.cretch.app.R;
import ru.cretch.app.ui.meetupinfo.MeetupInfo;

public class MeetupAdapter extends RecyclerView.Adapter<MeetupAdapter.MyViewHolder> {
    private MeetupModel[] mDataset;
    private Context context;

    MeetupAdapter(Context context, MeetupModel[] myDataset) {
        this.context = context;
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

        v.setOnClickListener(v1 -> context.startActivity(new Intent(context, MeetupInfo.class)));
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
