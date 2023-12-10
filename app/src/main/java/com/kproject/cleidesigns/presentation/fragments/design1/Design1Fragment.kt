package com.kproject.cleidesigns.presentation.fragments.design1

import androidx.compose.runtime.Composable
import com.kproject.cleidesigns.databinding.FragmentDesign1Binding
import com.kproject.cleidesigns.presentation.fragments.BaseFragment

class Design1Fragment : BaseFragment() {

    override fun initializeXmlLayout() = FragmentDesign1Binding.inflate(layoutInflater)

    @Composable
    override fun ComposeLayout() = Design1Compose()
}