package com.dicoding.newsapp.data

//mengetahui apakah sebuah request berhasil atau tidak dengan memanfaatkan kelas Result
sealed class Result<out R> private constructor(){
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: String): Result<Nothing>()
    object Loading: Result<Nothing>()
}