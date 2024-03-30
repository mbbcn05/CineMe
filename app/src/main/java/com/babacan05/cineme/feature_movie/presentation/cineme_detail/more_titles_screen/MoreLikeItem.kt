package com.babacan05.cineme.feature_movie.presentation.cineme_detail.more_titles_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.babacan05.cineme.feature_movie.domain.model.MoreLikeTitle

@Composable
fun MoreLikeItem(moreLikeTitle: MoreLikeTitle) {
    Card {
        Column {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(moreLikeTitle.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
            )
            Text(text =moreLikeTitle.name, color = Color.White)
        }
    }


}