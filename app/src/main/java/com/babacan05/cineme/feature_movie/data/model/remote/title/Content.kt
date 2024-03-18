package com.babacan05.cineme.feature_movie.data.model.remote.title

data class Content(
    val id: String,
    val l: String,
    val q: String,
    val rank: Int,
    val s: String,
    val vt: Int,
    val y: Int,
    val yr: String?,
    val v: List<Video>?,
    val i: Image
)