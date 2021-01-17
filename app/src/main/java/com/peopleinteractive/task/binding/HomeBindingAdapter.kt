package com.peopleinteractive.task.binding

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.peopleinteractive.task.R
import com.peopleinteractive.task.feature.home.HomeListAdapter

@BindingAdapter("adapter")
fun setHomeListAdapter(recyclerView: RecyclerView, homeAdapter: HomeListAdapter) {
    recyclerView.apply {
        layoutManager = LinearLayoutManager(recyclerView.context)
        adapter = homeAdapter
    }
}

@BindingAdapter("title", "firstName", "lastName")
fun setUserName(textView: TextView, title: String?, firstName: String?, lastName: String?) {
    val name =
        "${if (title.isNullOrEmpty()) "" else title} ${if (firstName.isNullOrEmpty()) "" else firstName} ${if (lastName.isNullOrEmpty()) "" else lastName}"
    textView.text = name
}


@BindingAdapter("city", "state", "country")
fun setUserAddress(textView: TextView, city: String?, state: String?, country: String?) {
    val name =
        "${if (city.isNullOrEmpty()) "" else city} ${if (state.isNullOrEmpty()) "" else state} ${if (country.isNullOrEmpty()) "" else country}"
    textView.text = name
}

@BindingAdapter("imageUri")
fun loadImage(imageView: ImageView, imageUri: String?) {
    imageUri?.let {
        Glide.with(imageView.context).load(it).into(imageView)
    }
}

@BindingAdapter("accepted")
fun setAcceptedText(button: Button, stateAccepted: Boolean) {
    button.apply {
        text = if (stateAccepted) context.getString(R.string.text_accepted) else context.getString(R.string.text_accept)
        backgroundTintList = if (stateAccepted) ContextCompat.getColorStateList(context, R.color.accept_color_state_list) else
            ContextCompat.getColorStateList(context, R.color.default_color_state)
    }
}


@BindingAdapter("declined")
fun setDeclinedText(button: Button, stateDeclined: Boolean) {
    button.apply {
        text =
            if (stateDeclined) context.getString(R.string.text_declined) else context.getString(R.string.text_decline)
            backgroundTintList = if (stateDeclined) ContextCompat.getColorStateList(context, R.color.decline_color_state_list) else
            ContextCompat.getColorStateList(context, R.color.default_color_state)
    }
}