package com.kproject.cleidesigns.presentation.fragments.design3

import androidx.compose.runtime.Composable
import androidx.viewbinding.ViewBinding
import com.kproject.cleidesigns.feature.design3.compose.Design3Compose
import com.kproject.cleidesigns.feature.design3.xml.initializeDesign3Layout
import com.kproject.cleidesigns.presentation.fragments.BaseFragment

class Design3Fragment : BaseFragment() {

    override fun initializeXmlLayout(): ViewBinding {
        return this.initializeDesign3Layout()
    }

    @Composable
    override fun ComposeLayout() = Design3Compose()
}