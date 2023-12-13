package com.kproject.cleidesigns.presentation.navigation

import com.kproject.cleidesigns.presentation.commom.extensions.toJson
import com.kproject.cleidesigns.presentation.screens.model.Design
import com.kproject.cleidesigns.presentation.screens.model.DesignType

const val ArgDesign = "design"
const val ArgDesignType = "design_type"

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home_screen")
    data object DesignViewScreen : Screen(
        "design_view_screen/{$ArgDesign}/{$ArgDesignType}"
    ) {
        fun createRoute(
            design: Design,
            designType: DesignType
        ): String {
            return "design_view_screen/${design.toJson()}/${designType.toJson()}"
        }
    }
}