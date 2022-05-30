package com.example.adilproject.fragment.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adilproject.R
import com.example.adilproject.data.model.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item_vh.view.*
import kotlinx.android.synthetic.main.projects_item_vh.view.*

class NewsAdapter(private val newsInterface: NewsInterface) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var newsList = mutableListOf<News>()

    fun setData(list:List<News>){
        newsList.clear()
        newsList.addAll(list)
        notifyDataSetChanged()
    }



    inner class NewsViewHolder(private val itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(item: News){
            itemView.setOnClickListener {
                newsInterface.setOnClick(item)
            }
            itemView.newsTitle.text = item.title
            itemView.newsCategory.text = item.category_str
            itemView.newsText.text = item.text
            Picasso.get()
                .load(item.image)
                .into(itemView.newsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.news_item_vh, parent, false)
        return NewsViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }


}