package com.babacan05.cineme.feature_movie.presentation.cineme_detail.actor_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.babacan05.cineme.feature_movie.domain.model.Actor

@Composable
fun ActorItem(actor: Actor){
    Card (shape = RoundedCornerShape(10.dp), modifier = Modifier
        .size(300.dp)
        .padding(horizontal = 20.dp)){
       Box {
           AsyncImage(
               model = ImageRequest.Builder(LocalContext.current)
                   .data(actor.imageUrl,)
                   .crossfade(true)
                   .build(),
               contentDescription = null,
               contentScale = ContentScale.Crop,
               modifier = Modifier.fillMaxSize()

           )
           Spacer(modifier = Modifier.height(5.dp))
         Row (modifier = Modifier.align(
             Alignment.BottomCenter).background(color = Color.LightGray.copy(alpha = 0.5f),
             RoundedCornerShape(7.dp)
         )){
             Text(maxLines = 1,color = Color.White,text = actor.name+"-"+actor.character, fontWeight = FontWeight.ExtraBold)
         }
         }


    }

}