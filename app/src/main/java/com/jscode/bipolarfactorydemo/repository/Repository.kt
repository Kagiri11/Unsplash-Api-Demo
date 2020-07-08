package com.jscode.bipolarfactorydemo.repository

class Repository {
    suspend fun getItemImages()= PetsApi.retrofitService.getItemImages()
    suspend fun getCatImages()= NatureApi.retrofitService.getCatImages()
}