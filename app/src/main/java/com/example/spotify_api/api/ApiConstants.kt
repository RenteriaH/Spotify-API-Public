package com.example.spotify_api.api

import com.example.spotify_api.BuildConfig

/**
 * Objeto que contiene todas las constantes necesarias para interactuar con la API de Spotify.
 * Centralizar estas constantes aquí facilita su mantenimiento y evita tener valores "mágicos" esparcidos por el código.
 */
object ApiConstants {
    // El ID de cliente único para tu aplicación, obtenido desde el dashboard de desarrolladores de Spotify.
    val CLIENT_ID: String = BuildConfig.SPOTIFY_CLIENT_ID

    // El secreto se inyecta desde local.properties (fuera de git).
    // Pendiente: migrar a Authorization Code + PKCE para no necesitar secreto en la app.
    val CLIENT_SECRET: String = BuildConfig.SPOTIFY_CLIENT_SECRET

    // La URI a la que Spotify redirigirá al usuario después de que autorice (o deniegue) la aplicación.
    // Usamos un esquema personalizado para que la app intercepte esta URL.
    const val REDIRECT_URI = "spotify-api-app://callback"

    // La URL base para los endpoints de autenticación de Spotify (solicitar y refrescar tokens).
    const val ACCOUNTS_BASE_URL = "https://accounts.spotify.com/"

    // La URL base para los endpoints principales de la API de Spotify (obtener álbumes, artistas, etc.).
    const val API_BASE_URL = "https://api.spotify.com/v1/"
}
