package com.example.footballmatches.repository.database

import androidx.room.*
import com.example.footballmatches.repository.models.FootballMatch
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballMatchesDao {
    @Query("SELECT * FROM football_matches")
    fun getAllMatches(): Flow<List<FootballMatch>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFootballMatches(footballMatches: List<FootballMatch>)

    @Query("DELETE FROM football_matches")
    suspend fun deleteAllMatches()
}