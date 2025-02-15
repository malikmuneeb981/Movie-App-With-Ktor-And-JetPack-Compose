package com.example.cricket.scorrer.ktorprac.ApiService

import com.example.cricket.scorrer.ktorprac.models.MovieSearchResponse
import com.example.cricket.scorrer.ktorprac.models.PostsResponse
import com.example.cricket.scorrer.ktorprac.models.SelectedMovieResponse

interface ApiService {

//    suspend fun getPosts() : List<PostsResponse>

    suspend fun getSearchedMovies(query:String):MovieSearchResponse?

    suspend fun getSelectedMovieDetails(title:String):SelectedMovieResponse?

}