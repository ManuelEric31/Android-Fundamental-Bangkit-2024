package com.dicoding.mynoteappsdao.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

// Default dari nama tabel adalah sesuai dengan nama kelas tersebut
@Entity
@Parcelize
data class Note (

//    autoGenerate digunakan untuk membuat id secara otomatis.
//    Prinsipnya sama seperti ketika Anda menggunakan database SQL.
    @PrimaryKey(autoGenerate = true)

//    Kode @ColumnInfo digunakan untuk memberi nama column dari tabel.
//    Jika tidak diberi nama, maka default dari nama column adalah variable tersebut.
    @ColumnInfo(name = "id")
    var id : Int = 0,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "date")
    var date: String? = null
) : Parcelable