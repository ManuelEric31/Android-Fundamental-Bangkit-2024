package com.dicoding.mynotesapp.helper

import android.database.Cursor
import com.dicoding.mynotesapp.db.DatabaseContract
import com.dicoding.mynotesapp.entity.Note

object MappingHelper {

    fun mapCursorToArrayList(noteCursor: Cursor?): ArrayList<Note> {

        val noteList = ArrayList<Note>()

//        Fungsi apply digunakan untuk menyederhanakan kode yang berulang.
//        Misalnya notesCursor.geInt cukup ditulis getInt dan
//        notesCursor.getColumnIndexOrThrow cukup ditulis getColumnIndexOrThrow

        noteCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
                noteList.add(Note(id,title,description,date))
            }
        }

        return noteList
    }
}