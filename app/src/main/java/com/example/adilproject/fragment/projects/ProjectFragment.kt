package com.example.adilproject.fragment.projects

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.adilproject.R
import com.example.adilproject.data.model.Project
import kotlinx.android.synthetic.main.fragment_history.*


class ProjectFragment : Fragment(), ProjectInterface {

    private val viewModel by lazy {ViewModelProvider(this).get(ProjectsViewModel::class.java)}
    private lateinit var adapter: ProjectsAdapter

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ProjectsAdapter(this)

        projectsRv.adapter = adapter
        viewModel.getProjects()
        viewModel.projectsLiveData.observe(viewLifecycleOwner){
            adapter.addAll(it)
        }

        handler = Handler()

        projectSwipe.setOnRefreshListener {
            runnable = Runnable {
                viewModel.getProjects()
                viewModel.projectsLiveData.observe(viewLifecycleOwner){
                    adapter.addAll(it)
                }

                Toast.makeText(requireContext(), "updating" ,Toast.LENGTH_LONG).show()

                projectSwipe.isRefreshing = false
            }

            // Execute the task after specified time
            handler.postDelayed(
                runnable, 3000.toLong()
            )
        }



        projectSwipe.setColorSchemeResources(
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light
        )

    }

    override fun setOnClick(project: Project) {
        val intent = Intent(Intent.ACTION_DIAL);
        intent.data = Uri.parse("tel:0705370158")
        startActivity(intent)
    }


}

interface ProjectInterface{
    fun setOnClick(project: Project)
}