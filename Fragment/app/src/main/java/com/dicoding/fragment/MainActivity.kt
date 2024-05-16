package com.dicoding.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name : " + HomeFragment::class.java.simpleName)

//            Metode add() akan menambahkan objek fragment ke dalam layout container.
//            Layout container ini merupakan objek framelayout dengan ID frame_container. Ia memiliki tag dengan nama kelas dari HomeFragment itu sendiri.
//
        //            fragmentManager
//                .beginTransaction()
//                .add(R.id.frame_container, homeFragment, HomeFragment::class.java.simpleName)
//
////                Metode .commit() di atas akan mengeksekusi untuk melakukan pemasangan objek secara asynchronous untuk ditampilkan ke antar muka pengguna (user interface).
//                .commit()
            fragmentManager.commit {
                add(R.id.frame_container, homeFragment, HomeFragment::class.java.simpleName)
            }
        }
    }
}