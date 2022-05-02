package com.example.personaproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BacklogActivity extends AppCompatActivity {

    ArrayList<Task> backlogtasks;
    RecyclerView backlogRecycler;
    BacklogAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backlog);

        backlogRecycler = (RecyclerView) findViewById(R.id.backlogListId);

        if(getIntent().hasExtra("bundle")){
            System.out.print("there is a bundle");
            Bundle bundle = getIntent().getBundleExtra("bundle");
            backlogtasks = bundle.getParcelableArrayList("taskList");
            System.out.println(" size of backlog list is " + backlogtasks.size());
        }

        backlogRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BacklogAdapter(backlogtasks, this, new BacklogAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Task task) {
                selectDetails(task);
            }
        });

        backlogRecycler.setAdapter(adapter);
    }

    private void selectDetails(Task task){
        Intent newIntent = new Intent(this, TaskDetails.class);
        Bundle newbundle = new Bundle();
        newbundle.putParcelable("task", task);
        newIntent.putExtra("bundle", newbundle);
        startActivity(newIntent);
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
