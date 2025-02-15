package com.example.cricket.scorrer.ktorprac.models

import kotlinx.serialization.Serializable

@Serializable
data class PostsResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)