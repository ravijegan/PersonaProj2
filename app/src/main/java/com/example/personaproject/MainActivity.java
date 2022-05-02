package com.example.personaproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> backlogtaskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backlogtaskList = new ArrayList<>(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.homeMenu:{
               System.out.println("testing");
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.createMenu:{
                System.out.println("testing 2");
                Intent intent = new Intent(this, CreateActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.backlogMenu:{
                System.out.println("testing 3");
                backlogtaskList.add(new Task("task 1", "task 1 description", 2, "Guts"));
                backlogtaskList.add(new Task("task 2", "task 2 description", 3, "Knowledge"));
                backlogtaskList.add(new Task("task 3", "task 3 description", 4, "Charm"));
                Intent intent = new Intent(this, BacklogActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("taskList", backlogtaskList);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
                break;
            }
            case R.id.todayMenu:{
                System.out.println("testing 4");
                Intent intent = new Intent(this,DailyActivity.class);
                startActivity(intent);
                break;
            }
        }
        return true;
    }
}