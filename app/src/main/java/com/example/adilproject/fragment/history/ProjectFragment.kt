package com.example.adilproject.fragment.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.adilproject.R
import kotlinx.android.synthetic.main.fragment_history.*


class ProjectFragment : Fragment() {

    private val viewModel by lazy {ViewModelProvider(this).get(ProjectsViewModel::class.java)}
    private val adapter by lazy {ProjectsAdapter()}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        projectsRv.adapter = adapter
        viewModel.getProjects()
        viewModel.projectsLiveData.observe(viewLifecycleOwner){
            adapter.addAll(it)
        }

    }
}