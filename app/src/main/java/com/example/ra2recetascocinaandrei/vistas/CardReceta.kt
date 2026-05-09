package com.example.ra2recetascocinaandrei.vistas

import android.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ra2recetascocinaandrei.modelo.Receta
import com.example.ra2recetascocinaandrei.fuentes.Fuentes


@Composable
fun TarjetaRecetas(receta: Receta, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = BorderStroke(1.dp, Color(0xFFF3E5D8))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.size(90.dp)
            ) {
                Image(
                    painter = painterResource(id = receta.imagen),
                    contentDescription = "Imagen de ${receta.nombre}",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = receta.nombre,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    fontSize = 18.sp,
                    color = Color(0xFF954A05)
                )
                Text(
                    text = "Dificultad: ${receta.dificultad}",
                    fontFamily = Fuentes.Poppins,
                    fontSize = 13.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = "Tiempo: ${receta.tiempo}",
                    fontFamily = Fuentes.Poppins,
                    fontSize = 13.sp,
                    color = Color.DarkGray
                )
                Surface(
                    color = Color(0xFFFFF4E6),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text(
                        text = receta.categoria.nombre,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                        fontSize = 11.sp,
                        fontFamily = Fuentes.Poppins,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF954A05)
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TarjetaReceta() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_menu_edit),
                contentDescription = "Imagen de receta}",
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "receta",
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    fontSize = 18.sp
                )
                Text(text = "Dificultad: 1", fontFamily = Fuentes.Poppins)
                Text(text = "Tiempo: 50 mins", fontFamily = Fuentes.Poppins)
                Text(text = "Categoría: Mexicano", fontFamily = Fuentes.Poppins, color = androidx.compose.ui.graphics.Color.Gray)
            }
        }
    }
}

