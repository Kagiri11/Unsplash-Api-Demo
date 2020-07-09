package com.jscode.bipolarfactorydemo.data

import com.squareup.moshi.Json

data class UnSplashImage(
    @Json(name = "id") val id: String,
    @Json(name = "description") val description: String?,
    @Json(name = "urls") val urls: ImageUrlData?
)

data class ImageUrlData(
    @Json(name = "regular") val regular: String?
)