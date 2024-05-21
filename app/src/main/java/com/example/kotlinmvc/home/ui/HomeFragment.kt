package com.example.kotlinmvc.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baselib.base.BaseFragment
import com.example.kotlinmvc.databinding.FragmentHomeBinding
import com.example.kotlinmvc.home.model.HomeModel

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class HomeFragment : BaseFragment<HomeModel, FragmentHomeBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    companion object {
        fun creatHomeFragment(bundle: Bundle = Bundle()): HomeFragment {
            var bundle = Bundle()
            return HomeFragment().apply {
                arguments = bundle
            }
        }
    }
}