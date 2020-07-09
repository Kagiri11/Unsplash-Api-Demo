package com.jscode.bipolarfactorydemo.data.rest

import com.jscode.bipolarfactorydemo.data.UnSplashImage
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.unsplash.com"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RestApiService {
    @GET("/collections/{collectionId}/photos/")
    suspend fun getItemImages(
        @Path(value = "collectionId", encoded = true) id: String,
        @Query("client_id") user: String,
        @Query("page") page: Int
    ): List<UnSplashImage>
}

object RestApi {
    val retrofitService: RestApiService by lazy {
        retrofit.create(RestApiService::class.java)
    }
}