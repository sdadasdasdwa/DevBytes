package com.example.devbytes.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.devbytes.database.getDatabase
import com.example.devbytes.domain.DevByteVideo
import com.example.devbytes.network.DevByteNetwork
import com.example.devbytes.network.asDomainModel
import com.example.devbytes.repository.VideosRepository
import kotlinx.coroutines.*
import java.io.IOException


class DevByteViewModel(application: Application) : AndroidViewModel(application) {

//    private val _playlist = MutableLiveData<List<DevByteVideo>>()
//    val playlist: LiveData<List<DevByteVideo>>
//        get() = _playlist

    private val _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    private val videosRepository = VideosRepository(getDatabase(application))

    val playlist = videosRepository.videos

    init {
//        refreshDataFromNetwork()
        refreshDataFromRepository()
    }

//    private fun refreshDataFromNetwork() {
//        viewModelScope.launch {
//            try {
//                val playlist = DevByteNetwork.debytes.getPlaylist()
//                _playlist.postValue(playlist.asDomainModel())
//                _eventNetworkError.value = false
//                _isNetworkErrorShown.value = false
//
//            } catch (networkError: IOException) {
//                delay(2000)
//                if (playlist.value.isNullOrEmpty())
//                    _eventNetworkError.value = true
//
//            }
//        }
//    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    fun refreshDataFromRepository() {
        viewModelScope.launch {
            try {
                videosRepository.refreshvedios()
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false
            } catch (networkError: IOException) {
                if (playlist.value.isNullOrEmpty())
                    _eventNetworkError.value = true
            }
        }
    }

}
