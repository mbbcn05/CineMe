package com.babacan05.cineme.feature_movie.presentation.cineme_detail.actor_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail

@Composable
fun ActorsScreen(data: TitleDetail){
    val scrollState= rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {
        Text(text = data.releaseYear.toString()+data.genres,color= Color.White)
        Text(text = "Plot", color = Color.White)
        Text(text = data.plot, color = Color.White)


        Text(text = "Actors", color = Color.White)
        LazyRow() {
            items(data.cast){
                ActorItem(actor = it)

            }

        }
    }

}