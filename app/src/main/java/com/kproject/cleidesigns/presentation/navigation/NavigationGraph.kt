package com.kproject.cleidesigns.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kproject.cleidesigns.presentation.commom.extensions.fromJson
import com.kproject.cleidesigns.presentation.screens.designview.DesignViewScreen
import com.kproject.cleidesigns.presentation.screens.home.HomeScreen
import com.kproject.cleidesigns.presentation.screens.model.Design
import com.kproject.cleidesigns.presentation.screens.model.DesignType

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
            arguments = listOf(
                navArgument(name = ArgDesign) {
                    type = NavType.StringType
                },
                navArgument(name = ArgDesignType) {
                    type = NavType.StringType
                },
            ),
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
            backStackEntry.arguments?.let { bundle ->
                val design = remember {
                    bundle.getString(ArgDesign)!!.fromJson(Design::class.java)
                }
                val designType = remember {
                    bundle.getString(ArgDesignType)!!.fromJson(DesignType::class.java)
                }
                DesignViewScreen(
                    design = design,
                    designType = designType,
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}