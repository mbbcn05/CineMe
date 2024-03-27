package com.babacan05.cineme.feature_movie.presentation.cineme_main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.random.Random

enum class HeartState {
    Show,
    Hide
}
@Composable
fun HeartAnimation() {
    val stateList = remember { (1..7).map { false }.toMutableStateList() }
    LaunchedEffect(Unit) {
        repeat(stateList.size) { index ->
            stateList[index] = true
            delay(200)
        }
    }

    stateList.forEach { state ->
        if (state) {
            Box(modifier = Modifier.fillMaxSize()) {
                AnimatedHeart()
            }
        }
    }

}

@Composable
fun AnimatedHeart() {
    val offSetXDifference =  Random.nextInt(5, 15)
    var state by remember { mutableStateOf(HeartState.Show) }  // Initialize state

    val offsetYAnimation by animateDpAsState(
        targetValue = when (state) {
            HeartState.Show -> 30.dp * 5 +25.dp
            else -> 0.dp
        },
        animationSpec = tween(1000)
    )

    val offsetXAnimation by animateDpAsState(
        targetValue = when (state) {
            HeartState.Show -> (offSetXDifference+162).dp
            else ->(offSetXDifference+162).dp
        },
        animationSpec = tween(1000)
    )

    AnimatedVisibility(
        modifier = Modifier
            .offset(y = offsetYAnimation, x = offsetXAnimation),
        visible = state == HeartState.Show,
        enter = fadeIn(animationSpec = tween(durationMillis = 400)),
        exit = fadeOut(animationSpec = tween(durationMillis = 600)),
    ) {

        Icon(imageVector = Icons.Default.Favorite, contentDescription ="", tint =listOf(Color.Red,Color.Blue,Color.Red,Color.Cyan).random())
    }

    LaunchedEffect(key1 = state) {
        delay(5)
        state = HeartState.Hide
    }
}

