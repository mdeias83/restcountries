package com.example.restcountries.data.dto
//EL DTO LO VOY A USAR EN LA LISTA DONDE VOY A MOSTRAR SOLAMENTE NOMBRE REGION Y BANDERA


data class CountryDto(
    val name: NameDto,
    val region: String,
    val flags: FlagsDto
)

data class NameDto(
    val common: String,
    val official: String
)

data class FlagsDto(
    val png: String
)