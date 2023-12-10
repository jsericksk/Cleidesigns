package com.kproject.cleidesigns.presentation.fragments.design3

import android.graphics.Color
import androidx.compose.runtime.Composable
import androidx.viewbinding.ViewBinding
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.databinding.FragmentDesign3Binding
import com.kproject.cleidesigns.presentation.fragments.BaseFragment

class Design3Fragment : BaseFragment() {

    override fun initializeXmlLayout(): ViewBinding {
        val binding = FragmentDesign3Binding.inflate(layoutInflater)

        with (binding) {
            cpIncome.setOnClickListener {
                cpIncome.setChipBackgroundColorResource(R.color.chip_background_selected)
                cpIncome.setTextColor(Color.WHITE)
                cpExpenses.setChipBackgroundColorResource(R.color.chip_background_unselected)
                cpExpenses.setTextColor(Color.parseColor("#737373"))
            }
            cpExpenses.setOnClickListener {
                cpIncome.setChipBackgroundColorResource(R.color.chip_background_unselected)
                cpIncome.setTextColor(Color.parseColor("#737373"))
                cpExpenses.setChipBackgroundColorResource(R.color.chip_background_selected)
                cpExpenses.setTextColor(Color.WHITE)
            }

            bnBottomNavigation.selectedItemId = R.id.menu_statistics

            Design3Utils.initBarChart(barChart = bcChart)
        }
        return binding
    }

    @Composable
    override fun ComposeLayout() = Design3Compose()
}