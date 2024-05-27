package com.example.kotlinmvc.home.ui

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.baselib.base.BaseActivity
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.impl.NoMultiClickListener
import com.example.kotlinmvc.databinding.ActivityWxarticleBinding
import com.example.kotlinmvc.home.adpater.WXArticleAdapter
import com.example.kotlinmvc.home.model.WXArticleModel
import com.example.kotlinmvc.home.view.WXArticleView
import com.example.kotlinmvc.main.ui.LoginActivity

/**
 *Author: chinadragon
 *Time: 2024/5/28
 */
class WXArticleActivity : BaseActivity<WXArticleModel, ActivityWxarticleBinding>(), WXArticleView {
    private lateinit var wxArticleAdapter: WXArticleAdapter
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun initViewBinding(): ActivityWxarticleBinding {
        return ActivityWxarticleBinding.inflate(layoutInflater)
    }

    override fun initData() {
        mViewModel.attachView(this)
        swipeRefresh = binding.swipeRefresh
        wxArticleAdapter = WXArticleAdapter {

        }
        binding.rvData.apply {
            layoutManager = LinearLayoutManager(this@WXArticleActivity)
            adapter = wxArticleAdapter
        }
    }

    override fun loadData() {
        swipeRefresh.isRefreshing = true
        mViewModel.wxArticle()
    }

    override fun initEvent() {
        swipeRefresh.setOnRefreshListener {
            loadData()
        }

        binding.tvLogin.setOnClickListener(NoMultiClickListener {
            startActivity(Intent(this@WXArticleActivity, LoginActivity::class.java))
        })
    }

    override fun wxArticelSuccess(wxArticleBeanList: List<WXArticleBean>) {
        swipeRefresh.isRefreshing = false
        wxArticleAdapter.setData(wxArticleBeanList)
    }

    override fun showLoading(callBack: () -> Unit) {
    }

    override fun dismissLoading() {
    }
}