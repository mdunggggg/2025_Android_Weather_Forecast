package com.example.android_template.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    
    protected var _binding: VB? = null
    protected val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater, container)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListeners()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    abstract fun setupViews()
    abstract fun setupListeners()
} 