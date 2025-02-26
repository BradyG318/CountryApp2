package com.example.countryapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.countryapp2.navigation.CountryNavigation
import com.example.countryapp2.ui.theme.CountryApp2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting {
                CountryNavigation()
            }
        }
    }
}

@Composable
fun Greeting(content: @Composable () -> Unit) {
    CountryApp2Theme() {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting() {
        CountryNavigation()
    }
}