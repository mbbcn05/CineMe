package com.babacan05.cineme.feature_movie.data.model.remote.title_detail

data class Director(
    val __typename: String,

    val credits: List<Credit>,
    val totalCredits: Int
)