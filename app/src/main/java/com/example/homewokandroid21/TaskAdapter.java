package com.example.homewokandroid21;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.HolderTask>{

    private List<TaskModel>list = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public TaskAdapter.HolderTask onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new HolderTask(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TaskAdapter.HolderTask holder, int position) {
        holder.bing(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addInfo(TaskModel taskModel){
       list.add(taskModel);
       notifyDataSetChanged();
    }

    public class HolderTask extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtDescription;
        public HolderTask(@NonNull @NotNull View itemView) {
            super(itemView);
            txtTitle=itemView.findViewById(R.id.txt_title);
            txtDescription=itemView.findViewById(R.id.txt_description);
        }

        public void bing(TaskModel taskModel) {
            txtTitle.setText(taskModel.getTitle());
            txtDescription.setText(taskModel.getDescription());
        }
    }
}
