package com.hamedsafari.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.hamedsafari.common.base.BaseFragment
import com.hamedsafari.common.base.BaseViewModel
import com.hamedsafari.common.extension.showSnackbar
import com.hamedsafari.home.databinding.FragmentHomeBinding
import com.hamedsafari.home.views.HomeAdapter
import com.hamedsafari.model.User
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [BaseFragment] subclass
 * that will show a list of top [User] from Github's API.
 */
class HomeFragment : BaseFragment() {

    // FOR DATA
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureRecyclerView()

        // We use a String here, but any type that can be put in a Bundle is supported
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("user")?.observe(
            viewLifecycleOwner) { result ->
            showSnackbar("User clicked: $result", Snackbar.LENGTH_SHORT)
        }
    }

    override fun getViewModel(): BaseViewModel = viewModel

    // ---

    private fun configureRecyclerView() {
        binding.fragmentHomeRv.adapter = HomeAdapter(viewModel)
    }
}
