package com.tirgei.rickandmorty.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["visible"])
    fun visibility(view: View, visible: Boolean) {
        if (visible) view.show() else view.hide()
    }

    @JvmStatic
    @BindingAdapter(value = ["imageUrl"])
    fun image(view: ImageView, imageUrl: String?) {
        view.load(imageUrl)
    }

}