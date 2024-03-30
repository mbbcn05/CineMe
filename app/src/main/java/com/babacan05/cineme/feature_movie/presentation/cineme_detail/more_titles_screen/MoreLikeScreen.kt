package com.babacan05.cineme.feature_movie.presentation.cineme_detail.more_titles_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail

@Composable
fun MoreLikeScreen(data:TitleDetail){
    Column {
        Text(text = "More Like Titles", color = Color.White)
       LazyRow() {
           items(data.moreTitles){
               MoreLikeItem(it)

           }

       }
    }

}