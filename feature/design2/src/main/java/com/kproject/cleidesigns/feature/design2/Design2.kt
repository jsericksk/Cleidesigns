package com.kproject.cleidesigns.feature.design2

import androidx.compose.runtime.Composable
import com.kproject.cleidesigns.feature.design2.compose.Design2Compose
import com.kproject.cleidesigns.feature.design2.xml.Design2XML

@Composable
fun Design2(viewInXml: Boolean) {
    if (viewInXml) {
        Design2XML()
    } else {
        Design2Compose()
    }
}