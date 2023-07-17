package com.example.devbytes.viewmodels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.devbytes.R
import com.example.devbytes.databinding.DevbyteItemBinding
import com.example.devbytes.domain.DevByteVideo

class DevByteAdapter( val videoClick: VideoClick) :
    RecyclerView.Adapter<DevByteAdapter.DevByteViewHolder>() {

    var vedios: List<DevByteVideo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevByteViewHolder {
        val withDataBinding: DevbyteItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            DevByteViewHolder.LAYOUT,
            parent,
            false)
        return DevByteViewHolder(withDataBinding)
    }

    override fun getItemCount(): Int {
        return vedios.size
    }

    override fun onBindViewHolder(holder: DevByteViewHolder, position: Int) {
        var item = vedios[position]
        holder.bind(item, videoClick)
    }

    class DevByteViewHolder(val viewDataBinding: DevbyteItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.devbyte_item
        }

        fun bind(devByteVideo: DevByteVideo, videoClick: VideoClick) {
            viewDataBinding.video = devByteVideo
            viewDataBinding.videoCallback = videoClick

        }
    }
}

class VideoClick(val clickListener: (devByteVideo: DevByteVideo) -> Unit) {
    fun onClick(devByteVideo: DevByteVideo) = clickListener(devByteVideo)
}