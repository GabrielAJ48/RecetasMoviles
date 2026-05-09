package com.example.ra2recetascocinaandrei.vistas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ra2recetascocinaandrei.fuentes.Fuentes
import com.example.ra2recetascocinaandrei.modelo.Receta
import com.example.ra2recetascocinaandrei.R
import com.example.ra2recetascocinaandrei.modelo.Paso


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleReceta(navController: NavController, receta: Receta) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(receta.nombre) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "Atrás")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
                .padding(horizontal = 16.dp)
        ) {
            item {
                Text(
                    text = receta.nombre,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = Fuentes.Poppins,
                    color = Color(0xFF954A05),
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Card(
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.fillMaxWidth().height(250.dp).padding(vertical = 8.dp),
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
                    // Categoría
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Categoría",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF954A05),
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
                    // Dificultad
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Dificultad",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF954A05),
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
                    // Tiempo
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Tiempo",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF954A05),
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
                    color = Color(0xFF954A05),
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
                    color = Color(0xFF954A05),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            items(receta.ingredientes) { ingrediente ->
                Row(modifier = Modifier.padding(vertical = 4.dp)) {
                    Text(text = "•", color = Color(0xFF954A05), fontWeight = FontWeight.Bold)
                    Spacer(Modifier.width(8.dp))
                    Text(text = ingrediente, fontFamily = Fuentes.Poppins, fontSize = 15.sp)
                }
            }
            item {
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Pasos a seguir",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    color = Color(0xFF954A05),
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
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFDFDFD)),
        border = BorderStroke(1.dp, Color(0xFFF3E5D8))
    ){
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = "${paso.orden}. ${paso.nombre}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Fuentes.Poppins,
            color = Color(0xFF954A05)
        )
        Spacer(Modifier.height(8.dp))
        Card(shape = RoundedCornerShape(12.dp)) {
            Image(
                painter = painterResource(id = paso.imagen),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(180.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text = paso.descripcion,
            fontSize = 14.sp,
            fontFamily = Fuentes.Poppins,
            color = Color.Black,
            textAlign = TextAlign.Justify
        )
    }
        }
}

val listaIngredinetes = listOf("Carne de cerdo", "Tortillas de maíz", "Piña", "Cilantro", "Carne de cerdo", "Tortillas de maíz", "Piña", "Cilantro")


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun detalleReceta() {
    Column(modifier = Modifier.fillMaxSize()) {
            Column() {
                Text(
                    text = "Tacos al pastor",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Imagen de comida"
                )
                Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                    Text(
                        text = "Categoría: Mexicano",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Fuentes.Poppins,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.padding(start=5.dp)
                    )
                    Spacer(modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp))
                    Text(
                        text = "Dificultad: Medio",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Fuentes.Poppins,
                        textAlign = TextAlign.Left,
                    )
                    Spacer(modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp))
                    Text(
                        text = "Tiempo: 1h",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Fuentes.Poppins,
                        textAlign = TextAlign.Left,
                    )
                }
                Text(
                    text = "Descripción",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
                )
                Text(
                    text = "Los tacos al pastor son un platillo icónico mexicano compuesto por finas láminas de carne de cerdo adobada, cocinadas lentamente en un asador vertical giratorio llamado \"trompo\". Se sirven en tortillas de maíz pequeñas con cebolla, cilantro, piña asada, salsa y limón, ofreciendo una mezcla única de sabores ahumados, dulces y especiados.",
                    fontSize = 7.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 70.dp)
                )
                Text(
                    text = "Ingredientes",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp)
                )
                LazyVerticalGrid (columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
                    items(listaIngredinetes) {
                            ingrediente -> Text(text = "*"+ingrediente)
                    }
                }
                Text(
                    text = "Instrucciones",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp)
                )
                PasoDetalle()
                PasoDetalle()
                PasoDetalle()
            }
        }
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PasoDetalle(){
    Column() {
        Text(
            text = "1. Cocinar la carne",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Fuentes.Poppins,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Imagen de comida"
        )
        Text(
            text = "Los tacos al pastor se elaboran marinando carne de cerdo (principalmente paleta) en un adobo de chiles secos (guajillo, ancho), especias, achiote, vinagre y jugo de piña, para luego cocinarla a fuego lento. Tradicionalmente se asa en un trompo vertical bajo llamas, aunque en casa se prepara en sartén o parrilla, finalizando con piña asada, cebolla y cilantro. ",
            fontSize = 7.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Fuentes.Poppins,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 70.dp)
        )
    }

}
