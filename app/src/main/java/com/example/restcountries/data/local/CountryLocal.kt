package com.example.restcountries.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.restcountries.data.dto.Currency
import com.example.restcountries.data.dto.Flags
import com.example.restcountries.data.dto.Name

@Entity("countries")
data class CountryLocal(
    @PrimaryKey
    val cca3: String="",
    val cca2: String="",
    val commonName: String="",
    val officialName: String="",
    val currencies: String="", // serializado como JSON o texto plano
    val capital: String="",    // primer capital (o vacío)
    val region: String="",
    val languages: String="",  // serializado como JSON o texto plano
    val flagEmoji: String="",
    val flagUrl: String="",
    val population: Long=0
)
{
}