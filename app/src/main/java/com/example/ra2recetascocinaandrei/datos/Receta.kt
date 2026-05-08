package com.example.ra2recetascocinaandrei.datos

data class Receta(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val dificultad: String,
    val tiempo: String,
    val ingredientes: List<String>,
    val categoria: Categoria,
    val imagen: Int,
    val pasos: List<Paso>
)