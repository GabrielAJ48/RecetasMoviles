package com.example.ra2recetascocinaandrei.vistas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ra2recetascocinaandrei.fuentes.Fuentes
import com.example.ra2recetascocinaandrei.modelo.Receta
import com.example.ra2recetascocinaandrei.modelo.Paso

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleReceta(navController: NavController, receta: Receta) {
    val fondoCrema = Color(0xFFFFFDF5)
    val colorAcento = Color(0xFF954A05)

    Scaffold(
        containerColor = fondoCrema,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = receta.nombre,
                        fontFamily = Fuentes.Poppins,
                        fontWeight = FontWeight.ExtraBold,
                        color = colorAcento
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Atrás", tint = colorAcento)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = fondoCrema
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            item {
                Card(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = receta.imagen),
                        contentDescription = receta.nombre,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Categoría",
                            fontWeight = FontWeight.Bold,
                            color = colorAcento,
                            fontFamily = Fuentes.Poppins,
                            fontSize = 12.sp
                        )
                        Text(
                            text = receta.categoria.nombre,
                            color = Color.DarkGray,
                            fontFamily = Fuentes.Poppins,
                            fontSize = 13.sp
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Dificultad",
                            fontWeight = FontWeight.Bold,
                            color = colorAcento,
                            fontFamily = Fuentes.Poppins,
                            fontSize = 12.sp
                        )
                        Text(
                            text = receta.dificultad,
                            color = Color.DarkGray,
                            fontFamily = Fuentes.Poppins,
                            fontSize = 13.sp
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Tiempo",
                            fontWeight = FontWeight.Bold,
                            color = colorAcento,
                            fontFamily = Fuentes.Poppins,
                            fontSize = 12.sp
                        )
                        Text(
                            text = receta.tiempo,
                            color = Color.DarkGray,
                            fontFamily = Fuentes.Poppins,
                            fontSize = 13.sp
                        )
                    }
                }
            }
            item {
                Text(
                    text = "Descripción",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    color = colorAcento,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = receta.descripcion,
                    fontSize = 15.sp,
                    fontFamily = Fuentes.Poppins,
                    color = Color.DarkGray,
                    lineHeight = 22.sp
                )
                Spacer(Modifier.height(20.dp))
            }
            item {
                Text(
                    text = "Ingredientes",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    color = colorAcento,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            items(receta.ingredientes) { ingrediente ->
                Row(modifier = Modifier.padding(vertical = 4.dp)) {
                    Text(text = "•", color = colorAcento, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.width(8.dp))
                    Text(text = ingrediente, fontFamily = Fuentes.Poppins, fontSize = 15.sp, color = Color.DarkGray)
                }
            }
            item {
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Pasos a seguir",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    color = colorAcento,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            items(receta.pasos) { paso ->
                PasosDetalle(paso)
            }
            item { Spacer(Modifier.height(32.dp)) }
        }
    }
}

@Composable
fun PasosDetalle(paso: Paso) {
    Card(
        modifier = Modifier.padding(vertical = 12.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White), // Blanco para contrastar
        border = BorderStroke(1.dp, Color(0xFFF3E5D8)),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) { // Cambié a un padding uniforme
            Text(
                text = "${paso.orden}. ${paso.nombre}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Fuentes.Poppins,
                color = Color(0xFF954A05)
            )
            Spacer(Modifier.height(12.dp))
            Card(shape = RoundedCornerShape(12.dp)) {
                Image(
                    painter = painterResource(id = paso.imagen),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(Modifier.height(12.dp))
            Text(
                text = paso.descripcion,
                fontSize = 14.sp,
                fontFamily = Fuentes.Poppins,
                color = Color.DarkGray,
                textAlign = TextAlign.Justify,
                lineHeight = 20.sp
            )
        }
    }
}