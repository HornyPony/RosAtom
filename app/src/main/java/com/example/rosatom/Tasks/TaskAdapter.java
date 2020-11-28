package com.example.rosatom.Tasks;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rosatom.R;
import com.example.rosatom.databinding.TaskItemBinding;

import java.util.List;

class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    private List<Task> taskList;

    TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TaskItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.task_item, parent, false);
        return new TaskAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskTV.setText(task.getTask());
        holder.subordinationTV.setText(task.getSubordination());
        holder.priorityTV.setText(task.getPriority());
        holder.periodTV.setText(task.getPeriod());
        holder.gaveTimeTV.setText(task.getGaveTime());
        holder.typeOfWorkTV.setText(task.getTypeOfWork());

        switch (holder.priorityTV.getText().toString()) {
            case ("Высокий"):
                holder.priorityTV.setTextColor(Color.RED);
                break;
            case ("Средний"):
                holder.priorityTV.setTextColor(Color.YELLOW);
                break;
            case ("Не срочно"):
                holder.priorityTV.setTextColor(Color.GREEN);
                break;


        }
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TaskItemBinding binding;

        final TextView taskTV, subordinationTV, periodTV, priorityTV, typeOfWorkTV, gaveTimeTV;

        public ViewHolder(TaskItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            taskTV = binding.taskTV;
            subordinationTV = binding.subordinationTV;
            priorityTV = binding.priorityTV;
            periodTV = binding.periodTV;
            typeOfWorkTV = binding.typeOfWorkTV;
            gaveTimeTV = binding.gaveTimeTV;
        }
    }
}
