package com.example.ra2recetascocinaandrei.datos

data class Receta(
    val id: Int,
    val nombre: String,
    val ingredientes: List<String>,
    val categoria: String,
    val imagen: Int,
    val pasos: List<Paso>
)
