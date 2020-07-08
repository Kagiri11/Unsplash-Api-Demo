package com.jscode.bipolarfactorydemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.jscode.bipolarfactorydemo.R
import com.jscode.bipolarfactorydemo.adapter.ImagesAdapter
import com.jscode.bipolarfactorydemo.databinding.FragmentCatsBinding

class CatsFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = CatsFragment()
    }

    private val viewModel: CatsViewModel by lazy {
        ViewModelProvider(this).get(CatsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentCatsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_cats, container, false)
        binding.lifecycleOwner=viewLifecycleOwner
        binding.model=viewModel
        val adapter = ImagesAdapter()
        binding.imageList.layoutManager=GridLayoutManager(requireContext(),2)
        binding.imageList.adapter=adapter
        viewModel.images.observe(viewLifecycleOwner, Observer {
            it?.let {images->
                adapter.submitList(images)
            }
        })
        return binding.root
    }
}