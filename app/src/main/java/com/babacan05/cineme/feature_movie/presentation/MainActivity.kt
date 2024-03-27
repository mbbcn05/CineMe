package com.babacan05.cineme.feature_movie.presentation

import android.os.Build
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi


import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Surface


import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.babacan05.cineme.feature_movie.presentation.cineme_detail.DetailScreen
import com.babacan05.cineme.feature_movie.presentation.cineme_main.TitlesScreen
import com.babacan05.cineme.feature_movie.presentation.utils.Screen

import com.babacan05.cineme.ui.theme.CineMeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CineMeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.TitlesScreen.route
                    ) {
                        composable(route = Screen.TitlesScreen.route) {

                            TitlesScreen(onTitleClick = { titleId ->
                                  navController.navigate(Screen.TitleDetailScreen.route + "/${titleId}")
                                })

                        }
                        composable(Screen.TitleDetailScreen.route + "/{titleId}", arguments = listOf(
                            navArgument("titleId"){
                                type= NavType.StringType
                            }
                        )) { backStackEntry ->
                            val titleId = backStackEntry.arguments?.getString("titleId")
                           DetailScreen(titleId = titleId!!) { navController.popBackStack() }
                        }
                    }
                }


                        }


                    }
                }

            }


