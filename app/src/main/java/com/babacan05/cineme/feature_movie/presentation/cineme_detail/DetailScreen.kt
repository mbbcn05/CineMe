package com.babacan05.cineme.feature_movie.presentation.cineme_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.menu_screen.DetailScreenMenu

@Composable
 fun DetailScreen (viewModel: DetailViewModel = hiltViewModel(), titleId:String, popUp: () -> Boolean){
val state = viewModel.detailState.collectAsState().value

    var isDetailLoaded by remember { mutableStateOf(false) }

    LaunchedEffect(isDetailLoaded) {
        if (!isDetailLoaded) {
            viewModel.loadTitleDetail(titleId)
            isDetailLoaded = true
        }
    }


    Column {
 when(state.detailResult){
     is DataResult.Error -> LoadingAnimation(isLoading = true)
     is DataResult.Success -> DetailScreenMenu((state.detailResult).data, viewModel =viewModel)

 }

}

}

