package com.kproject.cleidesigns.feature.design1

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.kproject.cleidesigns.feature.design1.compose.Design1Compose
import com.kproject.cleidesigns.feature.design1.databinding.FragmentDesign1Binding

@Composable
fun Design1(viewInXml: Boolean) {
    if (viewInXml) {
        AndroidViewBinding(FragmentDesign1Binding::inflate)
    } else {
        Design1Compose()
    }
}