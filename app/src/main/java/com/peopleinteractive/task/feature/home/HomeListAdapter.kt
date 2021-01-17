package com.peopleinteractive.task.feature.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.peopleinteractive.domain.entity.User
import com.peopleinteractive.task.databinding.ItemHomeListBinding
import com.peopleinteractive.task.R

class HomeListAdapter(private val homeViewModel: HomeViewModel) :
    ListAdapter<User, HomeListAdapter.HomeViewHolder>(HomeDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = DataBindingUtil.inflate<ItemHomeListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home_list,
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeDiffUtil : DiffUtil.ItemCallback<User>() {
        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    inner class HomeViewHolder(private val binding: ItemHomeListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.user = user
            binding.btnAccept.setOnClickListener {
                if (!user.isAccepted && !user.isDeclined) {
                    user.isAccepted = true
                    homeViewModel.updateUser(user)

                    binding.btnAccept.apply {
                        text = context.getString(R.string.text_accepted)
                        backgroundTintList = ContextCompat.getColorStateList(context, R.color.accept_color_state_list)
                    }

                }
            }

            binding.btnDecline.setOnClickListener {
                if (!user.isAccepted && !user.isDeclined) {
                    user.isDeclined = true
                    homeViewModel.updateUser(user)

                    binding.btnDecline.apply {
                        text = context.getString(R.string.text_declined)
                        backgroundTintList = ContextCompat.getColorStateList(context, R.color.decline_color_state_list)
                    }
                }
            }
        }

    }
}