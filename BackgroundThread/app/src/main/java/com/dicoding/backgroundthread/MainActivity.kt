package com.dicoding.backgroundthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executor
import java.util.concurrent.Executors

// Cara tanpa Coroutine
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val btnStart = findViewById<Button>(R.id.btn_start)
//        val tvsStatus = findViewById<TextView>(R.id.tv_status)
//
//        val executor = Executors.newSingleThreadExecutor()
//        val handler = Handler(Looper.getMainLooper())
//
//        btnStart.setOnClickListener {
//            executor.execute {
//                try {
////                Simulate process compressing
//                    for (i in 0..10) {
//                        Thread.sleep(500)
//                        val percentage = i * 10
//                        handler.post {
//                            if (percentage == 100) {
//                                tvsStatus.setText(R.string.task_completed)
//                            } else {
//                                tvsStatus.text =
//                                    String.format(getString(R.string.compressing), percentage)
//                            }
//                        }
//                    }
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//            }
//        }
//    }
//}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btn_start)
        val tvsStatus = findViewById<TextView>(R.id.tv_status)

        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        btnStart.setOnClickListener {
            lifecycleScope.launch {
//                Simulate process compressing
                for (i in 0..10) {
                    delay(500)
                    val percentage = i * 10
//                    perlu pindah ke Main Thread untuk update UI berupa TextView, jika tidak menggunakan ini, maka UI/TextView tidak akan pernah ter-update.
                    withContext(Dispatchers.Main) {
                        if (percentage == 100) {
                            tvsStatus.setText(R.string.task_completed)
                        } else {
                            tvsStatus.text =
                                String.format(getString(R.string.compressing), percentage)
                        }
                    }
                }
            }
        }
    }
}

