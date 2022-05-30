package com.example.adilproject.fragment.checks

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.adilproject.R
import kotlinx.android.synthetic.main.fragment_projects.*


class CheckFragment : Fragment() {

    private val viewModel by lazy{ViewModelProvider(this).get(CheckViewModel::class.java)}
    private val checkAdapter = CheckAdapter()

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        viewModel.getChecks()

        handler = Handler()

        checkSwipe.setOnRefreshListener {

            runnable = Runnable {

                setupRecycler()

                viewModel.getChecks()
                viewModel.checkLiveData.observe(viewLifecycleOwner){
                    checkAdapter.setData(it)
                }

                Toast.makeText(requireContext(), "updating" ,Toast.LENGTH_LONG).show()

                checkSwipe.isRefreshing = false
            }

            handler.postDelayed(
                runnable, 3000.toLong()
            )
        }

        checkSwipe.setColorSchemeResources(
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_red_light
        )

    }

    private fun setupRecycler() {
        checksRv.adapter = checkAdapter
        viewModel.checkLiveData.observe(viewLifecycleOwner){
            checkAdapter.setData(it)
        }
    }
}