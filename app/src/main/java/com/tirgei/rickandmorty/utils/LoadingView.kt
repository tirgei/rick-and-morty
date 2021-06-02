package com.tirgei.rickandmorty.utils

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.tirgei.rickandmorty.R

class LoadingView(context: Context, attrs: AttributeSet?): ConstraintLayout(context, attrs) {

    constructor(context: Context): this(context, null)

    init {
        inflate(context, R.layout.layout_loading, this)
    }

}