package com.example.adilproject.fragment.projects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adilproject.R
import com.example.adilproject.data.model.Check
import com.example.adilproject.data.model.News
import kotlinx.android.synthetic.main.news_item_vh.view.*

class CheckAdapter : RecyclerView.Adapter<CheckAdapter.NewsViewHolder>() {

    private var newsList = mutableListOf<Check>()

    fun setData(list:List<Check>){
        newsList.clear()
        newsList.addAll(list)
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(item: Check){
            itemView.newsTitle.text = item.category
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