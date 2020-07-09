package com.jscode.bipolarfactorydemo.data

import androidx.paging.PagingSource
import com.jscode.bipolarfactorydemo.data.rest.RestApi

class UnSplashDataSource(private val collectionId: String) : PagingSource<Int, UnSplashImage>() {
    companion object {
        private const val INITIAL_KEY = 1
        private const val CLIENT_ID = "B-VMuV2BFLc1S8t6btcEsSrAXd5uy_rkOcZXb51KAzA"
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnSplashImage> {
        val key = params.key ?: INITIAL_KEY
        return try {
            val result = RestApi.retrofitService.getItemImages(collectionId, CLIENT_ID, key)
            LoadResult.Page(
                data = result,
                prevKey = if (key == INITIAL_KEY) null else key - 1,
                nextKey = if (result.isEmpty()) null else key + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}