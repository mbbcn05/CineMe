package com.babacan05.cineme.feature_movie.presentation.cineme_main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.babacan05.cineme.feature_movie.domain.model.Title

@Composable
fun TitleItem(
    title: Title,
    onTitleClick: (String) -> Unit,
    setFavourate: (Boolean) -> Unit,
    state: State<TitlesState>
){

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(16.dp)
            .size(200.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(title.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
                .clickable { onTitleClick(title.id) }

        )
        IconButton(onClick = {
           setFavourate(title.id !in state.value.favouredIdList)

        },modifier= Modifier
            .align(Alignment.BottomEnd)
            .background(
                Color.Black.copy(alpha = 0.0f)
            )
            .size(30.dp),) {
            Icon(imageVector =
if (title.id in state.value.favouredIdList){
    Icons.Filled.Favorite
}else {
    Icons.Default.Add
}
           ,

                contentDescription = "", tint = Color.Red)
           }
    }
}