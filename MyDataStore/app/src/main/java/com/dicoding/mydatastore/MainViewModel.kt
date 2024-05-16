package com.dicoding.mydatastore

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// ViewModelFactory
//Perlu diketahui, kita tidak bisa membuat ViewModel dengan constructor secara langsung. Untuk itu, kita perlu
// membuat class yang extend ke ViewModelProvider untuk bisa memasukkan constructor ke dalam ViewModel.
class MainViewModel(private val pref: SettingPreferences) : ViewModel() {
    fun getThemeSettings(): LiveData<Boolean> {
//        asLiveData merupakan fungsi yang digunakan untuk mengubah Flow menjadi LiveData
        return pref.getThemeSetting().asLiveData()
    }

    fun saveThemeSetting(isDarkModeActive: Boolean) {
        viewModelScope.launch {
            pref.saveThemeSetting(isDarkModeActive)
        }
    }
}