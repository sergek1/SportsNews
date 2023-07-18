package com.example.footballmatches.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballmatches.repository.models.FootballMatch
import com.example.footballmatches.repository.FootballMatchRepository
import com.example.footballmatches.util.Resourse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FootballMatchesViewModel @Inject constructor(
    repository: FootballMatchRepository
) : ViewModel() {
    var footballMatches: LiveData<Resourse<List<FootballMatch>>>

    init {
        footballMatches = repository.getFootballMatches().asLiveData()
    }
}