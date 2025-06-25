package com.example.restcountries.data.local

import android.content.Context

object CountryDatabaseProvider {

    lateinit var dbLocal: CountryDatabase
        private set

    fun createDatabase(context: Context) {
        dbLocal = CountryDatabase.getInstance(context)
    }
}