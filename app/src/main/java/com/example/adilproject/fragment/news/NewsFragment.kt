package com.example.adilproject.fragment.news

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
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

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    private val newsViewModel by lazy {ViewModelProvider(this).get(NewsViewModel::class.java)}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.getNews()
        newsAdapter = NewsAdapter(this)
        setupRecycler()

        handler = Handler()

        newsSwipe.setOnRefreshListener {
            runnable = Runnable {
                setupRecycler()

                newsViewModel.getNews()
                newsViewModel.newsLiveData.observe(viewLifecycleOwner){
                    newsAdapter.setData(it)
                }

                Toast.makeText(requireContext(), "updating" ,Toast.LENGTH_LONG).show()

                newsSwipe.isRefreshing = false
            }

            // Execute the task after specified time
            handler.postDelayed(
                runnable, 3000.toLong()
            )
        }

        newsSwipe.setColorSchemeResources(
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light
        )
    }

    private fun setupRecycler() {
        newsFragment.adapter = newsAdapter
        newsViewModel.newsLiveData.observe(viewLifecycleOwner){
            newsAdapter.setData(it)
        }

    }

    override fun setOnClick(news: News) {
//        Toast.makeText(requireContext(), news.description ,Toast.LENGTH_LONG).show()
        val browserIntent = Intent(Intent.ACTION_VIEW,
            Uri.parse("https://course-app-build.herokuapp.com/blogs/"))
        startActivity(browserIntent)
    }
}

interface NewsInterface{
    fun setOnClick(news: News)
}