package com.example.imagesearch.model

import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("documents")
    val document: ArrayList<Documents>,

    @SerializedName("meta")
    val meta: Meta
) {
    data class Documents(
        @SerializedName("collection")
        val collection: String,

        @SerializedName("thumbnail_uri")
        val thumbnailUri: String,

        @SerializedName("image_uri")
        val imageUri: String,

        @SerializedName("width")
        val width: Int,

        @SerializedName("height")
        val height: Int,

        @SerializedName("display_sitename")
        val displaySitename: String,

        @SerializedName("doc_url")
        val docUrl: String,

        @SerializedName("datetime")
        val datetime: String
    )

    data class Meta(
        @SerializedName("is_end")
        val isEnd: Boolean,

        @SerializedName("pageable_count")
        val pageableCount: Int,

        @SerializedName("total_count")
        val totalCount: Int
    )
}

