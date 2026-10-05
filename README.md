# Spotify-API — cliente Android de la Web API de Spotify

Aplicación Android en Kotlin y Jetpack Compose que inicia sesión con una cuenta de Spotify y permite explorar
la biblioteca y el catálogo: álbumes, artistas, playlists, categorías, pódcasts, audiolibros y canciones, con
reproducción a través de la app oficial de Spotify (App Remote SDK).

> Proyecto académico de la materia de desarrollo de aplicaciones móviles.

## Tecnologías

Kotlin · Jetpack Compose · Material 3 · Hilt (inyección de dependencias) · Retrofit + Gson · Coil ·
Navigation Compose · Spotify App Remote SDK

## Arquitectura

```
UI (Compose screens) ──► Repository ──► Retrofit services ──► Spotify Web API
        │                                   │
        └── Navigation (NavManager)         └── SpotifyAuthManager: token OAuth, caducidad y renovación
```

| Paquete | Contenido |
|---|---|
| `api/` | `AuthApiService` (2 endpoints de token) y `SpotifyApiService` (28 endpoints de la Web API) |
| `data/` | `SpotifyAuthManager`: intercambio del código de autorización, caducidad y *refresh* del token |
| `di/` | Módulos de Hilt para red y reproducción |
| `repository/` | Acceso a datos para las pantallas |
| `screens/` | Biblioteca, perfil y detalle de álbum, artista, playlist, categoría, show, episodio, audiolibro y canción |
| `playback/` | Control de reproducción con App Remote |

## Configuración

1. Crea una app en el [Spotify Developer Dashboard](https://developer.spotify.com/dashboard) y registra el
   *redirect URI* `spotify-api-app://callback`.
2. Copia `local.properties.example` a `local.properties` (ya está en `.gitignore`) y completa
   `SPOTIFY_CLIENT_ID` y `SPOTIFY_CLIENT_SECRET`.
3. Abre el proyecto en Android Studio (compileSdk 36, minSdk 24) y ejecútalo en un dispositivo que tenga la app
   de Spotify instalada.

## Seguridad

- Las credenciales no están en el código: se inyectan desde `local.properties` mediante `BuildConfig`.
- Las credenciales que estuvieron en versiones anteriores del repositorio se **revocaron** y ya no son válidas.
- **Limitación conocida:** el secreto de cliente sigue empaquetado en el APK. Lo correcto para una app móvil es
  el flujo *Authorization Code with PKCE*, que no necesita secreto. Está pendiente.

## Estado

- Proyecto académico; la versión saneada no se ha vuelto a compilar desde que las credenciales pasaron a `local.properties`.
- Sin pruebas automatizadas propias (solo las plantillas de Android Studio).
