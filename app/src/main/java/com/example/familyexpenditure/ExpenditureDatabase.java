package com.example.familyexpenditure;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Expenditure.class}, version = 1, exportSchema = false)
public abstract class ExpenditureDatabase extends RoomDatabase {
    public abstract ExpenditureDao expenditureDao();
}
