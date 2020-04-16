package com.example.inventorymanager;

import android.graphics.Canvas;
import android.os.Bundle;

import com.example.inventorymanager.adapters.HomeView_v2_RecyclerViewAdapter;
import com.example.inventorymanager.model.Profile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class HomeviewV2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HomeView_v2_RecyclerViewAdapter adapter;

    private ArrayList<Profile> profileList;

    //For add popup
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private Button saveButton;
    private EditText profileNameEditText;
    private EditText descriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeview_v2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profiles");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopupDialog();
//                Snackbar.make(view, "This will soon let user add a profile!!!",
//                        Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        // Recycler View Connections

        recyclerView = findViewById(R.id.profilerecyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //test arraylist examples
        profileList = new ArrayList<>();
        profileList.add(new Profile("David", "Personal"));
        profileList.add(new Profile("Neal", "Business"));
        profileList.add(new Profile("Kyle", "Personal"));
        profileList.add(new Profile("Josh", "Business"));
        profileList.add(new Profile("Yasmeen", "Personal"));

        //init adapter and connect to arraylist
        adapter = new HomeView_v2_RecyclerViewAdapter(this, profileList);
        recyclerView.setAdapter(adapter);
    }

    private void createPopupDialog() {
        builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.popup_addprofile_inhomeview, null);

        profileNameEditText = view.findViewById(R.id.profileName);
        descriptionEditText = view.findViewById(R.id.description);
        saveButton = view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!profileNameEditText.getText().toString().isEmpty() && descriptionEditText.getText().toString().isEmpty()) {
                    //save the item
                }
                else {
                    Snackbar.make(v, "Empty fields", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        builder.setView(view);
        dialog = builder.create();
        dialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_homeview, menu);
        return true;
    }

}