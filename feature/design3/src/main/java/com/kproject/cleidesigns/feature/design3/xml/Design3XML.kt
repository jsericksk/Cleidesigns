package com.kproject.cleidesigns.feature.design3.xml

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.kproject.cleidesigns.feature.design3.R
import com.kproject.cleidesigns.feature.design3.databinding.FragmentDesign3Binding
import com.kproject.cleidesigns.feature.design3.utils.initBarChart

@Composable
internal fun Design3XML() {
    AndroidViewBinding(FragmentDesign3Binding::inflate) {
        cpIncome.setOnClickListener {
            cpIncome.setChipBackgroundColorResource(R.color.chip_background_selected)
            cpIncome.setTextColor(android.graphics.Color.WHITE)
            cpExpenses.setChipBackgroundColorResource(R.color.chip_background_unselected)
            cpExpenses.setTextColor(android.graphics.Color.parseColor("#737373"))
        }
        cpExpenses.setOnClickListener {
            cpIncome.setChipBackgroundColorResource(R.color.chip_background_unselected)
            cpIncome.setTextColor(android.graphics.Color.parseColor("#737373"))
            cpExpenses.setChipBackgroundColorResource(R.color.chip_background_selected)
            cpExpenses.setTextColor(android.graphics.Color.WHITE)
        }

        bnBottomNavigation.selectedItemId = R.id.menu_statistics

        bcChart.initBarChart()
    }
}