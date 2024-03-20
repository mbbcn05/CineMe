package com.babacan05.cineme.feature_movie.presentation

import android.os.Build
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf

import androidx.compose.runtime.setValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment


import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.repository.CinemeRepository
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.presentation.components.VideoPlayerExo2

import com.babacan05.cineme.ui.theme.CineMeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var cinemeRepository: CinemeRepository

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CineMeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    var detailFlow by remember {
                        mutableStateOf<DataResult<TitleDetail>>(DataResult.Error(message="Yükleniyor"))
                    }



                    Column(modifier = Modifier.padding(16.dp)) {


                        Spacer(modifier = Modifier.height(16.dp))

                        when(detailFlow){
                            is DataResult.Error ->  Text(text = (detailFlow as DataResult.Error).message)
                            is DataResult.Success -> VideoPlayerExo2(videoUrl = (detailFlow as DataResult.Success<TitleDetail>).data.videoUrl)
                        }


                        LaunchedEffect(true) {
                            cinemeRepository.getTitleDetail("tt0926084").collect { result ->
                                when (result) {
                                    is DataResult.Success -> {
                                       println(result.data.videoUrl)
                                       detailFlow=result
                                        // titleDetail ile yapılacak işlemler
                                    }
                                    is DataResult.Error -> {
                                        // Hata durumu

                                        // Hata ile yapılacak işlemler
                                    }
                                }
                            }


                        }


                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MovieItem(movie: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(movie)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = movie,

            )
        }
    }
}