package com.example.familyexpenditure;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ExpenditureDao {

    @Query("SELECT * FROM Expenditure")
    List<Expenditure> selectAllUsers();

    @Query("SELECT * FROM Expenditure WHERE id = :id")
    Expenditure getSingleExpenditureById(int id);

    @Insert
    void insertSingleUser(Expenditure user);

    @Delete
    void deleteUser(Expenditure user);
}
