package com.kproject.cleidesigns.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kproject.cleidesigns.presentation.screens.home.HomeScreen

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                onNavigateToDesignViewScreen = { design, designType ->
                    navController.navigate(
                        Screen.DesignViewScreen.createRoute(
                            design = design,
                            designType = designType
                        )
                    ) {
                        launchSingleTop = true
                    }
                }
            )
        }

        /**
         * DesignViewScreen
         */
        composable(
            route = Screen.DesignViewScreen.route,
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            }
        ) { backStackEntry ->

        }
    }
}