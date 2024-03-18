package com.babacan05.cineme.feature_movie.data.model.remote.title_detail

data class PlaybackURL(
    val __typename: String,
    val displayName: DisplayNameX,
    val url: String,
    val videoDefinition: String,
    val videoMimeType: String
)