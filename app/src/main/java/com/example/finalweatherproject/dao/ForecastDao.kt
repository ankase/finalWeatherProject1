package com.example.finalweatherproject.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.finalweatherproject.entity.ForecastEntity

@Dao
interface ForecastDao {
    @Query("SELECT * FROM Forecast")
    fun getForecast(): List<ForecastEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<ForecastEntity>)

}