package com.sergio.bootcampfinalproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sergio.bootcampfinalproject.components.AdItem
import com.sergio.bootcampfinalproject.components.DropdownMenuField
import com.sergio.bootcampfinalproject.components.HeadingTextComponent
import com.sergio.bootcampfinalproject.navigation.Screen
import com.sergio.bootcampfinalproject.navigation.SystemBackButtonHandler
import com.sergio.bootcampfinalproject.navigation.TravelEarnerAppRouter

@Composable
fun AvailableAdsScreen() {
    val countriesTo = arrayOf("All Countries", "Canada", "Brazil")
    val countriesFrom = arrayOf("All Countries", "Canada", "Brazil")

    var selectedCountryTo by remember { mutableStateOf(countriesTo[0]) }
    var selectedCountryFrom by remember { mutableStateOf(countriesFrom[0]) }

    val adsList = listOf(
        Ad("Advertiser's Name 1", "Canada", "Brazil", "Items They Can Bring", "$150"),
        Ad("Advertiser's Name 2", "Brazil", "Canada", "Items They Can Bring", "$200"),
        Ad("Advertiser's Name 3", "Brazil", "Canada", "Items They Can Bring", "$250"),
        Ad("Advertiser's Name 1", "Canada", "Brazil", "Items They Can Bring", "$150"),
        Ad("Advertiser's Name 2", "Canada", "Brazil", "Items They Can Bring", "$200"),
        Ad("Advertiser's Name 3", "Brazil", "Canada", "Items They Can Bring", "$250")
    )

    val filteredAds = adsList.filter { ad ->
        (selectedCountryFrom == "All Countries" || ad.countryFrom == selectedCountryFrom) &&
                (selectedCountryTo == "All Countries" || ad.countryTo == selectedCountryTo)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()){
            HeadingTextComponent(value = "Available Ads")
            Spacer(modifier = Modifier.height(20.dp))
            DropdownMenuField(
                labelValue = "Country From",
                options = countriesFrom,
                onOptionSelected = { selectedCountryFrom = it }
            )
            Spacer(modifier = Modifier.height(10.dp))
            DropdownMenuField(
                labelValue = "Country To",
                options = countriesTo,
                onOptionSelected = { selectedCountryTo = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(filteredAds) { ad ->
                    AdItem(
                        advertiserName = ad.advertiserName,
                        countryFrom = ad.countryFrom,
                        countryTo = ad.countryTo,
                        items = ad.items,
                        price = ad.price
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }

    SystemBackButtonHandler{
        TravelEarnerAppRouter.navigateTo(Screen.LoginScreen)
    }
}