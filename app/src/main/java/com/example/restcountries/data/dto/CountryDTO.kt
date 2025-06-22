package com.example.restcountries.data.dto

import com.google.gson.annotations.SerializedName

data class CountryDTO(

    val cca3: String,
    val cca2: String,
    val name: Name,
    val currencies: Map<String, Currency>,
    val capital: List<String>?,
    val region: String,
    val languages: Map<String, String>?,
    val flag: String,
    val flags: Flags?, // Puede venir así de la API
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

data class Flags(
    val png: String?,
    val svg: String?,
    val alt: String?
)

fun emptyCountry(): CountryDTO {
    return CountryDTO(
    cca3 = "",
    cca2="",
    name = Name("", ""),
    currencies = emptyMap(),
    capital = emptyList(),
    region = "",
    languages = emptyMap(),
    flag = "",
    flags=Flags("","",""),
    population = 0L
    )
}