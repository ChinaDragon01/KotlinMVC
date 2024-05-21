package com.example.kotlinmvc.main.view

import com.example.baselib.base.BaseView
import com.example.baselib.https.ApiErrorInfo
import com.example.baselib.bean.UserInfoBean
import com.example.baselib.bean.WXArticleBean

/**
 *Author: chinadragon
 *Time: 2024/5/19
 */
interface LoginView : BaseView {
    fun loginSuccess(userInfoBean: UserInfoBean)
    fun loginFail(apiErrorInfo: ApiErrorInfo)
    fun wxArticelSuccess(wxArticleBeanList: List<WXArticleBean>)
}