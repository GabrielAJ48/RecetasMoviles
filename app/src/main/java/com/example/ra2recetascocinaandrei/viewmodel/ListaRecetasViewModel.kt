package com.example.ra2recetascocinaandrei.viewmodel

import android.R
import androidx.lifecycle.ViewModel
import com.example.ra2recetascocinaandrei.datos.Categoria
import com.example.ra2recetascocinaandrei.datos.Paso
import com.example.ra2recetascocinaandrei.datos.Receta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListaRecetasViewModel : ViewModel(){

    val recetasPrueba = listOf(
        Receta(
            id = 1,
            nombre = "Tacos al Pastor",
            descripcion = "Auténticos tacos mexicanos con cerdo adobado.",
            dificultad = "Media",
            tiempo = "45 min",
            ingredientes = listOf("Carne de cerdo", "Tortillas de maíz", "Piña", "Cilantro"),
            categoria = Categoria.MEXICANO,
            imagen = R.drawable.ic_menu_gallery,
            pasos = listOf(
                Paso(
                    nombre = "Marinar",
                    orden = 1,
                    imagen = R.drawable.ic_menu_edit,
                    descripcion = "Marinar la carne con el adobo durante 2 horas."
                ),
                Paso(
                    nombre = "Cocinar",
                    orden = 2,
                    imagen = R.drawable.ic_menu_agenda,
                    descripcion = "Hacer la carne a la plancha y servir en la tortilla con piña."
                )
            )
        ),
        Receta(
            id = 2,
            nombre = "Hamburguesa Clásica",
            descripcion = "Típica hamburguesa americana jugosa.",
            dificultad = "Fácil",
            tiempo = "20 min",
            ingredientes = listOf(
                "Carne de ternera",
                "Pan de hamburguesa",
                "Queso Cheddar",
                "Lechuga"
            ),
            categoria = Categoria.AMERICANO,
            imagen = R.drawable.ic_menu_gallery,
            pasos = listOf(
                Paso(
                    nombre = "Preparar",
                    orden = 1,
                    imagen = R.drawable.ic_menu_edit,
                    descripcion = "Darle forma a la carne picada y salpimentar."
                ),
                Paso(
                    nombre = "Plancha",
                    orden = 2,
                    imagen = R.drawable.ic_menu_agenda,
                    descripcion = "Cocinar en sartén y montar en el pan con el queso."
                )
            )
        )
    )

    private val _recetas = MutableStateFlow(recetasPrueba)
    val recetas: StateFlow<List<Receta>> = _recetas.asStateFlow()

    fun obtenerRecetaPorId(idQueBusco: Int): Receta? {
        return recetasPrueba.find { receta -> receta.id == idQueBusco }
    }
}