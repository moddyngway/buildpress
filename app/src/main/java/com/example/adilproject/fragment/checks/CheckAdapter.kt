package com.example.adilproject.fragment.checks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adilproject.R
import com.example.adilproject.data.model.Check
import kotlinx.android.synthetic.main.check_item_vh.view.*

class CheckAdapter : RecyclerView.Adapter<CheckAdapter.NewsViewHolder>() {

    private var newsList = mutableListOf<Check>()

    fun setData(list:List<Check>){
        newsList.clear()
        newsList.addAll(list)
        notifyDataSetChanged()
    }

    inner class NewsViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(item: Check){
            itemView.checkProject.text = item.project
            itemView.checkPrice.text = item.price.toString() + " сом"
            itemView.checkCategory.text = item.category
            itemView.checkDate.text = item.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.check_item_vh, parent, false)
        return NewsViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }


}