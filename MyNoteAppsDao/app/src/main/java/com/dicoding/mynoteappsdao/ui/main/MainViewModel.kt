package com.dicoding.mynoteappsdao.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.mynoteappsdao.database.Note
import com.dicoding.mynoteappsdao.repository.NoteRepository

// Bagian kelas ViewModel jadi lebih singkat,
// hanya menginisialisasi kelas Repository dan mengambil fungsi yang ada pada kelas tersebut.
class MainViewModel(application: Application) : ViewModel() {
    private val mNoteRepository: NoteRepository = NoteRepository(application)

//    Anda bisa mendapatkan list notes dengan cara memanggil metode getAllNotes().
//    Hal ini karena Anda menggunakan LiveData yang bersifat asynchronous
    fun getAllNotes(): LiveData<List<Note>> = mNoteRepository.getAllNotes()
}