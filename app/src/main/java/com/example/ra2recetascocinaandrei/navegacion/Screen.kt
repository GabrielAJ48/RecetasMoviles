package com.example.ra2recetascocinaandrei.navegacion

sealed class Screen(val route: String) {
    object ListaRecetas : Screen("listaRecetas")

    object DetalleReceta : Screen("detallereceta/{recetaId}") {
        fun createRoute(recetaId: Int) = "detallereceta/$recetaId"
    }
}