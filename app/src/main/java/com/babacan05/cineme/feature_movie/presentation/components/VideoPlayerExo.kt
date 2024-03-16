package com.babacan05.cineme.feature_movie.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.babacan05.cineme.feature_movie.presentation.utils.isVideoUrlValid
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun VideoPlayerExo(
   videoUrl:String="https://imdb-video.media-imdb.com/vi3215114777/1434659607842-pgv4ql-1649797798432.mp4?Expires=1710601798&Signature=RBxKLTbW6qjlc2QkO9y9gx4NUYFI98ar3hXmg7~e1kjFO-VBjdnj3kMVLG2TgClU76yPDiz57ymPbZni2MIaOe5PBDfdETJL8wD~k4fl0~OPMI7KOwRqZY0hNci3rPKrqzOil3jwhebwh7CojR8JrAcL2je-PHxFcEGia9c0iJzne-eUrXkSNMDaVur5jXAhGhvMRg0is9hfYr9~vx4~5AnnUoMlzfr6EGX4LA-cBmsJYzU5Bgsu5z3mhYCYAJ6dL4L0PX5UdLcu-18HWOPPwwDYL-8IfZoLZAZPF1MSPtUmsCWqMYrlUmvP9jmLML1KbgE8wmbzeYoi3gRUq7fhVA__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA"
) {


    val context = LocalContext.current
    val player = ExoPlayer.Builder(context).build().apply {
        setMediaItem(MediaItem.fromUri(videoUrl))

    }
    val playerView = PlayerView(context)
    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }

    playerView.player = player

    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = playWhenReady
        playerView.hideController()
    }
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        factory = {
            playerView
        })

}
@Composable
fun VideoPlayerExo2(
    videoUrl: String = "https://imdb-video.media-imdb.com/vi3215114777/1434659607842-pgv4ql-1649797798432.mp4?Expires=1710601798&Signature=RBxKLTbW6qjlc2QkO9y9gx4NUYFI98ar3hXmg7~e1kjFO-VBjdnj3kMVLG2TgClU76yPDiz57ymPbZni2MIaOe5PBDfdETJL8wD~k4fl0~OPMI7KOwRqZY0hNci3rPKrqzOil3jwhebwh7CojR8JrAcL2je-PHxFcEGia9c0iJzne-eUrXkSNMDaVur5jXAhGhvMRg0is9hfYr9~vx4~5AnnUoMlzfr6EGX4LA-cBmsJYzU5Bgsu5z3mhYCYAJ6dL4L0PX5UdLcu-18HWOPPwwDYL-8IfZoLZAZPF1MSPtUmsCWqMYrlUmvP9jmLML1KbgE8wmbzeYoi3gRUq7fhVA__&Key-Pair-Id=APKAIFLZBVQZ24NQH3KA",
    width: Dp = 300.dp, // Adjust width and height as desired
    height: Dp = 200.dp
) {
    val context = LocalContext.current
    val player = ExoPlayer.Builder(context).build().apply {
        setMediaItem(MediaItem.fromUri(videoUrl))

    }
    val playerView = PlayerView(context)
    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }

    playerView.player = player

    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = playWhenReady
        playerView.hideController()
    }

    AndroidView(
        modifier = Modifier
            .width(width)
            .height(height)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        factory = {
            playerView
        })
}
