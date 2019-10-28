package com.example.treinamento.ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@set:BindingAdapter("app:isVisible")
inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

@BindingAdapter("app:loadImage")
fun loadImage(view: ImageView, url: String) {
    Picasso
        .get()
        .load(url)
        .into(view)
}