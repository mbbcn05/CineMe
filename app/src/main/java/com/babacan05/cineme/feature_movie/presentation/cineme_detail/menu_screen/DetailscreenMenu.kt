package com.babacan05.cineme.feature_movie.presentation.cineme_detail.menu_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.DetailHeartAnimation
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.DetailState
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.DetailViewModel
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.Menustate
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.Menustate.*
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.VideoPlayerExo
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.actor_screen.ActorsScreen
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.more_titles_screen.MoreLikeScreen
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.review_screen.ReviewScreen

@Composable
fun DetailScreenMenu(data: TitleDetail, viewModel: DetailViewModel, popUp: () -> Boolean) {
    val scrollState = rememberScrollState()
    val detailState = viewModel.detailState.collectAsState()

    var heartAnimation by remember {
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp)
                .align(Alignment.TopCenter)

        ) {
            VideoPlayerExo(videoUrl = data.videoUrl, viewModel = viewModel)


            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = data.name.uppercase(),
                    color =  Color(0xFFCCD5AE),
                    fontWeight = FontWeight.Bold
                )
                if (data.rating > 0) {
                    Spacer(modifier = Modifier.width(15.dp))
                    androidx.compose.material.Text(
                        text = data.rating.toString(), color = Color.White, modifier = Modifier
                            .size(20.dp)
                            .background(
                                Color.Blue.copy(alpha = 0.4f),
                                RoundedCornerShape(10.dp)
                            )
                    )
                }
                IconButton(
                    onClick = {

                        viewModel.updateFavouredTitle(
                            data.id,
                            (data.id !in detailState.value.favouredIdList)
                        )
                        heartAnimation = (data.id !in detailState.value.favouredIdList)

                    },
                    modifier = Modifier
                        .weight(1f)
                        .background(
                            Color.Black.copy(alpha = 0.0f)
                        )
                        .size(30.dp),
                ) {
                    Icon(
                        modifier = Modifier.size(180.dp), imageVector =
                        if (data.id in detailState.value.favouredIdList) {
                            Icons.Filled.Favorite
                        } else {
                            Icons.Outlined.FavoriteBorder
                        },

                        contentDescription = "", tint = Color.Red
                    )
                }

            }
            Box(modifier = Modifier.height(500.dp)) {
                when (detailState.value.menustate) {
                    ACTORS -> ActorsScreen(data = data)
                    REVIEW -> ReviewScreen(data = data)
                    MORELIKES -> MoreLikeScreen(data = data)
                }
            }


        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 80.dp)
        ) {

            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .align(Alignment.BottomCenter)
                    .height(60.dp)
                    .background(
                        Color(0xFFCCD5AE),
                        RoundedCornerShape(20.dp)
                    )
            ) {

              IconButton(onClick = { viewModel.setMenuState(ACTORS) }) {
                  Icon(imageVector = Icons.Outlined.Home, contentDescription ="" , tint = Color(0xFFBC6C25)
                  )
              }
                IconButton(onClick = { viewModel.setMenuState(REVIEW) }) {
                    Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription =""  , tint = Color(0xFFBC6C25))

                }
                IconButton(onClick = { viewModel.setMenuState(MORELIKES) }) {
                    Icon(imageVector = Icons.Outlined.MoreVert, contentDescription ="" , tint =Color(0xFFBC6C25) )
                }





            }
          MiniBox(modifier = Modifier.align(Alignment.BottomStart), detailState = detailState, menustate = ACTORS )
            MiniBox(modifier = Modifier.align(Alignment.BottomCenter), detailState = detailState, menustate = REVIEW )
            MiniBox(modifier = Modifier.align(Alignment.BottomEnd), detailState = detailState, menustate = MORELIKES )


        }
IconButton(onClick ={popUp()}) {
    Icon(imageVector = Icons.AutoMirrored.Outlined.ArrowBack, contentDescription ="", tint = Color.Green )
}
        if (heartAnimation) {
            DetailHeartAnimation()
        }

    }
}

    @Composable
    fun MiniBox(modifier:Modifier,detailState: State<DetailState>,menustate: Menustate){

        val size by animateDpAsState(
            targetValue = if (detailState.value.menustate==menustate) 85.dp else 70.dp,
            animationSpec = tween(200)
        )
        Box(contentAlignment = Alignment.Center,modifier= modifier
            .padding(
                horizontal = when (menustate) {
                    ACTORS -> 20.dp
                    REVIEW -> 0.dp
                    MORELIKES -> 20.dp
                }
            )
            .background(
                Color(0xFFCCD5AE).copy(
                    alpha = if (size > 70.dp) 1f else 0f

                ), CircleShape
            )
            .size(size)){
AnimatedVisibility(visible = (menustate==detailState.value.menustate)) {
  when(menustate){
      ACTORS ->                   Icon(imageVector = Icons.Outlined.Home, contentDescription ="", tint =Color(0xFF4361EE)
      )

      REVIEW ->  Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription ="", tint = Color(0xFF4361EE)
      )
      MORELIKES ->  Icon(imageVector = Icons.Outlined.MoreVert, contentDescription ="", tint =Color(0xFF4361EE)
      )
  }
}

        }

    }