package com.example.footballmatches.repository

import androidx.room.withTransaction
import com.example.footballmatches.repository.api.FootballApi
import com.example.footballmatches.repository.database.FootballMatchesDatabase
import com.example.footballmatches.util.networkBoundResourse
import kotlinx.coroutines.delay
import javax.inject.Inject

class FootballMatchRepository @Inject constructor(
    private val api: FootballApi,
    private val db: FootballMatchesDatabase
) {
    private val footballMatchesDao =
        db.footballMatchDao()

    fun getFootballMatches() = networkBoundResourse(
        query = {
            footballMatchesDao.getAllMatches()
        },
        fetch = {
            delay(2000)
            api.getFootballMatches()
        },
        saveFetchResult = { footballMatches ->
            db.withTransaction {
                footballMatchesDao.deleteAllMatches()
                footballMatchesDao.insertFootballMatches(footballMatches)
            }
        }
    )

}