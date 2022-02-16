package com.kproject.cleidesigns.ui.fragments.design1

import androidx.compose.runtime.Composable
import com.kproject.cleidesigns.databinding.FragmentDesign1Binding
import com.kproject.cleidesigns.ui.fragments.BaseFragment

class Design1Fragment : BaseFragment() {

    override fun initializeXmlLayout() = FragmentDesign1Binding.inflate(layoutInflater)

    @Composable
    override fun ComposeLayout() {
        Design1Compose()
    }
}