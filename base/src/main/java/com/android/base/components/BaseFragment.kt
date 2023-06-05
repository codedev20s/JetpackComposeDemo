package com.android.base.components

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment


open class BaseFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        setupObservers()
    }

    open fun initUI() {}


    open fun setupObservers() {

    }

}