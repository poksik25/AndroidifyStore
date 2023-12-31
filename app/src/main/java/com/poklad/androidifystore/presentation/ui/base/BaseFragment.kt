package com.poklad.androidifystore.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    protected val binding: VB by lazy { inflateViewBinding(layoutInflater) }

    protected abstract val viewModel: VM
    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    @MainThread
    protected fun navigateToFragment(@IdRes res: Int, args: Bundle?) {
        findNavController().navigate(
            resId = res,
            args = args,
            navOptions = null
        )
    }

    protected fun <T> setUpRecyclerView(
        adapter: BaseAdapter<T>,
        recyclerView: RecyclerView,
        @RecyclerView.Orientation orientation: Int,
        onItemClick: (T) -> Unit
    ) {
        recyclerView.run {
            layoutManager = LinearLayoutManager(requireContext(), orientation, false)
            this.adapter = adapter
        }
        adapter.setOnclickListener { item ->
            onItemClick(item)
        }
    }
}