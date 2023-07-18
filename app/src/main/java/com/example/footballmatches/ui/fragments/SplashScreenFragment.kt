package com.example.footballmatches.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.footballmatches.ui.viewmodels.FootballMatchesViewModel
import com.example.footballmatches.ui.MainActivity
import com.example.footballmatches.R
import com.example.footballmatches.util.Resourse

class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {

    private lateinit var viewModel: FootballMatchesViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = (activity as MainActivity).viewModel
        val footballMatches = viewModel.footballMatches
        footballMatches.observe(this) { result ->
            if (result is Resourse.Loading && result.data.isNullOrEmpty()) {
            } else {
                findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
            }
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }
}