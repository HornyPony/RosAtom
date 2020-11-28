package com.example.rosatom.Tasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rosatom.R;
import com.example.rosatom.VerticalSpacingItemDecorator;

import java.util.ArrayList;
import java.util.List;

public class TasksActivity extends AppCompatActivity {
    private List<Task> taskList;
    private TaskAdapter taskAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        VerticalSpacingItemDecorator verticalSpacingItemDecorator = new VerticalSpacingItemDecorator(30);
        taskList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        taskList.add(new Task("Проверка оборудования", "Куликов Д. А.", "Проверка оборудования",
                "Высокий", "8:00", "8:30"));
        taskList.add(new Task("Встреча с Президентом", "Куликов Д. А.", "Соц. медиа",
                "Высокий", "11:21", "13:30"));
        taskList.add(new Task("Уборка помещения", "Заммоев А. В.", "Уборка",
                "Средний", "8:00", "18:00"));
        taskList.add(new Task("Рассказать как прошла встреча", "Куликов Д. А.", "Соц. медиа",
                "Не срочно", "11:23", "16:30"));
        taskAdapter = new TaskAdapter(taskList);
        recyclerView.addItemDecoration(verticalSpacingItemDecorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(taskAdapter);
    }
}