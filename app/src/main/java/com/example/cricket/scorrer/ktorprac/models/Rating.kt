package com.example.cricket.scorrer.ktorprac.models

import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    val Source: String,
    val Value: String
)