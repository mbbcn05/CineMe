package com.babacan05.cineme.feature_movie.presentation.cineme_detail

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen (viewModel: DetailViewModel = hiltViewModel(), titleId:String, popUp: () -> Boolean){

Button(onClick = { popUp() }) {
    Text(text = titleId)
}

}