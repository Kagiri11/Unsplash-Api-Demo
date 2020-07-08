package com.jscode.bipolarfactorydemo.repository

import com.jscode.bipolarfactorydemo.data.ImageData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL="https://api.unsplash.com"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ImagesApiService{
    @GET("/collections/1580860/photos/?client_id=B-VMuV2BFLc1S8t6btcEsSrAXd5uy_rkOcZXb51KAzA")
    suspend fun getItemImages(): List<ImageData>
    @GET("/collections/139386/photos/?client_id=B-VMuV2BFLc1S8t6btcEsSrAXd5uy_rkOcZXb51KAzA")
    suspend fun getCatImages(): List<ImageData>
}

object NatureApi{
    val retrofitService: ImagesApiService by lazy {
        retrofit.create(ImagesApiService::class.java)
    }
}
object PetsApi{
    val retrofitService: ImagesApiService by lazy {
        retrofit.create(ImagesApiService::class.java)
    }
}