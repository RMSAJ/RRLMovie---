package com.example.rrlmovie.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.rrlmovie.MovieAdapter
import com.example.rrlmovie.R
import com.example.rrlmovie.databinding.FragmentOverViewBinding
import com.example.rrlmovie.network.ResultsItem

class OverViewFragment: Fragment() {

private val viewModel: MovieVeiwModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    // Inflate the layout for this fragment
    val binding = FragmentOverViewBinding.inflate(inflater)
    binding.lifecycleOwner = this
    binding.viewModel = viewModel
//       binding.photosGrid.adapter = com.example.contriesflagapi.PhotoGridAdapter()
    binding.photosGrid.adapter = MovieAdapter()
    return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.gener_menu, menu)
        val actionButton = menu.findItem(R.id.option_12)
        val animmationButton = menu.findItem(R.id.option_16)
        val dramaButton = menu.findItem(R.id.option_18)
        val crimeButton = menu.findItem(R.id.option_80)
    }

    private fun setMovieBasedOnGener(menuItem: MenuItem?){
        if (menuItem == null) {return}
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_12 -> {
                viewModel.clearList()
                for (i in 0 until viewModel.photos.value?.size!!){
                    if (viewModel.photos.value!![i]!!.genreIds!!.contains(12)){
                            viewModel.addToList(i)
                    }
                }
                    reenterTransition
                return true
            }R.id.option_80 -> {
                viewModel.clearList()
                for (i in 0 until viewModel.photos.value?.size!!){
                    if (viewModel.photos.value!![i]!!.genreIds!!.contains(12)){
                            viewModel.addToList(i)
                    }
                }

                return true
            }R.id.option_18 -> {
                viewModel.clearList()
                for (i in 0 until viewModel.photos.value?.size!!){
                    if (viewModel.photos.value!![i]!!.genreIds!!.contains(12)){
                            viewModel.addToList(i)
                    }
                }

                return true
            }R.id.option_16 -> {
                viewModel.clearList()
                for (i in 0 until viewModel.photos.value?.size!!){
                    if (viewModel.photos.value!![i]!!.genreIds!!.contains(12)){
                            viewModel.addToList(i)
                    }
                }

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}