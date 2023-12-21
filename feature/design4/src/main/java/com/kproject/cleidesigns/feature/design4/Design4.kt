package com.kproject.cleidesigns.feature.design4

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.kproject.cleidesigns.feature.design4.compose.Design4Compose
import com.kproject.cleidesigns.feature.design4.databinding.FragmentDesign4Binding

@Composable
fun Design4(viewInXml: Boolean) {
    if (viewInXml) {
        AndroidViewBinding(FragmentDesign4Binding::inflate)
    } else {
        Design4Compose()
    }
}