package com.example.ra2recetascocinaandrei.pantallas

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.ra2recetascocinaandrei.fuentes.Fuentes


@Composable
fun MostrarRecetas(modifier: Modifier = Modifier){

    LazyColumn (modifier.fillMaxSize()){
        item {
            Text(text = "Recetas del mundo",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Fuentes.Poppins,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth())
        }
    }
}