package com.sergio.bootcampfinalproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.sergio.bootcampfinalproject.app.TravelEarnerApp
import com.sergio.bootcampfinalproject.ui.theme.BgColor
import com.sergio.bootcampfinalproject.ui.theme.BootCampFinalProjectTheme
import com.sergio.bootcampfinalproject.ui.theme.GrayColor
import com.sergio.bootcampfinalproject.ui.theme.Primary
import com.sergio.bootcampfinalproject.ui.theme.Secondary
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
                TravelEarnerApp()
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
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()){


            //Footer Divider
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    color = GrayColor,
                    thickness = 1.dp
                )

                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "or",
                    fontSize = 18.sp,
                    color = TextColor,
                )

                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        color = GrayColor,
                        thickness = 1.dp
                    )
            }
            //End Footer Divider

            //Already hava an account
            ClickableLoginTextComponent(onTextSelected = {
            })
            //end of already have an account
        }
    }

}

@Composable
fun ClickableLoginTextComponent(onTextSelected: (String) -> Unit) {
    val initialText = "Already have an account? "
    val loginText = "Login"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(
            style = SpanStyle(color = Primary)
        ){
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
        ),
        text = annotatedString,
        onClick={
        offset -> annotatedString.getStringAnnotations(offset, offset)
        .firstOrNull()?.also{span ->
            Log.d("Clickable Login Text Component", "{${span.item}}")
            if(span.item == loginText){
                onTextSelected(span.item)
            }
        }
    })
}