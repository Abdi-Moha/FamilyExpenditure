package com.example.familyexpenditure;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class FamExpMainActivity extends AppCompatActivity implements ExpenditureAdapter
        .ExpenditureListItemClickListener {
    RecyclerView expenditureRecycleView;
    ExpenditureAdapter expenditureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fam_exp_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        expenditureRecycleView = findViewById(R.id.recyclerView);

        expenditureAdapter = new ExpenditureAdapter(this, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        expenditureRecycleView.setLayoutManager(linearLayoutManager);
        expenditureRecycleView.setHasFixedSize(true);
        expenditureRecycleView.setAdapter(expenditureAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddNewItem = new Intent(FamExpMainActivity.this, AddNewMainActivity.class);
                startActivity(AddNewItem);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        List<Expenditure> expenditures = getDb().expenditureDao().selectAllUsers();
    }

    public ExpenditureDatabase getDb() {
        String dataName = "expenditure_db";
        ExpenditureDatabase db = Room.databaseBuilder(getApplicationContext(), ExpenditureDatabase.class,
                dataName).allowMainThreadQueries().build();
        return db;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fam_exp_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(int itemId) {
        Intent takeMeToDetailsActivity = new Intent(this, ExpenditureDetails.class);
        takeMeToDetailsActivity.putExtra(Intent.EXTRA_TEXT,itemId);
        startActivity(takeMeToDetailsActivity);

    }
}
