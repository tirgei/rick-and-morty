package com.tirgei.rickandmorty.utils

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.tirgei.rickandmorty.R

class EmptyStateView(context: Context, attrs: AttributeSet?): ConstraintLayout(context, attrs) {

    constructor(context: Context): this(context, null)

    init {
        inflate(context, R.layout.layout_empty_state, this)
        val messageField: TextView = findViewById(R.id.message)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.EmptyStateView, 0, 0)
        try {
            val message = typedArray.getString(R.styleable.EmptyStateView_message)
            message?.let {
                messageField.text = it
            }
        } finally {
            typedArray.recycle()
        }
    }

}