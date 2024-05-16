package com.dicoding.mynoteappsdao.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.dicoding.mynoteappsdao.database.Note
import com.dicoding.mynoteappsdao.database.NoteDao
import com.dicoding.mynoteappsdao.database.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
//    Jika Anda perhatikan, NoteDao bisa langsung Anda gunakan dengan cara
    //    mendefinisikan RoomDatabase.
    private val mNotesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteRoomDatabase.getDatabase(application)
        mNotesDao = db.noteDao()
    }

    fun getAllNotes(): LiveData <List<Note>> = mNotesDao.getAllNotes()

    fun insert(note: Note) {
        executorService.execute{mNotesDao.insert(note)}
    }

    fun delete(note: Note) {
        executorService.execute{mNotesDao.delete(note)}
    }

    fun update(note: Note) {
        executorService.execute{mNotesDao.update(note)}
    }
}