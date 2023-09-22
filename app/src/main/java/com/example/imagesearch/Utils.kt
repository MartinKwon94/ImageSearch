package com.example.imagesearch

import android.content.Context
import com.example.imagesearch.data.Constant

object Utils {
    fun saveLastSearch(context: Context, query: String) {
        val prefs = context.getSharedPreferences(Constant.PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(Constant.PREF_KEY, query).apply()
    }

    fun getLastSearch(context: Context): String? {
        val prefs = context.getSharedPreferences(Constant.PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(Constant.PREF_KEY, null)
    }
}