package com.kproject.cleidesigns.presentation.screens.designview

import androidx.compose.runtime.Composable
import com.kproject.cleidesigns.feature.design1.Design1
import com.kproject.cleidesigns.feature.design2.Design2
import com.kproject.cleidesigns.feature.design3.Design3
import com.kproject.cleidesigns.feature.design4.Design4
import com.kproject.cleidesigns.presentation.screens.model.Design
import com.kproject.cleidesigns.presentation.screens.model.DesignType

@Composable
fun DesignViewScreen(
    design: Design,
    designType: DesignType,
    onNavigateBack: () -> Unit
) {
    when (designType) {
        DesignType.XML -> {
            DesignContent(
                designId = design.id,
                viewInXml = true
            )
        }
        DesignType.Compose -> {
            DesignContent(
                designId = design.id,
                viewInXml = false
            )
        }
        DesignType.Inspiration -> {
            DesignInspirationScreen(
                design = design,
                onNavigateBack = onNavigateBack
            )
        }
    }
}

@Composable
private fun DesignContent(
    designId: Int,
    viewInXml: Boolean
) {
    when (designId) {
        1 -> Design1(viewInXml)
        2 -> Design2(viewInXml)
        3 -> Design3(viewInXml)
        4 -> Design4(viewInXml)
    }
}