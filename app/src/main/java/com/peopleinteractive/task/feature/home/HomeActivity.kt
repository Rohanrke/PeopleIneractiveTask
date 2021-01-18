package com.peopleinteractive.task.feature.home

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andrognito.flashbar.Flashbar
import com.peopleinteractive.core.navigation.NavigationContract
import com.peopleinteractive.core.presentation.BaseActivity
import com.peopleinteractive.task.databinding.ActivityHomeBinding
import com.peopleinteractive.task.R
import org.koin.android.viewmodel.ext.android.viewModel

const val FIVE_SEC_MILLIS = 5000L

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by viewModel()

    lateinit var adapter: HomeListAdapter

    override fun initComponents(savedInstanceState: Bundle?, binding: ActivityHomeBinding) {
        this.binding = binding
        binding.viewModel = viewModel
        initListView()
        viewModel.fetchUsers()
    }

    private fun initListView() {
        adapter = HomeListAdapter(viewModel)
        binding.adapter = adapter
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refresh()
        }
    }

    override fun observeLiveEvents() {
        viewModel.userListLiveData.observe(this, {
            adapter.submitList(it)
        })

        viewModel.refreshed.observe(this, {
                binding.swipeRefresh.isRefreshing = false
        })

        viewModel.errorMessage.observe(this, {
            Flashbar.Builder(activity = this@HomeActivity)
                .gravity(Flashbar.Gravity.BOTTOM)
                .backgroundColor(
                    ContextCompat.getColor(
                        this@HomeActivity,
                        android.R.color.holo_red_dark
                    )
                )
                .duration(FIVE_SEC_MILLIS)
                .message(it)
                .build().show()
        })


        viewModel.messageRes.observe(this, {
            Flashbar.Builder(activity = this@HomeActivity)
                .gravity(Flashbar.Gravity.BOTTOM)
                .backgroundColor(ContextCompat.getColor(this@HomeActivity, R.color.colorAccent))
                .duration(FIVE_SEC_MILLIS)
                .message(getString(it))
                .build().show()

        })
    }
}