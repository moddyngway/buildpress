package com.example.adilproject.fragment.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adilproject.R
import com.example.adilproject.data.model.Project
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.projects_item_vh.view.*

class ProjectsAdapter : RecyclerView.Adapter<ProjectsAdapter.ProjectsViewHolder>() {

    private val projectsList = mutableListOf<Project>()

    fun addAll(list:List<Project>){
        projectsList.clear()
        projectsList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ProjectsViewHolder(private val itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(item:Project){
            Picasso.get()
                .load(item.image)
                .into(itemView.projectImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.projects_item_vh, parent, false)
        return ProjectsViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        holder.bind(projectsList[position])
    }

    override fun getItemCount(): Int {
        return projectsList.size
    }

}