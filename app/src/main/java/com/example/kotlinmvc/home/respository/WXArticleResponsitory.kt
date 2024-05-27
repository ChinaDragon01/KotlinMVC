package com.example.kotlinmvc.home.respository

import com.example.baselib.base.BaseRepository
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiResponse

/**
 *Author: chinadragon
 *Time: 2024/5/28
 */
class WXArticleResponsitory : BaseRepository() {
    suspend fun wxArticle(): ApiResponse<List<WXArticleBean>> {
        return apiCall { apiService.wxArticle() }
    }
}