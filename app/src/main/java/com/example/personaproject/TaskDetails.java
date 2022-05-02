package com.example.personaproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.NoCopySpan;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TaskDetails extends AppCompatActivity {


    TextView detailName;
    TextView detailSection;
    TextView detailPoints;
    TextView detailsDescription;
    Task task;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.task_details_view);
        detailName = (TextView) findViewById(R.id.detailsNameId);
        detailSection = (TextView) findViewById(R.id.detailsSectionId);
        detailPoints = (TextView) findViewById(R.id.detailsPointsId);
        detailsDescription = (TextView) findViewById(R.id.detailsDescriptionId);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        task = bundle.getParcelable("task");

        detailName.setText("Task:" + task.getName());
        detailSection.setText(String.valueOf("Section:" + task.getSection()));
        detailPoints.setText("Points:" + task.getPoints());
        detailsDescription.setText("Description: " + task.getDescription());
    }

}
