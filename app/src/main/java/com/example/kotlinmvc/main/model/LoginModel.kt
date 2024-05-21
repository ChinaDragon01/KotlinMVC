package com.example.kotlinmvc.main.model

import com.example.baselib.base.BaseModel
import com.example.kotlinmvc.main.respository.LoginRepository
import com.example.kotlinmvc.main.view.LoginView

/**
 *Author: chinadragonz
 *Time: 2024/5/19
 */
class LoginModel : BaseModel<LoginRepository, LoginView>() {

    fun login(username: String, pwd: String) {
        val map = mapOf("username" to username, "password" to pwd)
        launchApiCall({ repository.login(map) }, {
            if (it.data == null) {
                return@launchApiCall
            }
            mView.loginSuccess(it.data!!)
        }, {

        })
    }

    fun wxArticle() {
        launchApiCall({ repository.wxArticle() }, successCallBack = {
            if (it.data == null) {
                return@launchApiCall
            }
//            it.data?.forEach { wxArticleBean ->
//                LogUtil.i("==", "$wxArticleBean")
//            }

            mView.wxArticelSuccess(it.data!!)

        }, errorCallBack = {

        }, exceptionCallBack = {

        })
    }
}