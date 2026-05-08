package com.example.ra2recetascocinaandrei.navegacion

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ra2recetascocinaandrei.pantallas.ListaRecetas // Añade este import
import com.example.ra2recetascocinaandrei.viewmodel.ListaRecetasViewModel

@Composable
fun NavigationController() {
    val navController = rememberNavController()

    val listaRecetasViewModel: ListaRecetasViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.ListaRecetas.route) {

        composable(route = Screen.ListaRecetas.route) {
            ListaRecetas(
                viewModel = listaRecetasViewModel,
                onRecetaClick = { idQueHanTocado ->
                    navController.navigate(Screen.DetalleReceta.createRoute(idQueHanTocado))
                }
            )
        }

        composable(
            route = Screen.DetalleReceta.route,
            arguments = listOf(
                navArgument("recetaId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val recetaId = backStackEntry.arguments?.getInt("recetaId") ?: 0
        }
    }
}