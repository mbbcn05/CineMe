package com.babacan05.cineme.feature_movie.data.model.remote.title_detail

data class PrincipalCredit(
    val __typename: String,
    val category: CategoryXXX,
    val credits: List<Credit>,
    val totalCredits: Int
)