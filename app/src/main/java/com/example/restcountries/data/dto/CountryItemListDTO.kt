package com.example.restcountries.data.dto
//EL DTO LO VOY A USAR EN LA LISTA DONDE VOY A MOSTRAR SOLAMENTE NOMBRE REGION Y BANDERA


data class CountryItemListDTO(
    val cca3: String,
    val name: NameDTO,
    val region: String,
    val flag: String
)

data class NameDTO(
    val common: String,
    val official: String
)

