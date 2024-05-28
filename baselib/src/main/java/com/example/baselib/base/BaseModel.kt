package com.example.baselib.base

import com.example.baselib.constant.HttpsConstant
import com.example.baselib.https.ApiResponse
import com.example.baselib.utils.GenericsUtil
import com.example.baselib.utils.ToastUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *Author: chinadragon
 *Time: 2024/5/6
 */
open class BaseModel<Repository : BaseRepository, V : BaseView> {
    protected lateinit var mView: V
    protected val jobList = mutableListOf<Job>()

    val repository: Repository by lazy {
        return@lazy GenericsUtil.getInstant(this)
    }

    fun attachView(view: V) {
        mView = view
    }

    fun cancelAllJob() {
        if (jobList.isEmpty()) {
            return
        }
        jobList.forEach {
            if (it.isActive) {
                it.cancel()
            }
        }
        jobList.clear()
    }

    fun <T> launchApiCall(
        apiCall: suspend CoroutineScope.() -> ApiResponse<T>,
        successCallBack: suspend CoroutineScope.(response: ApiResponse<T>) -> Unit = {},
        errorCallBack: suspend CoroutineScope.(response: ApiResponse<T>) -> Unit = {},
        exceptionCallBack: suspend CoroutineScope.() -> Unit = {},
        showToast: Boolean = true,
    ) {
        /*
           注意：
           如果BaseRepository 里的 apiCall 里面 使用了withContext(Dispatchers.IO)
           所以CoroutineScope的 context 可以指定为Dispatchers.Unconfined

           如果 BaseRepository 里的 apiCall 里面 没有使用withContext(Dispatchers.IO)
           那么CoroutineScope的 context 需要指定为Dispatchers.IO

           这里指定为 Dispatchers.IO

           如果不明白，可以查阅关于调度器（Dispatchers）的使用
         */
        val job = CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiCall()
                withContext(Dispatchers.Main){
                    if (response.errorCode == HttpsConstant.NET_SUCCESS) {
                        successCallBack(response)

                    } else {
                        errorCallBack(response)
                        if (showToast) {
                            ToastUtil.show(response.errorMsg)
                        }
                    }
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main){
                    exceptionCallBack()
                }
            }
        }

        if (job.isActive) {
            jobList.add(job)
        }

    }
}