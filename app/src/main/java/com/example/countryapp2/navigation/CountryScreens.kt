package com.example.countryapp2.navigation

enum class CountryScreens {
    HomeScreen,
    InfoScreen;
    companion object {
        fun fromRoute(route: String?): CountryScreens
            = when(route?.substringBefore("/"))
        {
                HomeScreen.name -> HomeScreen
                InfoScreen.name -> InfoScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("You broke a bunch of crap dumdum")
            }
    }
}