package com.kproject.cleidesigns.presentation.screens.designview

import androidx.compose.runtime.Composable
import com.kproject.cleidesigns.presentation.screens.model.Design
import com.kproject.cleidesigns.presentation.screens.model.DesignType

@Composable
fun DesignViewScreen(
    design: Design,
    designType: DesignType,
    onNavigateBack: () -> Unit
) {
    if (designType == DesignType.Inspiration) {
        DesignInspirationScreen(
            design = design,
            onNavigateBack = onNavigateBack
        )
    }
}
