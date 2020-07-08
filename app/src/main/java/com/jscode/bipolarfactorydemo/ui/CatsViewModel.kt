package com.jscode.bipolarfactorydemo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jscode.bipolarfactorydemo.data.ImageData
import com.jscode.bipolarfactorydemo.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatsViewModel :ViewModel(){
    private val _images= MutableLiveData<List<ImageData>>()
    val images: LiveData<List<ImageData>>
        get() = _images
    private val repository= Repository()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _images.postValue(repository.getCatImages())
            }
        }
    }
}