package com.example.imagesearch

import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("documents")
    val document: ArrayList<Documents>,

    @SerializedName("meta")
    val meta: Meta
) {
    data class Documents(
        @SerializedName
    )
}