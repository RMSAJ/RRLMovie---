package com.example.rrlmovie.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.rrlmovie.R
import com.example.rrlmovie.databinding.FragmentOverViewDetailBinding

class OverViewDetailFragment : Fragment() {

    var binding : FragmentOverViewDetailBinding? = null
    private val viewModel: MovieVeiwModel by activityViewModels()

    private var param: Int = 0 // before start
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param = it.getInt("id")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentOverViewDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.movieVeiwModel = viewModel
        binding?.overViewDetailFragment = this@OverViewDetailFragment

        viewModel.getMovieInfo(param)
    }
}