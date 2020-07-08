package com.jscode.bipolarfactorydemo.data

data class ImageData(
    val id:String,
    val description:String?,
    val urls:ImageUrlData?
)
data class ImageUrlData(
    val regular:String?
)