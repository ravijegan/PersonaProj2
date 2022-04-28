package com.example.personaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BacklogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backlog);
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
                Intent intent = new Intent(this, BacklogActivity.class);
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
