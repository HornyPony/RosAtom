package com.example.rosatom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class InformationReportActivity extends AppCompatActivity {
private List<InformationReport> reportList;
private ReportAdapter reportAdapter;
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_report);

        VerticalSpacingItemDecorator verticalSpacingItemDecorator = new VerticalSpacingItemDecorator(30);
        reportList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        reportList.add(new InformationReport("Новогодний корпоратив", "29.11.2020","Руководитель цеха",
                "Всем", "Примите самые искренние поздравления с Новым годом и Рождеством! Пусть этот год станет началом благоприятных перемен и успешных дел и каждый его день будет плодотворным в работе и счастливым в личной жизни. Приглашаем Вас провести незабываемый предновогодний вечер в кругу друзей и коллег. Мы ждем Вас 29 декабря 2020 года в Главном офисе нашей компании в 17:00. Будем рады встрече!"));
        reportList.add(new InformationReport("Придется задержаться на работе",
                "29.11.2020",   "Руководитель цеха",  "Цех №31", "Прошу вас задержаться сегодня на работе"));
        reportAdapter = new ReportAdapter(reportList);
        recyclerView.addItemDecoration(verticalSpacingItemDecorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(reportAdapter);
    }
}