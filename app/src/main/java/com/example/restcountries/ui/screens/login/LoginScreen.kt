
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.restcountries.ui.screens.login.LoginScreenViewModel
import com.example.restcountries.ui.screens.Screens


@Composable
fun LoginScreen(
    onGoogleLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    vm : LoginScreenViewModel = viewModel()
) {
    LaunchedEffect(Unit) {
        vm.uiEvent.collect {
            event ->
                navController.navigate(Screens.CountryList.route){
                    popUpTo(Screens.Login.route) { inclusive = true}
                }
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
            Spacer(modifier = Modifier.height(32.dp))

            // Botón de Google
            Button(
                onClick = onGoogleLoginClick,
                shape = RoundedCornerShape(24.dp),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                // Icono de Google (opcional)
                /*Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Icon",
                    tint = Color.Unspecified
                )*/
                Text(
                    text = "Login con Google",
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
        }

    }

}

