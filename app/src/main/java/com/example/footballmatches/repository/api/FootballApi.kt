package com.example.footballmatches.repository.api

import com.example.footballmatches.repository.models.FootballMatch
import com.example.footballmatches.util.Constants.Companion.API_KEY
import com.example.footballmatches.util.Constants.Companion.BASE_URL
import retrofit2.http.GET

interface FootballApi {
    @GET("$BASE_URL?action=get_events&from=2022-04-05&to=2023-04-05&league_id=152&APIkey=$API_KEY")
    suspend fun getFootballMatches():List<FootballMatch>
}