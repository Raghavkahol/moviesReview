package com.example.moviesreview.moviesList


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moviesreview.BuildConfig
import com.example.moviesreview.data.MovieItem
import com.example.moviesreview.network.MoviesApiService
import retrofit2.HttpException
import java.io.IOException

class MoviesPagingSource(private val moviesApiService: MoviesApiService) :
    PagingSource<Int, MovieItem>() {

    override val keyReuseSupported: Boolean = true

    override fun getRefreshKey(state: PagingState<Int, MovieItem>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItem> {
        val position = params.key ?: 1
       return try {
           val moviesList = moviesApiService.getMoviesList(BuildConfig.API_KEY, position)
           val listing = moviesList.movies

           LoadResult.Page(
               listing,
               prevKey =  if (position == 1) null else position - 1,
               nextKey =  position + 1
           )
       } catch(exception: IOException) {
           return LoadResult.Error(exception)
       } catch (exception: HttpException) {
           return LoadResult.Error(exception)
       }
    }

}