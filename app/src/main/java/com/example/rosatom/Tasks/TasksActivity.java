package com.example.rosatom.Tasks;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.rosatom.R;
import com.example.rosatom.VerticalSpacingItemDecorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TasksActivity extends AppCompatActivity {
    private ArrayList<Task> taskList;
    private TaskAdapter taskAdapter;
    private RecyclerView recyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.filter_tasks_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filterMenuItem:
                startActivity(new Intent(TasksActivity.this, FilterTasksActivity.class));
                break;
            case R.id.sortingMenuItem:
                Intent intent = new Intent(TasksActivity.this, SortingTasksActivity.class);
                intent.putExtra("taskList", taskList);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        VerticalSpacingItemDecorator verticalSpacingItemDecorator = new VerticalSpacingItemDecorator(30);
        taskList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        taskList.add(new Task("Проверка оборудования", "Куликов Д. А.", "Проверка оборудования",
                "Высокий", "8:00", "8:30"));

        taskList.add(new Task("Уборка помещения", "Заммоев А. В.", "Уборка",
                "Средний", "8:00", "18:00"));
        taskList.add(new Task("Рассказать как прошла встреча", "Куликов Д. А.", "Соц. медиа",
                "Не срочно", "11:23", "16:30"));
        taskList.add(new Task("Встреча с Президентом", "Куликов Д. А.", "Соц. медиа",
                "Высокий", "11:21", "13:30"));
       // taskList.sort(Comparator.comparing(Task:: getPriorityType));
        taskAdapter = new TaskAdapter(taskList);
        recyclerView.addItemDecoration(verticalSpacingItemDecorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(taskAdapter);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        taskAdapter.notifyDataSetChanged();
    }
}