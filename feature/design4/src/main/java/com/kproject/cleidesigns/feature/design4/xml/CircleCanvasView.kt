package com.kproject.cleidesigns.feature.design4.xml

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.kproject.cleidesigns.feature.design4.R

class CircleCanvasView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val primaryCircleColor = ContextCompat.getColor(context, R.color.primary_circle)
    private val secondaryCircleColor = ContextCompat.getColor(context, R.color.secondary_circle)

    private val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCircles(canvas)
    }

    private fun drawCircles(canvas: Canvas) {
        paint.color = primaryCircleColor
        canvas.drawCircle(0f, 0f, 150.dpToPx(), paint)

        paint.color = primaryCircleColor
        canvas.drawCircle(120.dpToPx(), (-30).dpToPx(), 120.dpToPx(), paint)

        paint.color = secondaryCircleColor
        canvas.drawCircle(width.toFloat() + 50.dpToPx(), height.toFloat(), 150.dpToPx(), paint)

        paint.color = secondaryCircleColor
        canvas.drawCircle(
            width.toFloat() - 150.dpToPx(),
            height.toFloat() + 50.dpToPx(),
            120.dpToPx(),
            paint
        )
    }

    private fun Int.dpToPx(): Float {
        val density = resources.displayMetrics.density
        return this * density
    }
}