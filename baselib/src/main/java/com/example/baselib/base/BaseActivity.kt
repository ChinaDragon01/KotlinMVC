package com.example.baselib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.baselib.utils.GenericsUtil

/**
 *Author: chinadragon
 *Time: 2024/5/7
 */
abstract class BaseActivity<M : BaseModel<*, *>, VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var mViewModel: M
    protected lateinit var binding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        initBefore(savedInstanceState)
        super.onCreate(savedInstanceState)
        initContentView()
        initViewModel()
        initData()
        initView(savedInstanceState)
        initEvent()
    }

    private fun initContentView() {
        binding = initViewBinding()
        setContentView(binding.root)
    }

    private fun initViewModel() {
        mViewModel = GenericsUtil.getInstant(this)
    }

    abstract fun initViewBinding(): VB

    open fun initBefore(savedInstanceState: Bundle?) {

    }

    open fun initView(savedInstanceState: Bundle?) {

    }

    /**
     * Called before {@link #initView(savedInstanceState: Bundle?)}
     */
    open fun initData() {

    }

    open fun loadData() {

    }

    open fun initEvent() {

    }
}