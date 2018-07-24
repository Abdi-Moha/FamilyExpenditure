package com.example.familyexpenditure;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewMainActivity extends AppCompatActivity {
    EditText etItem;
    EditText etQuantity;
    EditText etAmount;
    EditText etDate;
    EditText etComment;

    String Item;
    String Quantity;
    String Amount;
    String Status;
    String Date;
    String Comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_main);
        etItem = findViewById(R.id.etItem);
        etQuantity = findViewById(R.id.etQuantity);
        etAmount = findViewById(R.id.etAmount);
        etDate = findViewById(R.id.etDate);
        etComment = findViewById(R.id.etComment);
    }
    public void getStatus(View view) {
        int viewId = view.getId();

        if (viewId == R.id.rbPaid) {
            Status = "paid";
            Toast.makeText(this,"paid selected" + Status, Toast.LENGTH_SHORT).show();
        }else if (viewId == R.id.rbCredit) {
            Status = "credit";
            Toast.makeText(this,"paid selected" + Status, Toast.LENGTH_SHORT).show();
        }
    }
    public void Save(View savebutton) {

        Item = etItem.getText().toString();
        Quantity = etQuantity.getText().toString();
        Amount = etAmount.getText().toString();
        Date = etDate.getText().toString();
        Comment = etComment.getText().toString();

        if (!Item.isEmpty() && !Quantity.isEmpty() && !Amount.isEmpty() && !Date.isEmpty() &&
                !Comment.isEmpty()) {
            Expenditure newUser = new Expenditure(Item,Quantity,Amount,Date,Comment,Status);

            Toast.makeText(this,"we typed item" + newUser.getItem() + "and quantity" +
                    newUser.getQuantity(), Toast.LENGTH_SHORT).show();

            getDb().expenditureDao().insertSingleUser(newUser);
            Intent intent = new Intent(this, FamExpMainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Enter All Fields", Toast.LENGTH_SHORT).show();
        }
    }

    public ExpenditureDatabase getDb() {
        String dataName = "expenditure_db";
        ExpenditureDatabase db = Room.databaseBuilder(getApplicationContext(), ExpenditureDatabase.class,
                dataName).allowMainThreadQueries().build();
        return db;
    }
}
