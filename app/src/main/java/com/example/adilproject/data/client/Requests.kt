package com.example.adilproject.data.client

import com.example.adilproject.data.model.Check
import com.example.adilproject.data.model.News
import com.example.adilproject.data.model.Project
import retrofit2.Call
import retrofit2.http.GET

interface Requests {
    @GET("blogs/")
    fun getNews(): Call<List<News>>

    @GET("projects/")
    fun getProjects(): Call<List<Project>>

    @GET("checks/")
    fun getChecks(): Call<List<Check>>
}