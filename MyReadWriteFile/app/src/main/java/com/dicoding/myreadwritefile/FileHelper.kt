package com.dicoding.myreadwritefile

import android.content.Context

internal object FileHelper {

    fun writeToFile(fileModel: FileModel, context: Context) {
//        metode openFileOutput() untuk membuka berkas sesuai dengan namanya.
        context.openFileOutput(fileModel.filename, Context.MODE_PRIVATE).use {
            it.write(fileModel.data?.toByteArray())
        }
    }

    fun readFromFile(context: Context, filename: String) : FileModel {
//        contoh tambahan bagaimana metode static dapat dipanggil tanpa menginisasi kelas yang memilikinya.
        val fileModel = FileModel()
        fileModel.filename = filename
//        Data pada berkas akan dibaca menggunakan stream dan
//        data pada tiap baris dalam berkas akan mampu diperoleh dengan menggunakan bufferedReader.
        fileModel.data = context.openFileInput(filename).bufferedReader().useLines { lines ->
            lines.fold("") {some, text ->
                "$some$text\n"
            }
        }
        return fileModel
    }
}