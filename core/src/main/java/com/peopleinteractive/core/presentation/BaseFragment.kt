package com.peopleinteractive.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.peopleinteractive.core.navigation.NavigationContract

abstract class BaseFragment<VDB : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : Fragment() {

    open val navigationContract: NavigationContract? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<VDB>(inflater, layoutResId, container, false).apply {
        // continue initializing other components
        initComponents(savedInstanceState, this)
        handleObserver()
    }.root

    abstract fun initComponents(savedInstanceState: Bundle?, binding: VDB)

    private fun handleObserver() {
        navigationContract?.observeLiveEvents()
        navigationContract?.observeNavigationEvents()
    }

    fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showToast(@StringRes msg: Int) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun color(@ColorRes id: Int): Int{
        return resources.getColor(id)
    }
}