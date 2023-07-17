package com.example.devbytes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.devbytes.database.VideosDatabase
import com.example.devbytes.database.asDomainModel
import com.example.devbytes.domain.DevByteVideo
import com.example.devbytes.network.DevByteNetwork
import com.example.devbytes.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class VideosRepository(private val database: VideosDatabase) {

    val videos: LiveData<List<DevByteVideo>> = Transformations.map(database.videoDao.getVideos()) {
        it.asDomainModel()
    }

    suspend fun refreshvedios() {
        withContext(Dispatchers.IO) {
            Timber.d("refresh videos is called");
            val playlist = DevByteNetwork.debytes.getPlaylist()
            database.videoDao.insertAll(playlist.asDatabaseModel())
        }
    }


}