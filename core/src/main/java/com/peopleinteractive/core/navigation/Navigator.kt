package com.peopleinteractive.core.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle

object Navigator {

    fun <T> navigateToActivity(context: Context, activityClass: Class<T>, bundle: Bundle? = null) {
        context.startActivity(Intent(context, activityClass).apply {
            bundle?.let { putExtras(it) }
        })
    }

}