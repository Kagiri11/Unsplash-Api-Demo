package com.jscode.bipolarfactorydemo.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jscode.bipolarfactorydemo.data.UnSplashDataSource
import com.jscode.bipolarfactorydemo.data.UnSplashImage
import kotlinx.coroutines.flow.Flow

class Repository {
    companion object {
        private const val PAGE_SIZE = 10
        private const val ITEMS_COLLECTION_ID = "1580860"
        private const val CATS_COLLECTION_ID = "139386"
    }

    fun getItemImages(): Flow<PagingData<UnSplashImage>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnSplashDataSource(ITEMS_COLLECTION_ID) }
        ).flow
    }

    fun getCatImages(): Flow<PagingData<UnSplashImage>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnSplashDataSource(CATS_COLLECTION_ID) }
        ).flow
    }
}