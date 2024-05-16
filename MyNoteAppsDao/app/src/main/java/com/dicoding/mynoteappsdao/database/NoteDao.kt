package com.dicoding.mynoteappsdao.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

// Keperluan CRUD dan wajib anotasi Dao
@Dao
interface NoteDao {
//     kode OnConflictStrategy.IGNORE digunakan jika data yang dimasukkan sama, maka dibiarkan saja.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(note:Note)

    @Update
    fun update(note:Note)

    @Delete
    fun delete(note:Note)

    @Query("SELECT * from note ORDER BY id ASC")
    fun getAllNotes() : LiveData<List<Note>>
}