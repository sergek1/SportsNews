package com.example.footballmatches.repository.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "football_matches")
data class FootballMatch(
    @PrimaryKey
    val match_id: String,
    val match_date: String,
    val match_hometeam_name: String,
    val match_hometeam_score: String,
    val match_awayteam_name: String,
    val match_awayteam_score: String,
    val team_home_badge: String,
    val team_away_badge: String,
    val country_logo: String,
    val country_name: String
)
