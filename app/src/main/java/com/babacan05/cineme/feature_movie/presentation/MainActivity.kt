package com.babacan05.cineme.feature_movie.presentation

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideIn

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import com.babacan05.cineme.feature_movie.data.repository.responseRetrofit

import com.babacan05.cineme.feature_movie.presentation.components.VideoPlayerExo
import com.babacan05.cineme.feature_movie.presentation.components.VideoPlayerExo2
import com.babacan05.cineme.feature_movie.presentation.utils.isVideoUrlValid
import com.babacan05.cineme.feature_movie.presentation.utils.isVideoUrlValid2
import com.babacan05.cineme.ui.theme.CineMeTheme
import kotlinx.coroutines.delay

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


LaunchedEffect(key1 = true) {
    responseRetrofit()
}
                        //   VideoPlayerExo2()


                   }
                }
            }
        }
    }
}







