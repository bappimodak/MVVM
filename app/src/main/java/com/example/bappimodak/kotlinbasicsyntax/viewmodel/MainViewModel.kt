package com.example.bappimodak.kotlinbasicsyntax.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.bappimodak.kotlinbasicsyntax.model.NicePlaces

class MainViewModel : ViewModel() {

    private lateinit var listOfBlog: MutableLiveData<List<NicePlaces>>

    fun init(){
        listOfBlog = NicePlacesRepository.getInstance().getCountryList()
    }

    fun getBlog(): LiveData<List<NicePlaces>> {
        return listOfBlog
    }
}