package com.babacan05.cineme.feature_movie.presentation.cineme_detail.actor_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail

@Composable
fun ActorsScreen(data: TitleDetail){
    val scrollState= rememberScrollState()
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {
        Text(text = data.releaseYear.toString()+data.genres,color= Color.White)
        Text( fontWeight = FontWeight.Bold,text = "Plot", color =  Color(0xFFBC6C25), modifier = Modifier.align(Alignment.Start), fontSize = 20.sp)
        Text( fontWeight = FontWeight.Bold,text = data.plot, color = Color.White)


        Text(text = "Actors", color =  Color(0xFFBC6C25), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        LazyRow() {
            items(data.cast){
                ActorItem(actor = it)

            }

        }
        Spacer(modifier = Modifier.height(50.dp))

    }

}