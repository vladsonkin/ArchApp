package com.hamedsafari.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hamedsafari.common.base.BaseFragment
import com.hamedsafari.common.base.BaseViewModel
import com.hamedsafari.detail.databinding.FragmentDetailBinding
import com.hamedsafari.model.User
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * A simple [BaseFragment] subclass
 * that will show the [User] details.
 */
class DetailFragment : BaseFragment() {

    // FOR DATA
    private val viewModel: DetailViewModel by viewModel{ parametersOf(args.login)}
    private lateinit var binding: FragmentDetailBinding

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {
            findNavController().previousBackStackEntry?.savedStateHandle?.set("user", it.name)
        }
    }

    override fun getViewModel(): BaseViewModel = viewModel

    override fun getExtras(): FragmentNavigator.Extras =
        FragmentNavigatorExtras(binding.fragmentDetailAvatar to getString(R.string.transition_avatar_dest))
}
