package com.example.ra2recetascocinaandrei

import android.annotation.SuppressLint
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
import com.example.ra2recetascocinaandrei.pantallas.MostrarRecetas
import com.example.ra2recetascocinaandrei.ui.theme.RA2RecetasCocinaAndreiTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RA2RecetasCocinaAndreiTheme {
                MostrarRecetas()
                }
            }
        }
    }



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    RA2RecetasCocinaAndreiTheme {
       MostrarRecetas()
    }
}