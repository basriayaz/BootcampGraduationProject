package com.example.foodapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.foodapp.databinding.FragmentSepetBinding
import com.example.foodapp.ui.viewmodel.AnasayfaViewModel
import com.example.foodapp.ui.viewmodel.SepetViewModel


class SepetFragment : Fragment() {
    private lateinit var tasarim:FragmentSepetBinding
    private lateinit var viewModel: SepetViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentSepetBinding.inflate(inflater, container, false)
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : SepetViewModel by viewModels()
        viewModel = tempViewModel
    }

}