package com.example.footballmatches.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.footballmatches.ui.viewmodels.FootballMatchesViewModel
import com.example.footballmatches.ui.MainActivity
import com.example.footballmatches.R
import com.example.footballmatches.ui.adapters.FootballMatchAdapter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewModel: FootballMatchesViewModel
    private lateinit var footballMatchAdapter: FootballMatchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        prepareRecyclerView()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.footballMatches.observe(this) { result ->
            result.data?.let {
                footballMatchAdapter.setFootballMatchList(it)
            }
        }
    }

    private fun prepareRecyclerView() {
        footballMatchAdapter = FootballMatchAdapter()
        rv_home.apply {
            adapter = footballMatchAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

}