package com.jscode.bipolarfactorydemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.jscode.bipolarfactorydemo.data.UnSplashImage
import com.jscode.bipolarfactorydemo.repository.Repository
import kotlinx.coroutines.flow.Flow

class CatsViewModel : ViewModel() {
    private val repository = Repository()
    fun getResult(): Flow<PagingData<UnSplashImage>> {
        return repository.getCatImages().cachedIn(viewModelScope)
    }
}