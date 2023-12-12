package com.kproject.cleidesigns.presentation.fragments.design2

import androidx.compose.runtime.Composable
import androidx.viewbinding.ViewBinding
import com.kproject.cleidesigns.feature.design2.compose.Design2Compose
import com.kproject.cleidesigns.feature.design2.xml.initializeDesign2Layout
import com.kproject.cleidesigns.presentation.fragments.BaseFragment

class Design2Fragment : BaseFragment() {

    override fun initializeXmlLayout(): ViewBinding {
        return this.initializeDesign2Layout()
    }

    @Composable
    override fun ComposeLayout() = Design2Compose()
}