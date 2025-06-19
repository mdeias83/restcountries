package com.example.restcountries.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import com.example.restcountries.ui.screens.Screens

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    // Navegar luego de 2.5s
    LaunchedEffect(Unit) {
        delay(2500)
        navController.navigate(Screens.CountryList.route) {
            popUpTo("splash") { inclusive = true }  //EVITA VOLVER ATRAS, SOLO EN EL SPLASH
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFD8B4FE), // lavanda claro
                        Color(0xFF81E6D9)  // verde menta
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Título decorativo
            Text(
                text = "RestCountries",
                fontSize = 34.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Imagen del mundo con marcador
            AsyncImage(
                model = "https://cdn-icons-png.flaticon.com/512/535/535239.png", // Cambialo si tenés uno mejor
                contentDescription = "Logo del mundo",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
        }
    }
}