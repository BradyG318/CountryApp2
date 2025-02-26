package com.example.countryapp2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.countryapp2.model.Country
import com.example.countryapp2.model.CountryList
import com.example.countryapp2.navigation.CountryScreens

@Composable
fun HomeScreen (
    navController: NavController,
    countryList: List<Country> = CountryList) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(items = countryList) {
                CountryItem(country = it) { country ->
                    navController.navigate(route = CountryScreens.InfoScreen.name + "/$country")
                }
                HorizontalDivider()
            }
        }
    }
}


@Composable
fun CountryItem(country: Country = CountryList[0], itemClick:(String) -> Unit = {}) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            itemClick(country.name)
        }) {
        Image(
            painter = painterResource(country.flag),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
        )
        Column() {
            Text("Country: " + country.name, fontSize = 20.sp)
            Text("Currency: " + country.currency, fontSize = 10.sp)
        }
    }
}
