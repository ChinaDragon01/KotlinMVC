package com.example.kotlinmvc.community.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baselib.base.BaseFragment
import com.example.kotlinmvc.community.model.CommunityModel
import com.example.kotlinmvc.databinding.FragmentCommunityBinding

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class CommunityFragment : BaseFragment<CommunityModel, FragmentCommunityBinding>() {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCommunityBinding {
        return FragmentCommunityBinding.inflate(inflater, container, false)
    }
}