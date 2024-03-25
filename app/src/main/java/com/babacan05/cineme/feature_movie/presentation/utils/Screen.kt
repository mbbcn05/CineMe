package com.babacan05.cineme.feature_movie.presentation.utils

sealed class Screen(val route: String) {
    object TitlesScreen: Screen("cineme_screen")
    object TitleDetailScreen: Screen("cineme_detail_screen")

}
