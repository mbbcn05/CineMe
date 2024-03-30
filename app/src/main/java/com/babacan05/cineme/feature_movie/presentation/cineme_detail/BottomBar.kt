package com.babacan05.cineme.feature_movie.presentation.cineme_detail

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomBarNavigation() {
    val navController = rememberNavController()
    val items = listOf(
        BottomBarItem("Home", Icons.Default.Home, "home"),
        BottomBarItem("Explore", Icons.Default.Search, "explore"),
        BottomBarItem("Notifications", Icons.Default.Notifications, "notifications"),
        BottomBarItem("Profile", Icons.Default.Person, "profile")
    )
    val currentRoute = currentRoute(navController)

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White,
                elevation = 8.dp
            ) {
                items.forEach { item ->
                    val isSelected = currentRoute == item.route
                    val backgroundColor by animateColorAsState(
                        if (isSelected)Color.Black.copy(alpha = 0.3f) else Color.Transparent
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(imageVector = item.icon, contentDescription ="" ,Modifier.size(24.dp))
                        },
                        label = { Text(text = item.title) },
                        selected = isSelected,
                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        modifier = Modifier.background(backgroundColor)
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Home Screen", style = MaterialTheme.typography.bodyLarge)
                }
            }
            composable("explore") {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Explore Screen", style = MaterialTheme.typography.bodyLarge)
                }
            }
            composable("notifications") {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Notifications Screen", style = MaterialTheme.typography.bodyLarge)
                }
            }
            composable("profile") {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Profile Screen", style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}

data class BottomBarItem(val title: String, val icon: ImageVector, val route: String)

@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}