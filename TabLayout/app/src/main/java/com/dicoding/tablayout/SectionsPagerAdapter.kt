package com.dicoding.tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    var appName: String = ""
//    val sectionsPagerAdapter = SectionsPagerAdapter(this)
//    sectionsPagerAdapter.appName = resources.getString(R.string.app_name)
//    Fungsi getItemCount digunakan untuk menentukan jumlah tab yang ingin ditampilkan.
    override fun getItemCount(): Int {
        return 3
    }

//    Fungsi createFragment digunakan untuk menampilkan fragment sesuai dengan posisi tab-nya.
    override fun createFragment(position: Int): Fragment {
        var fragment = HomeFragment()
        fragment.arguments = Bundle().apply {
            putInt(HomeFragment.ARG_SECTION_NUMBER, position+1)
            putString(HomeFragment.ARG_NAME, appName)
        }
        return fragment
    }

}