package com.example.familyexpenditure;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Expenditure {
    String Item;
    String Quantity;
    String Amount;
    String Status;
    String Date;
    String Comment;
    @PrimaryKey(autoGenerate = true)
    int id;

    public Expenditure(String item, String quantity, String amount, String status, String date, String comment, int id) {
        Item = item;
        Quantity = quantity;
        Amount = amount;
        Status = status;
        Date = date;
        Comment = comment;
        this.id = id;
    }

    @Ignore
    public Expenditure(String item, String quantity, String amount, String status, String date, String comment) {
        Item = item;
        Quantity = quantity;
        Amount = amount;
        Status = status;
        Date = date;
        Comment = comment;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
