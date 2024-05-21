package com.example.kotlinmvc.mine.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baselib.base.BaseFragment
import com.example.kotlinmvc.databinding.FragmentMineBinding
import com.example.kotlinmvc.mine.model.MineModel

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class MineFragment : BaseFragment<MineModel, FragmentMineBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMineBinding {
        return FragmentMineBinding.inflate(inflater, container, false)
    }
}