package com.example.kotlinmvc.main.ui

import android.content.Intent
import android.os.Bundle
import com.example.baselib.base.BaseActivity
import com.example.baselib.bean.UserInfoBean
import com.example.baselib.https.ApiErrorInfo
import com.example.baselib.impl.NoMultiClickListener
import com.example.baselib.utils.ToastUtil
import com.example.kotlinmvc.databinding.ActivityLoginBinding
import com.example.kotlinmvc.home.ui.WXArticleActivity
import com.example.kotlinmvc.main.model.LoginModel
import com.example.kotlinmvc.main.view.LoginView

/**
 *Author: chinadragon
 *Time: 2024/5/19
 */
class LoginActivity : BaseActivity<LoginModel, ActivityLoginBinding>(), LoginView {
    override fun initViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mViewModel.attachView(this)
    }

    override fun initEvent() {
        super.initEvent()
        with(binding) {
            btnLogin.setOnClickListener(NoMultiClickListener {
                mViewModel.login("", "")
            })

            btnLookWXArticle.setOnClickListener(NoMultiClickListener {
                startActivity(Intent(this@LoginActivity, WXArticleActivity::class.java))
            })
        }
    }

    override fun loginSuccess(userInfoBean: UserInfoBean) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun loginFail(apiErrorInfo: ApiErrorInfo) {
        ToastUtil.show("登录失败")
    }

    override fun showLoading(callBack: () -> Unit) {
        ToastUtil.show("加载中...")

    }

    override fun dismissLoading() {

    }

}