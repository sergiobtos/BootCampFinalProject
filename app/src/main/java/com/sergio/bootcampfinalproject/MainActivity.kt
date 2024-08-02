package com.sergio.bootcampfinalproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.sergio.bootcampfinalproject.ui.theme.BgColor
import com.sergio.bootcampfinalproject.ui.theme.BootCampFinalProjectTheme
import com.sergio.bootcampfinalproject.ui.theme.GrayColor
import com.sergio.bootcampfinalproject.ui.theme.Primary
import com.sergio.bootcampfinalproject.ui.theme.TextColor
import java.time.LocalDate

data class Advertisement(
    val destinationCountry: String,
    val adDescription: String,
    val price: Double,
    val tripDate: LocalDate
)

class ProjectViewModel : ViewModel() {
    var ads by mutableStateOf(mutableListOf<Advertisement>())
        private set

    fun addAdvertisement(ad: Advertisement) {
        ads.add(ad)
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BootCampFinalProjectTheme{
                MyApp()
            }
        }
    }
}

@Preview
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val viewModel: ProjectViewModel = viewModel()
    BootCampFinalProjectTheme {
        SignUpScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {
    var firstNameInput by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()){
            //First Title
            Text(
                text = "Hey there,",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 40.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                color = TextColor,
                textAlign = TextAlign.Center
            )
            //Second Title
            Text(
                text = "Create an account",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(),
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal
                ),
                color = TextColor,
                textAlign = TextAlign.Center
            )

            //FirstName Input
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BgColor),
                label = { Text(text="First Name") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Primary,
                    focusedLabelColor = Primary,
                    cursorColor = Primary,
                ),
                keyboardOptions = KeyboardOptions.Default,
                value = firstNameInput,
                onValueChange = { newValue ->
                    firstNameInput = newValue
                }
            )

        }

    }

}

