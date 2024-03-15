package com.babacan05.cineme.feature_movie.presentation

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.ui.Modifier

import com.babacan05.cineme.feature_movie.presentation.components.VideoPlayerExo
import com.babacan05.cineme.feature_movie.presentation.utils.isVideoUrlValid
import com.babacan05.cineme.ui.theme.CineMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CineMeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Column {
if(isVideoUrlValid("https://imdb-video.media-imdb.com/vi3215114777/1434659607842-pgv4ql-1649797798432.mp4?Expires=1710601798&Signature=RBxKLTbW6qjlc2QkO9y9gx4NUYFI98ar3hXmg7~e1kjFO-VBjdnj3kMVLG2TgClU76yPDiz57ymPbZni2MIaOe5PBDfdETJL8wD~k4fl0~OPMI7KOwRqZY0hNci3rPKrqzOil3jwhebwh7CojR8JrAcL2je-PHxFcEGia9c0iJzne-eUrXkSNMDaVur5jXAhGhvMRg0is9hfYr9~vx4~5AnnUoMlzfr6EGX4LA-cBmsJYzU5Bgsu5z3mhYCYAJ6dL4L0PX5UdLcu-18HWOPPwwDYL-8IfZoLZAZPF1MSPtUmsCWqMYrlUmvP9jmLML1KbgE8wmbzeYoi3gRUq7fhVA__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA"))
VideoPlayerExo()
                   }
                }
            }
        }
    }
}







