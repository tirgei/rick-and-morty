package com.tirgei.rickandmorty.utils

import android.view.View
import androidx.databinding.BindingAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["app:visible"])
    fun visibility(view: View, visible: Boolean) {
        if (visible) view.show() else view.hide()
    }

}