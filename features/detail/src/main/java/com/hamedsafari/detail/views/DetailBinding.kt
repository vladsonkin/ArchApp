package com.hamedsafari.detail.views

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import coil.api.load
import coil.transform.CircleCropTransformation
import com.hamedsafari.domain.utils.Resource


@BindingAdapter("bind:imageUrlRounded")
fun loadImageRounded(view: ImageView, url: String?) {
    url?.let {
        view.load(it){
            transformations(CircleCropTransformation())
        }
    }
}

@BindingAdapter("bind:showWhenLoading")
fun showWhenLoading(view: SwipeRefreshLayout, status: Resource.Status?) {
    status?.let {
        view.isRefreshing = it == Resource.Status.LOADING
    }
}

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, url: String?) {
    url?.let { view.load(it) }
}