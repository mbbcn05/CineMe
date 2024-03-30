package com.babacan05.cineme.feature_movie.presentation.cineme_main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitlesScreen(
    viewModel: TitlesViewModel = hiltViewModel(), onTitleClick: (String)->Unit
) {


    val customTextFieldColors = TextFieldDefaults.textFieldColors(
        focusedTextColor = Color.White,
        unfocusedTextColor = Color.White.copy(alpha = 0.7f),
        cursorColor = Color.Black,
        focusedIndicatorColor = Color.Blue,
        unfocusedIndicatorColor = Color.Black,
        disabledIndicatorColor = Color.Transparent,


    )
  val titlesState=viewModel.titlesState.collectAsState()
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        var searchedText by rememberSaveable {
        mutableStateOf("")
    }

        Row {
            val textFieldVisible by remember {
                mutableStateOf(true)
            }
            AnimatedVisibility(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(horizontal = 30.dp, vertical = 0.dp),
                visible = textFieldVisible
            ) {
                OutlinedTextField(
                    shape = RoundedCornerShape(20.dp),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(onSearch = {
                        viewModel.apply {
                            viewModelScope.launch {
                                onEvent(
                                    TitlesEvent.SearchTitle(searchedText)
                                )
                            }
                        }
                    }),
                    value = searchedText,
                    onValueChange = {
                        searchedText = it
                    },
                    singleLine = true,
                    label = { Text("Search in All Movies", color =  Color(0xFFBC6C25)) },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle =TextStyle(color = Color.White, textDecoration = TextDecoration.None) // Yazı rengini beyaz olarak ayarla
                )
            }
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
        Spacer(modifier = Modifier.height(10.dp))
Text( fontWeight = FontWeight.Bold,text = "TOP 100 MOVİES", color = Color(0xFFBC6C25))
        LazyRow {
            items(titlesState.value.listTop100Titles) { title ->
              TitleItem(
                  title = title, onTitleClick =onTitleClick,
                  setFavourate ={ isFavoured->viewModel.onEvent(TitlesEvent.SetFavoured(title.id,isFavoured))},
                  state =titlesState
              )
        }
    }
        Spacer(modifier = Modifier.height(10.dp))
        Text( fontWeight = FontWeight.Bold,text = "YOUR FAVOURİTE MOVİES", color =  Color(0xFFBC6C25))
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
