package com.example.rrlmovie.overview


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rrlmovie.network.MovieApi
import com.example.rrlmovie.network.ResultsItem
import kotlinx.coroutines.launch
import java.lang.Exception


enum class MoviesApiStatus { LOADING, ERROR, DONE }

class MovieVeiwModel : ViewModel() {

    private val _status = MutableLiveData<MoviesApiStatus>()
    val status: LiveData<MoviesApiStatus> = _status

    val movieTitle = MutableLiveData<String>()

    val movieDetail = MutableLiveData<String>()

    val moviePoster = MutableLiveData<String>()
     var movieGener:MutableList<List<Int>?> = mutableListOf()

    private val _photos = MutableLiveData<List<ResultsItem?>?>()
    val photos: LiveData<List<ResultsItem?>?> = _photos

    init {
        getMovieList()
    }
    private fun getMovieList(i: Int = 0) {
        viewModelScope.launch {
            _status.value = MoviesApiStatus.LOADING
            try {
                val listResult = MovieApi.retrofitService.getMovieList().results
                _photos.value = listResult
                _photos.value?.forEach {  movieGener.add(it?.genreIds) }
                _status.value = MoviesApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MoviesApiStatus.ERROR
                _photos.value = listOf()

            }
        }
    }

     fun addToList(i : Int){
         viewModelScope.launch {
         val listResult = MovieApi.retrofitService.getMovieList().results
        _photos.value?.plus(listResult?.get(i))}
    }

    fun clearList(){
        _photos.value = listOf()
    }

     fun getMovieInfo(index: Int) {
        val item = _photos.value?.get(index)
        moviePoster.value = item?.posterPath
        movieTitle.value = item?.originalTitle
        movieDetail.value = item?.overview
    }
}