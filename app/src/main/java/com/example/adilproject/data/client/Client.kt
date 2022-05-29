package com.example.adilproject.data.client

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private lateinit var myRequest: Requests

    fun getInstanceOfMyRequest(): Requests {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://course-app-build.herokuapp.com/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        myRequest = retrofit.create(Requests::class.java)

        return myRequest
    }
}