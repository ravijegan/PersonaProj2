package com.example.personaproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BacklogAdapter extends RecyclerView.Adapter<BacklogAdapter.viewHolder> {

    ArrayList<Task> backlogtasklist;
    Context mcontext;

    public interface OnItemClickListener{
        void onItemClick(Task backlogtask);
    }

    private final OnItemClickListener listener;

    public BacklogAdapter(ArrayList<Task> backlogtaskList, Context context, OnItemClickListener clickListener){
        this.backlogtasklist = backlogtaskList;
        this.mcontext = context;
        listener = clickListener;
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView points;
        private final TextView section;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.backlogtaskNameId);
            points = itemView.findViewById(R.id.backlogpointsId);
            section = itemView.findViewById(R.id.backlogsectionId);

        }

        public TextView getName() {
            return name;
        }
        public TextView getPoints() {
            return points;
        }
        public TextView getSection() {
            return section;
        }

    }

    @NonNull
    @Override
    public BacklogAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(mcontext);
        View view = myInflater.inflate(R.layout.backlog_task, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BacklogAdapter.viewHolder holder, int position) {

        holder.getName().setText(backlogtasklist.get(position).getName());
        holder.getPoints().setText(String.valueOf(backlogtasklist.get(position).getPoints()));
        holder.getSection().setText(String.valueOf(backlogtasklist.get(position).getSection()));
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                listener.onItemClick(backlogtasklist.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return backlogtasklist.size();
    }
}
