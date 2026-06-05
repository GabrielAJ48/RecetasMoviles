package com.example.ra2recetascocinaandrei.navegacion

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ra2recetascocinaandrei.vistas.ListaRecetas
import com.example.ra2recetascocinaandrei.vistas.Login
import com.example.ra2recetascocinaandrei.viewmodel.ListaRecetasViewModel
import com.example.ra2recetascocinaandrei.vistas.DetalleReceta

@Composable
fun NavigationController() {
    val navController = rememberNavController()

    val listaRecetasViewModel: ListaRecetasViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Login.route) {

        composable (route = Screen.Login.route) {
            Login (
                onLoginCorrecto = {
                    navController.navigate(Screen.ListaRecetas.route)
                }
            )
        }

        composable(route = Screen.ListaRecetas.route) {
            ListaRecetas(
                viewModel = listaRecetasViewModel,
                onRecetaClick = { recetaClickada ->
                    navController.navigate(Screen.DetalleReceta.createRoute(recetaClickada))
                }
            )
        }

        composable(
            route = Screen.DetalleReceta.route,
            arguments = listOf(
                navArgument("recetaId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("recetaId") ?: 0
            val receta = listaRecetasViewModel.obtenerRecetaPorId(id)
            if (receta != null)
                DetalleReceta(navController, receta)
        }

    }
}