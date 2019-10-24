package com.example.treinamento.ui

import android.view.View
import androidx.databinding.BindingAdapter

@set:BindingAdapter("app:isVisible")
inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }
