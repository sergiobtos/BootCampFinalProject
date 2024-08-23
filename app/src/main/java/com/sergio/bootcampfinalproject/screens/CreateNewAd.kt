package com.sergio.bootcampfinalproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sergio.bootcampfinalproject.RegistrationViewModel
import com.sergio.bootcampfinalproject.components.DropdownMenuField
import com.sergio.bootcampfinalproject.components.HeadingTextComponent
import com.sergio.bootcampfinalproject.navigation.SystemBackButtonHandler
import com.sergio.bootcampfinalproject.navigation.TravelEarnerAppRouter
import com.sergio.bootcampfinalproject.navigation.Screen

@Composable
fun CreateNewAd(viewModel: RegistrationViewModel) {
    var selectedCountry by remember { mutableStateOf("") }
    var items by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var tripDate by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeadingTextComponent(value = "Create New Ad")
            Spacer(modifier = Modifier.height(20.dp))

            DropdownMenuField(
                labelValue = "Trip Destination Country",
                options = arrayOf("Canada", "Brazil", "Other"),
                onOptionSelected = { selectedCountry = it }
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = items,
                onValueChange = { items = it },
                label = { Text("Items I can not carry") }
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                label = { Text("Price") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = tripDate,
                onValueChange = { tripDate = it },
                label = { Text("Trip Date") }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = { /*onAdCreated(selectedCountry, items, price, tripDate)*/ }) {
                    Text("Save")
                }
                Button(onClick = { /*onCancel() */}) {
                    Text("Cancel")
                }
            }
        }
    }

    SystemBackButtonHandler {
        TravelEarnerAppRouter.navigateTo(Screen.AvailableAdsScreen)
    }
}
