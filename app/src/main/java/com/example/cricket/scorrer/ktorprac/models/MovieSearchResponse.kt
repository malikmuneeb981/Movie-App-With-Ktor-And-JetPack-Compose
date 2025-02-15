package com.example.cricket.scorrer.ktorprac.models

import kotlinx.serialization.Serializable

@Serializable
data class MovieSearchResponse(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)