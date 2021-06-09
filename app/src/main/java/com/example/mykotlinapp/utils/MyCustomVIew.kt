package com.example.mykotlinapp.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class MyCustomVIew : View {
    private var circleColor = DEFAULT_CIRCLE_COLOR
    private var paint: Paint? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        paint = Paint()
        paint!!.isAntiAlias = true
    }

    fun setCircleColor(circleColor: Int) {
        this.circleColor = circleColor
        invalidate()
    }

    fun getCircleColor(): Int {
        return circleColor
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val w = width
        val h = height
        val pl = paddingLeft
        val pr = paddingRight
        val pt = paddingTop
        val pb = paddingBottom
        val usableWidth = w - (pl + pr)
        val usableHeight = h - (pt + pb)
        val radius = Math.min(usableWidth, usableHeight) / 2
        val cx = pl + usableWidth / 2
        val cy = pt + usableHeight / 2
        paint!!.color = circleColor
        canvas.drawCircle(cx.toFloat(), cy.toFloat(), radius.toFloat(), paint!!)
    }

    companion object {
        private val DEFAULT_CIRCLE_COLOR: Int = Color.RED
    }
}