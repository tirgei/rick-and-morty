package com.tirgei.rickandmorty.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide

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

/**
 * Function to load image from url to instance of [ImageView] using [Glide]
 * @param url - URL of the image
 */
fun ImageView.load(url: String?) {
    Glide.with(this.context)
        .load(url)
        .centerCrop()
        .thumbnail(0.2f)
        .into(this)
}

/**
 * Bind layout to respective ViewDataBinding implementation
 * @param layoutRes - Layout id to be inflated
 */
inline fun <reified T : ViewDataBinding> ViewGroup.bind(@LayoutRes layoutRes: Int): T {
    return DataBindingUtil.inflate(LayoutInflater.from(context), layoutRes, this, false)
}
