package com.dicoding.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit

class HomeFragment : Fragment(), View.OnClickListener {

//    Pada HomeFragment terdapat metode onCreateView() di mana layout interface didefinisikan dan ditransformasikan dari layout berupa file xml ke dalam objek view
    //    dengan menggunakan metode inflate().

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        Inflater.inflate() merupakan objek dari LayoutInflater yang berfungsi untuk mengubah layout xml ke dalam bentuk objek viewgroup atau widget melalui pemanggilan metode inflate().
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

//    Pada HomeFragment terdapat metode onCreateView() di mana layout interface didefinisikan dan ditransformasikan dari layout berupa file xml ke dalam objek view dengan menggunakan metode inflate().
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory : Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val categoryFragment = CategoryFragment()
        val fragmentManager = parentFragmentManager
//        fragmentManager.beginTransaction().apply {
//            replace(R.id.frame_container, categoryFragment, CategoryFragment::class.java.simpleName)
//            addToBackStack(null)
//            commit()
//        }
        fragmentManager.commit {
            addToBackStack(null)
            replace(R.id.frame_container, categoryFragment, CategoryFragment::class.java.simpleName)
        }
    }


}