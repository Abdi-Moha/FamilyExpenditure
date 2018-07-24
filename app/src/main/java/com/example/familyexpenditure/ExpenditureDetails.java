package com.example.familyexpenditure;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ExpenditureDetails extends AppCompatActivity {
    TextView Item;
    TextView Quantity;
    TextView Amount;
    TextView Status;
    TextView Date;
    TextView Comment;
    int itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenditure_details);
        Item = findViewById(R.id.tvItem);
        Quantity = findViewById(R.id.tvQuantity);
        Amount = findViewById(R.id.tvAmount);
        Status = findViewById(R.id.tvStatus);
        Date = findViewById(R.id.tvDate);
        Comment = findViewById(R.id.tvComment);

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)){
            itemId = intent.getIntExtra(Intent.EXTRA_TEXT,-1);
            Expenditure expenditure = getDb().expenditureDao().getSingleExpenditureById(itemId);
            UpdateUI(expenditure);
        }
    }
    public void UpdateUI(Expenditure expenditure) {
        Item.setText(expenditure.getItem());
        Quantity.setText(expenditure.getQuantity());
        Amount.setText(expenditure.getAmount());
        Status.setText(expenditure.getStatus());
        Date.setText(expenditure.getDate());
        Comment.setText(expenditure.getComment());
    }
    public ExpenditureDatabase getDb() {
        String dataName = "expenditure_db";
        ExpenditureDatabase db = Room.databaseBuilder(getApplicationContext(), ExpenditureDatabase.class,
                dataName).allowMainThreadQueries().build();
        return db;
    }
}
