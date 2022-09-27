package com.example.moviesreview.data

import com.google.gson.annotations.SerializedName


data class MoviesList (
    @SerializedName("page") var page : Int? = null,
    @SerializedName("results") var movies : ArrayList<MovieItem> = arrayListOf(),
    @SerializedName("total_results") var totalResults : Int? = null,
    @SerializedName("total_pages") var totalPages   : Int? = null
)