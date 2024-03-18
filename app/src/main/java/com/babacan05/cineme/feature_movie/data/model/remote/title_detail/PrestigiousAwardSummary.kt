package com.babacan05.cineme.feature_movie.data.model.remote.title_detail

data class PrestigiousAwardSummary(
    val __typename: String,
    val award: Award,
    val nominations: Int,
    val wins: Int
)