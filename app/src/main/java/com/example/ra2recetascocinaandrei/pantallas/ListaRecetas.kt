package com.example.ra2recetascocinaandrei.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ra2recetascocinaandrei.datos.Receta
import com.example.ra2recetascocinaandrei.fuentes.Fuentes
import com.example.ra2recetascocinaandrei.viewmodel.ListaRecetasViewModel

@Composable
fun ListaRecetas(
    viewModel: ListaRecetasViewModel,
    onRecetaClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val recetas by viewModel.recetas.collectAsState()

    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {

        Text(
            text = "Recetas del mundo",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Fuentes.Poppins,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(recetas) { receta ->
                TarjetaReceta(receta = receta, onClick = { onRecetaClick(receta.id) })
            }
        }
    }
}

@Composable
fun TarjetaReceta(receta: Receta, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = receta.imagen),
                contentDescription = "Imagen de ${receta.nombre}",
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = receta.nombre,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Fuentes.Poppins,
                    fontSize = 18.sp
                )
                Text(text = "Dificultad: ${receta.dificultad}", fontFamily = Fuentes.Poppins)
                Text(text = "Tiempo: ${receta.tiempo}", fontFamily = Fuentes.Poppins)
                Text(text = "Categoría: ${receta.categoria.nombre}", fontFamily = Fuentes.Poppins, color = androidx.compose.ui.graphics.Color.Gray)
            }
        }
    }
}