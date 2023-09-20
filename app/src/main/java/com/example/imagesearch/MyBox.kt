package com.example.imagesearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imagesearch.databinding.FragmentMyBoxBinding


class MyBox : Fragment() {

    lateinit var binding: FragmentMyBoxBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyBoxBinding.inflate(inflater, container, false)
        return binding.root
    }
}