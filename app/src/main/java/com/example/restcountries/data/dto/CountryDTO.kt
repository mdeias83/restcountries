package com.example.restcountries.data.dto

import com.google.gson.annotations.SerializedName

data class CountryDTO(
    @SerializedName("cca3")
    val id: String,
    val name: Name,
    val currencies: Map<String, Currency>,
    val capital: List<String>?,
    val region: String,
    val languages: Map<String, String>?,
    val flag: String,
    val population: Long
)

data class Name(
    val common: String,
    val official: String
)

data class Currency(
    val name: String,
    val symbol: String
)