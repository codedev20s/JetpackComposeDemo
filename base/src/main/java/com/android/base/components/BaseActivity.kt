package com.android.base.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity : AppCompatActivity() {

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initUI()
        setupObservers()
    }

    open fun initUI() {
    }

    open fun setupObservers() {
    }
}