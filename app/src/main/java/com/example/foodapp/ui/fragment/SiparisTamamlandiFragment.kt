package com.example.foodapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentSiparisTamamlandiBinding

class SiparisTamamlandiFragment : Fragment() {
    private lateinit var tasarim:FragmentSiparisTamamlandiBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentSiparisTamamlandiBinding.inflate(inflater, container, false)
        return tasarim.root
    }

}