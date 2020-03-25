package com.example.inventorymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventorymanager.adapters.HomeViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Context context;
    private RecyclerView recyclerView;
    private HomeViewAdapter adapter;
    private ArrayList<Profile> profileArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingButton);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeviewActivity.class);
                startActivity(intent);
            }
        });

        //connect recyler view
        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //test arraylist examples
        profileArrayList = new ArrayList<>();
        profileArrayList.add(new Profile("David", "Personal"));
        profileArrayList.add(new Profile("Neil", "Business"));
        profileArrayList.add(new Profile("Kyle", "Personal"));
        profileArrayList.add(new Profile("Josh", "Business"));
        profileArrayList.add(new Profile("Yasmeen", "Personal"));
        profileArrayList.add(new Profile("Yasmeen", "Personal"));
        profileArrayList.add(new Profile("Yasmeen", "Personal"));
        profileArrayList.add(new Profile("Yasmeen", "Personal"));
        profileArrayList.add(new Profile("Yasmeen", "Personal"));

        //init adapter and connect to arraylist
        adapter = new HomeViewAdapter(this, profileArrayList);
        recyclerView.setAdapter(adapter);
    }

    //TODO: Make clickable cells go to LocationViewActivity

    //TODO: Add button so user can create a profile (floating button?)
}
