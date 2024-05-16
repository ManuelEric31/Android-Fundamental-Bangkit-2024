package com.dicoding.resturantreviewretrofit.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dicoding.resturantreviewretrofit.R
import com.dicoding.resturantreviewretrofit.data.response.CustomerReviewsItem
import com.dicoding.resturantreviewretrofit.data.response.PostReviewResponse
import com.dicoding.resturantreviewretrofit.data.response.Restaurant
import com.dicoding.resturantreviewretrofit.data.response.RestaurantResponse
import com.dicoding.resturantreviewretrofit.data.retrofit.ApiConfig
import com.dicoding.resturantreviewretrofit.data.retrofit.ApiService
import com.dicoding.resturantreviewretrofit.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()

    companion object {
        private const val TAG = "MainActivity"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        supportActionBar?.hide()

        // val mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        mainViewModel.restaurant.observe(this) {restaurant ->
            setRestaurantData(restaurant)
        }
        
        val layoutManager = LinearLayoutManager(this)
        binding.rvReview.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration (this, layoutManager.orientation)
        binding.rvReview.addItemDecoration(itemDecoration)


        mainViewModel.listReview.observe(this) {consumerReviews ->
            setReviewdata(consumerReviews)
        }

        mainViewModel.isLoading.observe(this) {
            showLoading(it)
        }


        mainViewModel.snackbarText.observe(this, {
//            Snackbar.make(window.decorView.rootView, it, Snackbar.LENGTH_SHORT).show()
            it.getContentIfNotHandled()?.let { snackBarText ->
                Snackbar.make(
                    window.decorView.rootView,
                    snackBarText,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        })
        binding.btnSend.setOnClickListener {view ->
            mainViewModel.postReview(binding.eddReview.text.toString())
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


    private fun setReviewdata(consumerReviews: List<CustomerReviewsItem>) {
        val adapter = ReviewAdapter()
        adapter.submitList(consumerReviews)
        binding.rvReview.adapter = adapter
        binding.eddReview.setText("")
    }

    private fun setRestaurantData(restaurant: Restaurant) {
        binding.tvTitle.text = restaurant.name
        binding.tvDescription.text = restaurant.description
        Glide.with(this@MainActivity)
            .load("https://restaurant-api.dicoding.dev/images/large/${restaurant.pictureId}")
            .into(binding.ivRestaurant)
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}