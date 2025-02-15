package com.example.cricket.scorrer.ktorprac.models

import kotlinx.serialization.Serializable

@Serializable
data class Search(
    val Poster: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbID: String
)