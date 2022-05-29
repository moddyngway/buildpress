package com.example.adilproject.fragment.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.adilproject.R
import kotlinx.android.synthetic.main.fragment_projects.*


class CheckFragment : Fragment() {

    private val viewModel by lazy{ViewModelProvider(this).get(CheckViewModel::class.java)}
    private val checkAdapter = CheckAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        viewModel.getChecks()

    }

    private fun setupRecycler() {
        checksRv.adapter = checkAdapter
        viewModel.checkLiveData.observe(viewLifecycleOwner){
            checkAdapter.setData(it)
        }
    }
}