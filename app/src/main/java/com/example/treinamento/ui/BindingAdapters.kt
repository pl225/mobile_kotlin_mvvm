package com.example.treinamento.ui

import android.view.View
import androidx.databinding.BindingAdapter

/*@set:BindingAdapter("app:isVisible")
inline var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }*/


/*@BindingAdapter("android:visibility")
fun setVisibility(view: View, visibility: Boolean) {
    view.visibility = if (visibility) View.VISIBLE else View.GONE
}*/

/*@BindingAdapter("app:goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}*/


@BindingAdapter("app:hide")
fun hide(view: View, b: Boolean) {
    view.visibility = if (!b) View.GONE else View.VISIBLE
}
