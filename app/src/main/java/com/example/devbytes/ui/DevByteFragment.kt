//package com.example.devbytes.ui
//
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import androidx.annotation.LayoutRes
//import androidx.databinding.DataBindingUtil
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.devbytes.R
//import com.example.devbytes.databinding.FragmentDevByteBinding
//import com.example.devbytes.domain.DevByteVideo
//import com.example.devbytes.viewmodels.DevByteViewModel
//import com.example.devbytes.viewmodels.DevByteViewModelFactory
//
//
//class DevByteFragment : Fragment() {
//
//    private val viewModel: DevByteViewModel by lazy {
//        val activity = requireNotNull(this.activity) {
//            "You can only access the viewModel after onActivityCreated()"
//        }
//        ViewModelProvider(
//            this,
//            DevByteViewModelFactory(activity.application)
//        ).get(DevByteViewModel::class.java)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding: FragmentDevByteBinding = DataBindingUtil.inflate(
//            inflater, R.layout.fragment_dev_byte,
//            container, false
//        )
//
//        binding.setLifecycleOwner(viewLifecycleOwner)
//
//        binding.viewModel = viewModel
//
//
//
//
//        return binding.root
//    }
//}
//
//
//
