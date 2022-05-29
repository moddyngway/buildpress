package com.example.adilproject.fragment.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adilproject.data.model.News
import com.example.adilproject.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel() : ViewModel(){

    val newsLiveData = MutableLiveData<List<News>>()
    val repository = MainRepository()

    fun getNews(){
        repository.getNews().enqueue(object : Callback<List<News>>{
            override fun onResponse(call: Call<List<News>>, response: Response<List<News>>) {
                newsLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<News>>, t: Throwable) {

            }
        })
    }
}