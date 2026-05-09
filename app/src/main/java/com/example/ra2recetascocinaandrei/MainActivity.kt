package com.example.ra2recetascocinaandrei

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ra2recetascocinaandrei.ui.theme.RA2RecetasCocinaAndreiTheme
import com.example.ra2recetascocinaandrei.navegacion.NavigationController

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RA2RecetasCocinaAndreiTheme {
                NavigationController()
                }
            }
        }
    }



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    RA2RecetasCocinaAndreiTheme {

    }
}