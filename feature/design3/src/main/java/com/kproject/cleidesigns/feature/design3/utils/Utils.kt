package com.kproject.cleidesigns.feature.design3.utils

import android.graphics.Color
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

internal val days = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

internal fun BarChart.initBarChart() {
    val barChart = this
    val entries: ArrayList<BarEntry> = ArrayList()
    entries.add(BarEntry(0f, 205f))
    entries.add(BarEntry(1f, 100f))
    entries.add(BarEntry(2f, 250f))
    entries.add(BarEntry(3f, 150f))
    entries.add(BarEntry(4f, 380f))
    entries.add(BarEntry(5f, 250f))
    entries.add(BarEntry(6f, 150f))

    val barDataSet = BarDataSet(entries, "")
    barDataSet.color = Color.parseColor("#4D4AD8")
    barDataSet.setDrawValues(false)
    val data = BarData(barDataSet)
    barChart.data = data

    barChart.setDrawValueAboveBar(false)
    barChart.setDrawBorders(false)
    barChart.setDrawGridBackground(false)
    barChart.setDrawBarShadow(false)

    val xAxis = barChart.xAxis
    xAxis.valueFormatter = MyAxisFormatter()

    xAxis.position = XAxis.XAxisPosition.BOTTOM
    xAxis.granularity = 1f
    xAxis.setDrawAxisLine(false)
    xAxis.setDrawGridLines(false)

    val leftAxis: YAxis = barChart.axisLeft
    leftAxis.setDrawAxisLine(false)

    barChart.isDoubleTapToZoomEnabled = false
    barChart.setPinchZoom(false)
    barChart.setScaleEnabled(false)
    barChart.axisRight.isEnabled = false
    barChart.legend.isEnabled = false
    barChart.description.isEnabled = false
}

internal class MyAxisFormatter : IndexAxisValueFormatter() {

    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        val index = value.toInt()
        return if (index < days.size) {
            days[index]
        } else {
            ""
        }
    }
}