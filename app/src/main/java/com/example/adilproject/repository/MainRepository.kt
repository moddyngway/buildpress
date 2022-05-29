package com.example.adilproject.repository

import com.example.adilproject.data.client.Client

class MainRepository() {

    fun getNews() = Client.getInstanceOfMyRequest().getNews()

    fun getProjects() = Client.getInstanceOfMyRequest().getProjects()

    fun getChecks() = Client.getInstanceOfMyRequest().getChecks()




}