package com.example.restcountries.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
/*
interface ICountriesDao {
    @Query("SELECT * FROM countries")
    suspend fun getAll(): List<CountryLocal>
    @Query("SELECT * FROM countries WHERE cca3 = :cca3 LIMIT 1")

    suspend fun findByCca3(cca3: String): CountryLocal
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg  country: CountryLocal)
    @Delete
    suspend fun delete(country: CountryLocal)

}*/