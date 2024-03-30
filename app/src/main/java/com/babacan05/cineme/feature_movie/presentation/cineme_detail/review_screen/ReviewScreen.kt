package com.babacan05.cineme.feature_movie.presentation.cineme_detail.review_screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail

@Composable
fun ReviewScreen(data: TitleDetail){
    val scrollState = rememberScrollState()
    Box (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(horizontal = 16.dp)

             ){



        Column (modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

            .verticalScroll(scrollState)){
            Spacer(modifier = Modifier.height(300.dp- scrollState.value.dp/5))
            Text( fontWeight = FontWeight.Bold,text = "Review", color = Color(0xFFBC6C25), modifier = Modifier.align(Alignment.Start), fontSize = 20.sp)
            Text(text =data.review, color = Color.White, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(50.dp))
        }
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(data.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp - scrollState.value.dp / 2)
                .clip(CircleShape)
                .align(Alignment.TopCenter)


        )
        AnimatedVisibility(visible = scrollState.value>550) {

            Text(text = "Review", color = Color(0xFFBC6C25), modifier = Modifier.background(Color.Black,
                RoundedCornerShape(5.dp)
            ).align(Alignment.TopStart), fontSize = 20.sp, fontWeight = FontWeight.Bold)

        }


    }


}