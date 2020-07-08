package com.jscode.bipolarfactorydemo.ui

import androidx.lifecycle.*
import com.jscode.bipolarfactorydemo.data.ImageData
import com.jscode.bipolarfactorydemo.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemsViewModel : ViewModel() {
    private val _images= MutableLiveData<List<ImageData>>()
    val images:LiveData<List<ImageData>>
        get() = _images
    private val repository= Repository()

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _images.postValue(repository.getItemImages())
            }
        }
    }
}