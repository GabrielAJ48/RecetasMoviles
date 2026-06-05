package com.example.ra2recetascocinaandrei.vistas

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ra2recetascocinaandrei.fuentes.Fuentes
import com.example.ra2recetascocinaandrei.modelo.Credenciales

@Composable
fun Login (onLoginCorrecto: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var mostrarContrasena by remember {mutableStateOf(false) }
    var mensajeError by remember { mutableStateOf("") }
    val activity = LocalContext.current as Activity

    val listaCredenciales = listOf(
        Credenciales("andrei@mail.com", "1234"),
        Credenciales("luisa@mail.com","1234"),
        Credenciales("admin@admin.com","1234")
    )

    fun comprobarLogin() {
        val emailValido = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (!emailValido) {
            mensajeError = "El email no tiene un formato válido"
        } else {
            val credencialesCorrectas = listaCredenciales.any {
                it.email == email && it.contrasena == contrasena
            }

            if (!credencialesCorrectas) {
                mensajeError = "Email o contraseña incorrectos"
            } else {
                mensajeError = ""
                onLoginCorrecto()
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize(),
        ) {
        IconButton(
            onClick = { activity.finish() },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 24.dp, end = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Salir",
                tint = Color(0xFF954A05)
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "RECETAS DEL MUNDO ",
                fontFamily = Fuentes.Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 24.dp),
                color = Color(0xFF954A05)
            )

            Column(
                modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = email,
                    onValueChange = {
                        email = it
                        mensajeError=""
                                    },
                    placeholder = { Text(text = "Email", fontFamily = Fuentes.Poppins) },
                    singleLine = true
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    value = contrasena,
                    onValueChange = {
                        contrasena = it
                        mensajeError=""
                                    },
                    placeholder = { Text(text = "Contraseña", fontFamily = Fuentes.Poppins) },
                    singleLine = true,
                    trailingIcon =
                        {
                            val imagen =
                                if (mostrarContrasena) {
                                    Icons.Filled.VisibilityOff
                                } else {
                                    Icons.Filled.Visibility
                                }
                            IconButton(onClick = { mostrarContrasena = !mostrarContrasena }) {
                                Icon(
                                    imageVector = imagen,
                                    contentDescription = "mostrar contrasena"
                                )
                            }
                        },
                    visualTransformation = if (mostrarContrasena) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                )

                Button(
                    onClick = { comprobarLogin() },
                    modifier = Modifier.fillMaxWidth(),
                    shape = ButtonDefaults.shape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF954A05))
                )
                {
                    Text(
                        text = "Iniciar Sesión",
                        color = Color(0xFFFFFDF5),
                        fontFamily = Fuentes.Poppins
                    )
                }

                if (mensajeError.isNotEmpty()) {
                    Text(
                        text = mensajeError,
                        color = Color.Red,
                        modifier = Modifier.padding(top = 12.dp),
                        fontFamily = Fuentes.Poppins
                    )
                }
            }
        }
    }
}


