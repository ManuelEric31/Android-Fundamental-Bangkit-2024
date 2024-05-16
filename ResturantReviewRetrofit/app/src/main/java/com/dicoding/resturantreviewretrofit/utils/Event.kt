package com.dicoding.resturantreviewretrofit.utils

open class Event <out T> (private val content: T) {

     @Suppress("MemberVisibilityCanBePrivate")
     var hasBeenHandled = false
         private set

     fun getContentIfNotHandled() : T? {
         return if (hasBeenHandled) {
             null
         } else {
             hasBeenHandled = true
             content
         }
     }

//    fungsi peekContent yang bisa Anda gunakan untuk melihat nilai dari content walaupun aksi event sudah dilakukan.
    fun peekContent () : T = content
}