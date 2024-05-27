package com.example.kotlinmvc.home.view

import com.example.baselib.base.BaseView
import com.example.baselib.bean.WXArticleBean

/**
 *Author: chinadragon
 *Time: 2024/5/28
 */
interface WXArticleView : BaseView {
    fun wxArticelSuccess(wxArticleBeanList: List<WXArticleBean>)
}