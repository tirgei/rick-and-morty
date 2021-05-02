package com.tirgei.rickandmorty.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity() {
    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB

    protected val binding: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}