package com.hamedsafari.home.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.hamedsafari.home.HomeViewModel
import com.hamedsafari.home.databinding.ItemHomeBinding
import com.hamedsafari.model.User

class HomeViewHolder(parent: View): RecyclerView.ViewHolder(parent) {

    private val binding = ItemHomeBinding.bind(parent)

    fun bindTo(user: User, viewModel: HomeViewModel) {
        binding.user = user
        binding.viewmodel = viewModel
    }
}