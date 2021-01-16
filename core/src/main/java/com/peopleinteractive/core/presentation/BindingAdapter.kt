package com.peopleinteractive.core.presentation

import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("visible")
fun setVisibility(view: View, isVisible: Boolean?) {
    view.visibility = if (isVisible == true) View.VISIBLE else View.GONE
}
