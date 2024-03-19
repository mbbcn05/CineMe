package com.babacan05.cineme.feature_movie.data.model.remote.title_detail

data class ProductionStatus(
    val __typename: String,
    val currentProductionStage: CurrentProductionStage,

    val restriction: Any
)