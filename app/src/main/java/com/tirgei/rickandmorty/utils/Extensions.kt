package com.tirgei.rickandmorty.utils

import android.view.View

/**
 * Function to hide [View]
 */
fun View.hide() {
    this.visibility = View.GONE
}

/**
 * Function to show [View]
 */
fun View.show() {
    this.visibility = View.VISIBLE
}

