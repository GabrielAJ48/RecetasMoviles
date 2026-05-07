package com.example.ra2recetascocinaandrei.fuentes

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.example.ra2recetascocinaandrei.R

object Fuentes {
    private val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )

    val Poppins = FontFamily(
        Font(
            googleFont = GoogleFont("Poppins"),
            fontProvider = provider,
            weight = FontWeight.Normal
        ),
        Font(
            googleFont = GoogleFont("Poppins"),
            fontProvider = provider,
            weight = FontWeight.Bold
        )
    )
}