package com.example.adilproject.fragment.checks

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.adilproject.data.model.Check
import com.example.adilproject.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CheckViewModel : ViewModel() {

    val checkLiveData = MutableLiveData<List<Check>>()
    private val repository = MainRepository()

    fun getChecks(){
        repository.getChecks().enqueue(object : Callback<List<Check>>{
            override fun onResponse(call: Call<List<Check>>, response: Response<List<Check>>) {
                checkLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Check>>, t: Throwable) {

            }

        })
    }

}