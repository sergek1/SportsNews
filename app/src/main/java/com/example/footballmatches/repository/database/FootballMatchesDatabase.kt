package com.example.footballmatches.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footballmatches.repository.database.FootballMatchesDao
import com.example.footballmatches.repository.models.FootballMatch

@Database(entities = [FootballMatch::class], version = 1)
abstract class FootballMatchesDatabase:RoomDatabase() {
    abstract fun footballMatchDao(): FootballMatchesDao
}