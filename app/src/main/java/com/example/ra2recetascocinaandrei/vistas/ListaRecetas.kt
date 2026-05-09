package com.example.ra2recetascocinaandrei.vistas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.fromColorLong
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ra2recetascocinaandrei.fuentes.Fuentes
import com.example.ra2recetascocinaandrei.modelo.Categoria
import com.example.ra2recetascocinaandrei.viewmodel.ListaRecetasViewModel

@Composable
fun ListaRecetas(
    viewModel: ListaRecetasViewModel,
    onRecetaClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val recetas by viewModel.recetas.collectAsState()

    var categoriaSeleccionada by remember { mutableStateOf(Categoria.TODAS) }

    Column(
        modifier = modifier.
        fillMaxSize().
        padding(16.dp).
        background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .border(
                    border = BorderStroke(2.dp, Color(0xFF954A05)),
                    shape = RoundedCornerShape(16.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Recetas del mundo",
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = Fuentes.Poppins,
                textAlign = TextAlign.Center,
                color = Color(0xFF954A05),
                modifier = Modifier.padding(16.dp)
            )
        }

        Text(
            text = "Categorías",
            fontFamily = Fuentes.Poppins,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp),
            color = Color(0xFF954A05)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            items(Categoria.values()) { categoria ->
                FilterChip(
                    selected = categoria == categoriaSeleccionada,
                    onClick = {
                        categoriaSeleccionada = categoria
                        viewModel.filtrarPorCategoria(categoria)
                    },
                    label = { 
                        Text(text = categoria.nombre, 
                            fontFamily = Fuentes.Poppins
                        ) 
                            },
                    shape = RoundedCornerShape(50.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White,
                        labelColor = Color(0xFF954A05),
                        selectedContainerColor = Color(0xFF954A05),
                        selectedLabelColor = Color.White
                    ),
                    border = FilterChipDefaults.filterChipBorder(
                        enabled = true,
                        selected = categoria == categoriaSeleccionada,
                        borderColor = Color(0xFF954A05),
                        selectedBorderColor = Color(0xFF954A05),
                        borderWidth = 1.dp
                    )
                )
            }
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(recetas) { receta ->
                TarjetaRecetas (receta = receta, onClick = { onRecetaClick(receta.id) })
            }
        }
    }
}