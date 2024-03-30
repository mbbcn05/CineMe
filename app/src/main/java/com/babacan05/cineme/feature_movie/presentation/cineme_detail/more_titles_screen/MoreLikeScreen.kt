package com.babacan05.cineme.feature_movie.presentation.cineme_detail.more_titles_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
fun MoreLikeScreen(data:TitleDetail){
    Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()){
        Text( fontWeight = FontWeight.Bold,text = "More Like Titles", color = Color(0xFFBC6C25), fontSize = 20.sp, modifier = Modifier.padding(vertical = 5.dp))
       LazyRow() {
           items(data.moreTitles){
               MoreLikeItem(it)

           }

       }
    }

}