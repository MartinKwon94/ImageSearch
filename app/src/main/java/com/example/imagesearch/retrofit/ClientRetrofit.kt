package com.example.imagesearch.retrofit

import android.provider.SyncStateContract.Constants
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClientRetrofit {

    val apiService: InterfaceRetrofit
        get() = instance.create(InterfaceRetrofit::class.java)

    private val instance: Retrofit
        private get() {
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
}