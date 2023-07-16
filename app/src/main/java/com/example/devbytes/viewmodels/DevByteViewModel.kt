//package com.example.devbytes.viewmodels
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.viewModelScope
//import com.example.devbytes.domain.DevByteVideo
//import com.example.devbytes.network.DevByteNetwork
//import kotlinx.coroutines.*
//import java.io.IOException
//
//
//class DevByteViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val _playlist = MutableLiveData<List<DevByteVideo>>()
//    val playlist: LiveData<List<DevByteVideo>>
//        get() = _playlist
//
//    var text = MutableLiveData<String>()
//
//    init{
//        refreshDataFromNetwork()
//    }
//
//    private fun refreshDataFromNetwork(){
//        viewModelScope.launch {
//            try {
//                val playlist = DevByteNetwork.debytes.getPlaylist()
//                text.value = playlist.videos[0].toString()
//            }catch (networkError: IOException) {
//                text.value = networkError.toString()
//            }
//        }
//    }
//
//}
