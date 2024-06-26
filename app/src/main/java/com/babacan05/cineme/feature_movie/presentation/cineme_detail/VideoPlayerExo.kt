package com.babacan05.cineme.feature_movie.presentation.cineme_detail

import android.graphics.Insets
import android.view.View
import android.view.WindowInsets
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player.Listener
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView


@OptIn(UnstableApi::class) @Composable
fun VideoPlayerExo(

    height: Dp = 200.dp, viewModel: DetailViewModel, videoUrls: List<String>, isLandscape: Boolean
) {

    var videoNumber by remember {
        mutableIntStateOf(0)
    }

    val context = LocalContext.current
    val mediaSource = remember(videoUrls[videoNumber]) {
   MediaItem.fromUri(videoUrls[videoNumber])

    }

   val player=ExoPlayer.Builder(context).build().apply {
       setMediaItem(mediaSource)
       addListener(object : Listener {
           override fun onPlayerError(error: PlaybackException) {
              videoNumber++


           }
       })
   }

    val playerView = PlayerView(context)
    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }

    playerView.player = player

    DisposableEffect(Unit) {
        player.prepare()
        player.playWhenReady = playWhenReady
        playerView.hideController()
        player.seekTo(viewModel.getVideoState().currentPosition)
        onDispose {
           viewModel.setVideoState(VideoState(videoUrl =videoUrls[videoNumber], currentPosition = player.currentPosition))
            player.release()

        }
    }

    AndroidView(
        modifier = if(isLandscape){Modifier.fillMaxSize()}else{Modifier
            .fillMaxWidth()
            //.width(width)
            .height(height)
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(20.dp))},
        factory = {



            playerView.apply {if (isLandscape){
                this.setOnApplyWindowInsetsListener { _, insets ->
                    insets.let {
                        it.consumeSystemWindowInsets()
                        WindowInsets.Builder().setInsets(
                            WindowInsets.Type.systemBars(),
                            Insets.of(0, 0, 0, 0)
                        ).build()
                    }
                }
                this.systemUiVisibility = (
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                or View.SYSTEM_UI_FLAG_FULLSCREEN
                                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        )

            }}

        })
}
