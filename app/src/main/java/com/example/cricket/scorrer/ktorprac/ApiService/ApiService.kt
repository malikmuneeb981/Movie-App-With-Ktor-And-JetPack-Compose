package com.example.cricket.scorrer.ktorprac.ApiService

import com.example.cricket.scorrer.ktorprac.models.MovieSearchResponse
import com.example.cricket.scorrer.ktorprac.models.SelectedMovieResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url


class ApiService (val client:HttpClient) {


    val BaseUrl = "https://www.omdbapi.com/"
    val ApiKey = "f514b556"

    suspend fun getSearchedMovies(query:String): MovieSearchResponse? {
       return try {
           client.get {
               url(BaseUrl)
               parameter("s",query)
               parameter("apikey",ApiKey)
           }.body()
       } catch (e:Exception){
           return null
       }
    }

    suspend fun getSelectedMovieDetails(title: String): SelectedMovieResponse? {
        return try {
            client.get{
                url(BaseUrl)
                parameter("t",title)
                parameter("apikey",ApiKey)
            }.body()
        }catch (e:Exception){
            return null
        }
    }
}