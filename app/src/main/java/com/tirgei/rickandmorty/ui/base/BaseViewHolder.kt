package com.tirgei.rickandmorty.ui.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<in T>(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(data: T)
}