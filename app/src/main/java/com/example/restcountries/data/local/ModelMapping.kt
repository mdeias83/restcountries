import com.example.restcountries.data.dto.*
import com.example.restcountries.data.local.CountryLocal
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun CountryDTO.toLocal() = CountryLocal(
    cca3,
    cca2,
    name.common,
    name.official,
    Gson().toJson(currencies),
    capital?.firstOrNull() ?: "",
    region,
    Gson().toJson(languages),
    flag,
    flags?.png ?: "",
    population
)

fun List<CountryDTO>.toLocal() = map(CountryDTO::toLocal)

fun CountryLocal.toExternal() = CountryDTO(
    cca3,
    cca2,
    Name(commonName, officialName),
    Gson().fromJson(currencies, object : TypeToken<Map<String, Currency>>() {}.type),
    listOfNotNull(capital),
    region,
    Gson().fromJson(languages, object : TypeToken<Map<String, String>>() {}.type),
    flagEmoji,
    Flags(flagUrl, null, null),
    population
)

fun List<CountryLocal>.toExternal() = map(CountryLocal::toExternal)