package com.babacan05.cineme.feature_movie.presentation.cineme_detail.review_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail

@Composable
fun ReviewScreen(data: TitleDetail){
    val scrollState = rememberScrollState()
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(16.dp)
        .verticalScroll(scrollState)){


        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)


        )
        Text(text = "Review", color = Color.White)
        Text(text =data.review, color = Color.White)

    }


}