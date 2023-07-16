//package com.example.devbytes.viewmodels
//
//import android.app.Application
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//
//class DevByteViewModelFactory(val app: Application) :ViewModelProvider.Factory{
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(DevByteViewModel::class.java)){
//            return DevByteViewModel(app) as T
//        }
//        throw java.lang.IllegalArgumentException("Unable to construct viewmodel")
//    }
//
//}