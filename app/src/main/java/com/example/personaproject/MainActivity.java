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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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