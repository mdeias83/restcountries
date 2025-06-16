import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.restcountries.data.Country
import com.example.restcountries.ui.screens.commons.CountryUIItem

@Composable
fun CountryUIList(countryList: List<Country>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 8.dp), // Padding general
        verticalArrangement = Arrangement.spacedBy(12.dp), // Espacio entre cards
        horizontalAlignment = Alignment.CenterHorizontally // Centra todo horizontalmente
    ) {
        items(countryList) { country ->
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.92f) // Opcional: hace que la card no toque el borde
                    .fillMaxWidth(0.92f),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                CountryUIItem(country)
            }
        }
    }
}