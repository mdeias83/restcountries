package com.example.restcountries.ui.screens.countryDetail

import com.example.restcountries.data.dto.CountryDTO

data class CountryDetailScreenState(
    val cca3 : String="",
    val countryDetail: CountryDTO = CountryDTO.emptyCountry()
    //val country
) {//FALTA IMPLEMENTAR  COUNTRLISTDTO PARA CHUPAR EL CCA3

}