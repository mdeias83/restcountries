package com.example.restcountries.data.dto

import com.google.gson.annotations.SerializedName

//EL DTO LO VOY A USAR EN LA LISTA DONDE VOY A MOSTRAR SOLAMENTE NOMBRE REGION Y BANDERA


data class CountryItemListDTO(
    @SerializedName("cca3")
    val id: String,
    val name: NameDTO,
    val region: String,
    val flag: String
)

data class NameDTO(
    val common: String,
    val official: String
)

