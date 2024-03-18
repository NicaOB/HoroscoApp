package com.example.horoscoapp.ui.core.listeners

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

open class OnSwipeTouchListener(val context: Context?) : View.OnTouchListener {
    companion object {
        private const val SwipeThreshold = 100
        private const val SwipeVelocityThreshold = 100
    }

    private val gestureDetector = GestureDetector(context, GestureListener())

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    open fun onSwipeRight(): Boolean {
        return false
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val diffX = e2.x - e1!!.x
            return when {
                diffX > SwipeThreshold -> onSwipeRight()
                else -> false
            }

        }
    }
}