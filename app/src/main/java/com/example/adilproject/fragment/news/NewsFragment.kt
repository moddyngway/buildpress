package com.example.adilproject.fragment.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.adilproject.R
import com.example.adilproject.data.model.News
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment(), NewsInterface {

    private lateinit var newsAdapter: NewsAdapter
    private val newsViewModel by lazy {ViewModelProvider(this).get(NewsViewModel::class.java)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.getNews()
        newsAdapter = NewsAdapter(this)
        setupRecycler()
    }

    private fun setupRecycler() {
        newsFragment.adapter = newsAdapter
        newsViewModel.newsLiveData.observe(viewLifecycleOwner){
            newsAdapter.setData(it)
        }

    }

    override fun setOnClick(news: News) {
        Toast.makeText(requireContext(), news.title,Toast.LENGTH_LONG).show()
    }
}

interface NewsInterface{
    fun setOnClick(news: News)
}