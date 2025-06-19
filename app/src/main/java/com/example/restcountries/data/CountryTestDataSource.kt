package com.example.restcountries.data

import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.delay

class CountryTestDataSource: ICountryDataSource  {


    //TEST DATA SOURCE
    override suspend fun getCountryList(search: String) : List<Country>{

        delay(5000)
        val gson = Gson()
        val countryList = gson.fromJson(json, Array<Country>::class.java).toList()
        Log.d("GSONDATANAME", countryList[0].name.common)
        return countryList
    }



    var json = """
    [
      {
        "name": {
          "common": "Togo",
          "official": "Togolese Republic",
          "nativeName": {
            "fra": {
              "official": "République togolaise",
              "common": "Togo"
            }
          }
        },
        "cca3": "TGO",
        "currencies": {
          "XOF": {
            "name": "West African CFA franc",
            "symbol": "Fr"
          }
        },
        "capital": [
          "Lomé"
        ],
        "region": "Africa",
        "languages": {
          "fra": "French"
        },
        "flag": "🇹🇬",
        "population": 8278737
      },
      {
        "name": {
          "common": "Georgia",
          "official": "Georgia",
          "nativeName": {
            "kat": {
              "official": "საქართველო",
              "common": "საქართველო"
            }
          }
        },
        "cca3": "GEO",
        "currencies": {
          "GEL": {
            "name": "lari",
            "symbol": "₾"
          }
        },
        "capital": [
          "Tbilisi"
        ],
        "region": "Asia",
        "languages": {
          "kat": "Georgian"
        },
        "flag": "🇬🇪",
        "population": 3714000
      },
      {
        "name": {
          "common": "Vanuatu",
          "official": "Republic of Vanuatu",
          "nativeName": {
            "bis": {
              "official": "Ripablik blong Vanuatu",
              "common": "Vanuatu"
            },
            "eng": {
              "official": "Republic of Vanuatu",
              "common": "Vanuatu"
            },
            "fra": {
              "official": "République de Vanuatu",
              "common": "Vanuatu"
            }
          }
        },
        "cca3": "VUT",
        "currencies": {
          "VUV": {
            "name": "Vanuatu vatu",
            "symbol": "Vt"
          }
        },
        "capital": [
          "Port Vila"
        ],
        "region": "Oceania",
        "languages": {
          "bis": "Bislama",
          "eng": "English",
          "fra": "French"
        },
        "flag": "🇻🇺",
        "population": 307150
      },
      {
        "name": {
          "common": "Kyrgyzstan",
          "official": "Kyrgyz Republic",
          "nativeName": {
            "kir": {
              "official": "Кыргыз Республикасы",
              "common": "Кыргызстан"
            },
            "rus": {
              "official": "Кыргызская Республика",
              "common": "Киргизия"
            }
          }
        },
        "cca3": "KGZ",
        "currencies": {
          "KGS": {
            "name": "Kyrgyzstani som",
            "symbol": "с"
          }
        },
        "capital": [
          "Bishkek"
        ],
        "region": "Asia",
        "languages": {
          "kir": "Kyrgyz",
          "rus": "Russian"
        },
        "flag": "🇰🇬",
        "population": 6591600
      },
      {
        "name": {
          "common": "Niger",
          "official": "Republic of Niger",
          "nativeName": {
            "fra": {
              "official": "République du Niger",
              "common": "Niger"
            }
          }
        },
        "cca3": "NER",
        "currencies": {
          "XOF": {
            "name": "West African CFA franc",
            "symbol": "Fr"
          }
        },
        "capital": [
          "Niamey"
        ],
        "region": "Africa",
        "languages": {
          "fra": "French"
        },
        "flag": "🇳🇪",
        "population": 24206636
      },
      {
        "name": {
          "common": "China",
          "official": "People's Republic of China",
          "nativeName": {
            "zho": {
              "official": "中华人民共和国",
              "common": "中国"
            }
          }
        },
        "cca3": "CHN",
        "currencies": {
          "CNY": {
            "name": "Chinese yuan",
            "symbol": "¥"
          }
        },
        "capital": [
          "Beijing"
        ],
        "region": "Asia",
        "languages": {
          "zho": "Chinese"
        },
        "flag": "🇨🇳",
        "population": 1402112000
      },
      {
        "name": {
          "common": "Tuvalu",
          "official": "Tuvalu",
          "nativeName": {
            "eng": {
              "official": "Tuvalu",
              "common": "Tuvalu"
            },
            "tvl": {
              "official": "Tuvalu",
              "common": "Tuvalu"
            }
          }
        },
        "cca3": "TUV",
        "currencies": {
          "AUD": {
            "name": "Australian dollar",
            "symbol": "${'$'}"
          },
          "TVD": {
            "name": "Tuvaluan dollar",
            "symbol": "${'$'}"
          }
        },
        "capital": [
          "Funafuti"
        ],
        "region": "Oceania",
        "languages": {
          "eng": "English",
          "tvl": "Tuvaluan"
        },
        "flag": "🇹🇻",
        "population": 11792
      },
      {
        "name": {
          "common": "Comoros",
          "official": "Union of the Comoros",
          "nativeName": {
            "ara": {
              "official": "الاتحاد القمري",
              "common": "القمر‎"
            },
            "fra": {
              "official": "Union des Comores",
              "common": "Comores"
            },
            "zdj": {
              "official": "Udzima wa Komori",
              "common": "Komori"
            }
          }
        },
        "cca3": "COM",
        "currencies": {
          "KMF": {
            "name": "Comorian franc",
            "symbol": "Fr"
          }
        },
        "capital": [
          "Moroni"
        ],
        "region": "Africa",
        "languages": {
          "ara": "Arabic",
          "fra": "French",
          "zdj": "Comorian"
        },
        "flag": "🇰🇲",
        "population": 869595
      },
      {
        "name": {
          "common": "Bosnia and Herzegovina",
          "official": "Bosnia and Herzegovina",
          "nativeName": {
            "bos": {
              "official": "Bosna i Hercegovina",
              "common": "Bosna i Hercegovina"
            },
            "hrv": {
              "official": "Bosna i Hercegovina",
              "common": "Bosna i Hercegovina"
            },
            "srp": {
              "official": "Босна и Херцеговина",
              "common": "Босна и Херцеговина"
            }
          }
        },
        "cca3": "BIH",
        "currencies": {
          "BAM": {
            "name": "Bosnia and Herzegovina convertible mark",
            "symbol": "KM"
          }
        },
        "capital": [
          "Sarajevo"
        ],
        "region": "Europe",
        "languages": {
          "bos": "Bosnian",
          "hrv": "Croatian",
          "srp": "Serbian"
        },
        "flag": "🇧🇦",
        "population": 3280815
      }
      
    ]
""".trimIndent()


}