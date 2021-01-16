package com.peopleinteractive.task.feature.home

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peopleinteractive.core.navigation.NavigationContract
import com.peopleinteractive.core.presentation.BaseActivity
import com.peopleinteractive.task.databinding.ActivityHomeBinding
import com.peopleinteractive.task.R
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity: BaseActivity<ActivityHomeBinding>(R.layout.activity_home){

    lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by viewModel()

    lateinit var adapter: HomeListAdapter

    override fun initComponents(savedInstanceState: Bundle?, binding: ActivityHomeBinding) {
        this.binding = binding
        initListView()
    }

    private fun initListView(){
       adapter = HomeListAdapter(viewModel)
       binding.adapter = adapter
    }

    override fun observeLiveEvents() {

    }


}