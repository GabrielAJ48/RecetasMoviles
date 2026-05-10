package com.example.ra2recetascocinaandrei.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ra2recetascocinaandrei.R
import com.example.ra2recetascocinaandrei.modelo.Categoria
import com.example.ra2recetascocinaandrei.modelo.Paso
import com.example.ra2recetascocinaandrei.modelo.Receta
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListaRecetasViewModel : ViewModel(){

    private val recetasPrueba = listOf(
        Receta(
            id = 1,
            nombre = "Tacos al Pastor",
            descripcion = "Auténticos tacos mexicanos con cerdo adobado.",
            dificultad = "Media",
            tiempo = "45 min",
            ingredientes = listOf("Carne de cerdo", "Tortillas de maíz", "Piña", "Cilantro"),
            categoria = Categoria.MEXICANO,
            imagen = R.drawable.tacos_pastor,
            pasos = listOf(
                Paso(
                    nombre = "Marinar",
                    orden = 1,
                    imagen = R.drawable.marinar,
                    descripcion = "Marinar la carne con el adobo durante 2 horas."
                ),
                Paso(
                    nombre = "Cocinar",
                    orden = 2,
                    imagen = R.drawable.cocinar_pastor,
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
            imagen = R.drawable.hamburguesa,
            pasos = listOf(
                Paso(
                    nombre = "Preparar",
                    orden = 1,
                    imagen = R.drawable.hamburguesa_preparar,
                    descripcion = "Darle forma a la carne picada y salpimentar."
                ),
                Paso(
                    nombre = "Plancha",
                    orden = 2,
                    imagen = R.drawable.plancha_hamburguesa,
                    descripcion = "Cocinar en sartén y montar en el pan con el queso."
                )
            )
        ),
        Receta(
            id = 3,
            nombre = "Lasaña Boloñesa",
            descripcion = "Capas de pasta con salsa de carne, bechamel y queso fundido.",
            dificultad = "Media",
            tiempo = "1h 15min",
            ingredientes = listOf("Placas de pasta", "Carne picada", "Tomate", "Bechamel", "Queso Parmesano"),
            categoria = Categoria.ITALIANO,
            imagen = R.drawable.lasa_a,
            pasos = listOf(
                Paso("Salsa", 1, R.drawable.salsa_lasa_a, "Cocinar la carne con el tomate y especias."),
                Paso("Montaje", 2, R.drawable.montaje_lasa_a, "Intercalar capas de pasta, carne y bechamel."),
                Paso("Hornear", 3, R.drawable.horno_lasa_a, "Gratinar con queso hasta que esté dorado.")
            )
        ),
        Receta(
            id = 4,
            nombre = "Ramen de Pollo",
            descripcion = "Sopa japonesa reconfortante con fideos, pollo y huevo marinado.",
            dificultad = "Difícil",
            tiempo = "2h",
            ingredientes = listOf("Fideos Ramen", "Caldo de pollo", "Huevo", "Cebolleta", "Soja"),
            categoria = Categoria.JAPONES,
            imagen = R.drawable.ramen_de_pollo,
            pasos = listOf(
                Paso("Caldo", 1, R.drawable.caldo_ramne, "Preparar un caldo intenso con pollo y jengibre."),
                Paso("Fideos", 2, R.drawable.fideos_ramen, "Cocer los fideos por separado."),
                Paso("Servir", 3, R.drawable.servir_ramen, "Juntar todo en un bol y añadir el huevo encima.")
            )
        ),
        Receta(
            id = 5,
            nombre = "Tortilla de Patata",
            descripcion = "El clásico de la cocina española con huevos y patatas seleccionadas.",
            dificultad = "Media",
            tiempo = "30 min",
            ingredientes = listOf("Patatas", "Huevos", "Cebolla", "Aceite de Oliva", "Sal"),
            categoria = Categoria.ESPANIOL,
            imagen = R.drawable.tortilla_espa_ola,
            pasos = listOf(
                Paso("Freír", 1, R.drawable.freir_tortilla, "Cortar y freír las patatas y la cebolla lentamente."),
                Paso("Mezclar", 2, R.drawable.mezcla_de_tortilla_de_patatas, "Batir los huevos y juntar con las patatas escurridas."),
                Paso("Cuajar", 3, R.drawable.cuajar_tortilla, "Cocinar en la sartén por ambos lados.")
            )
        ),
        Receta(
            id = 6,
            nombre = "Enchiladas Verdes",
            descripcion = "Tortillas de maíz rellenas de pollo y bañadas en salsa verde.",
            dificultad = "Media",
            tiempo = "40 min",
            ingredientes = listOf("Tortillas", "Pollo deshebrado", "Tomatillos verdes", "Chile", "Queso"),
            categoria = Categoria.MEXICANO,
            imagen = R.drawable.enchiladas_verdes,
            pasos = listOf(
                Paso("Salsa", 1, R.drawable.salsa_enchiladas, "Cocer y licuar los tomatillos con chiles."),
                Paso("Rellenar", 2, R.drawable.enrollar_enchiladas, "Enrollar el pollo en las tortillas."),
                Paso("Bañar", 3, R.drawable.ba_ar_enchiladas, "Cubrir con salsa y queso y calentar.")
            )
        ),
        Receta(
            id = 7,
            nombre = "Alitas Buffalo",
            descripcion = "Alitas de pollo crujientes bañadas en salsa picante y mantequilla.",
            dificultad = "Fácil",
            tiempo = "25 min",
            ingredientes = listOf("Alitas de pollo", "Salsa picante", "Mantequilla", "Ajo en polvo", "Sal"),
            categoria = Categoria.AMERICANO,
            imagen = R.drawable.alitas_buffalo,
            pasos = listOf(
                Paso("Freír", 1, R.drawable.freir_alitas, "Freír las alitas hasta que estén crujientes."),
                Paso("Salsa", 2, R.drawable.salsa_bufalo, "Derretir mantequilla con la salsa picante."),
                Paso("Mezclar", 3, R.drawable.mezlcar_alitas, "Bañar las alitas en la mezcla caliente.")
            )
        )
    )

    private val _recetas = MutableStateFlow(recetasPrueba)
    val recetas: StateFlow<List<Receta>> = _recetas.asStateFlow()

    fun obtenerRecetaPorId(recetaId: Int): Receta? {
        return recetasPrueba.find { it.id == recetaId }
    }

    fun filtrarPorCategoria(categoria: Categoria) {
        if (categoria == Categoria.TODAS) {
            _recetas.value = recetasPrueba
        } else {
            _recetas.value = recetasPrueba.filter { it.categoria == categoria }
        }
    }
}