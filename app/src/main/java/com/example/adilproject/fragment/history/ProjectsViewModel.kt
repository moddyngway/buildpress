package com.example.adilproject.fragment.history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adilproject.data.model.Project
import com.example.adilproject.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectsViewModel : ViewModel() {

    val projectsLiveData = MutableLiveData<List<Project>>()
    private val repository = MainRepository()

    fun getProjects(){
        repository.getProjects().enqueue(object : Callback<List<Project>>{
            override fun onResponse(call: Call<List<Project>>, response: Response<List<Project>>) {
                projectsLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Project>>, t: Throwable) {

            }

        })
    }


}