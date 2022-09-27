package com.example.moviesreview.moviesList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesreview.data.MoviesList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(repository: MoviesListRepository)
    : ViewModel() {

    private val _moviesList : MutableStateFlow<MoviesList?> = MutableStateFlow(null)
    val moviesList : StateFlow<MoviesList?> = _moviesList

    init {
        viewModelScope.launch {
            try{
                repository.getMoviesList()
                    .collect {
                        _moviesList.value = it
                    }
            } catch (exception: Exception) {
                Log.d("MoviesListViewModel", exception.message.toString())
            }
        }
    }
}