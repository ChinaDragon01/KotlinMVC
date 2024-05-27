package com.example.kotlinmvc.main.model

import com.example.baselib.base.BaseModel
import com.example.baselib.bean.UserInfoBean
import com.example.kotlinmvc.main.respository.LoginRepository
import com.example.kotlinmvc.main.view.LoginView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *Author: chinadragonz
 *Time: 2024/5/19
 */
class LoginModel : BaseModel<LoginRepository, LoginView>() {

    fun login(username: String, pwd: String) {

        //模拟登录成功
        CoroutineScope(Dispatchers.IO).launch {
            delay(400)
            mView.loginSuccess(UserInfoBean("", "", ""))

        }

        return
        val map = mapOf("username" to username, "password" to pwd)
        launchApiCall({ repository.login(map) }, {
            if (it.data == null) {
                return@launchApiCall
            }
            mView.loginSuccess(it.data!!)
        }, {

        })
    }
}