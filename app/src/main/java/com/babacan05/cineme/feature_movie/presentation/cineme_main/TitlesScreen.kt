package com.babacan05.cineme.feature_movie.presentation.cineme_main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


@Composable
fun TitlesScreen(
    viewModel: TitlesViewModel = hiltViewModel(), onTitleClick: (String)->Unit


) {
  val titlesState=viewModel.titlesState.collectAsState()
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        var searchedText by rememberSaveable {
        mutableStateOf("")
    }

        Row {
    TextField(value = searchedText, onValueChange ={ searchedText=it} )
            Spacer(modifier = Modifier.width(5.dp))
            Icon(imageVector = Icons.Default.Search, contentDescription ="search", modifier = Modifier.clickable {

                viewModel.apply { viewModelScope.launch { onEvent(TitlesEvent.SearchTitle(searchedText)) } } } )
}

        Spacer(modifier = Modifier.height(16.dp))


        LazyRow {
            items(titlesState.value.listSearchedTitles) { title ->
                TitleItem(
                    title = title,
                    onTitleClick =onTitleClick,
                    { isFavoured -> viewModel.onEvent(TitlesEvent.SetFavoured(title.id, isFavoured)) },
                    state =titlesState
                )
            }}

        LazyRow {
            items(titlesState.value.listTop100Titles) { title ->
              TitleItem(
                  title = title, onTitleClick =onTitleClick,
                  setFavourate ={ isFavoured->viewModel.onEvent(TitlesEvent.SetFavoured(title.id,isFavoured))},
                  state =titlesState
              )
        }
    }
        LazyRow {
            items(titlesState.value.listFavouredTitles) { title ->
                TitleItem(
                    title = title,
                    onTitleClick =onTitleClick,
                    { isFavoured -> viewModel.onEvent(TitlesEvent.SetFavoured(title.id, isFavoured)) },
                    state =titlesState
                )
            }}
}}