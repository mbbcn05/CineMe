package com.babacan05.cineme.feature_movie.presentation.utils

import java.net.HttpURLConnection
import java.net.URL

fun isVideoUrlValid(videoUrl: String): Boolean {
    try {
        val url = URL(videoUrl)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "HEAD"
        connection.connect()
        val responseCode = connection.responseCode
        return (responseCode == HttpURLConnection.HTTP_OK).apply { if (this)         println("video başarılı")
        }
    } catch (e: Exception) {
        println("Hata var")
        return false
    }
}