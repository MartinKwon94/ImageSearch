package com.example.imagesearch.data

data class ItemSearch(
    var title: String,
    var dateTime: String,
    var url: String,
    var isLike: Boolean = false
)