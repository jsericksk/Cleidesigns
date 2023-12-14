package com.kproject.cleidesigns.feature.design3

import androidx.compose.runtime.Composable
import com.kproject.cleidesigns.feature.design3.compose.Design3Compose
import com.kproject.cleidesigns.feature.design3.xml.Design3XML

@Composable
fun Design3(viewInXml: Boolean) {
    if (viewInXml) {
        Design3XML()
    } else {
        Design3Compose()
    }
}