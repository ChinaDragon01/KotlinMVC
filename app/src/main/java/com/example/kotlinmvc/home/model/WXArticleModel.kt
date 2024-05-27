package com.example.kotlinmvc.home.model

import com.example.baselib.base.BaseModel
import com.example.kotlinmvc.home.respository.WXArticleResponsitory
import com.example.kotlinmvc.home.view.WXArticleView

/**
 *Author: chinadragon
 *Time: 2024/5/28
 */
class WXArticleModel : BaseModel<WXArticleResponsitory, WXArticleView>() {
    fun wxArticle() {
        launchApiCall({ repository.wxArticle() }, successCallBack = {
            if (it.data == null) {
                return@launchApiCall
            }
            mView.wxArticelSuccess(it.data!!)

        }, errorCallBack = {

        }, exceptionCallBack = {

        })
    }
}