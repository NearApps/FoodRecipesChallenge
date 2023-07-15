# Food Recipes App
Aplicación de Android que consume [TheMealDB](https://www.themealdb.com/).
Se ha construido con:
principios de arquitectura limpia, patrón de repositorio y patrón MVVM, así como componentes de arquitectura.

## Demo
<table>
    <tr>
        <td> <img src="media/screenshot1.png"  width="150"></td>
        <td> <img src="media/screenshot1_dark.png" alt="Main screen" width="150"></td>
        <td> <img src="media/screenshot2.png"  width="150"></td>
        <td> <img src="media/screenshot2_dark.png" alt="Main screen" width="150"></td>
    </tr> 
    <tr>
       <td> <img src="media/screenshot3.png"  width="150"></td>
        <td> <img src="media/screenshot3_dark.png" alt="Main screen" width="150"></td>
        <td> <img src="media/screenshot4.png"  width="150"></td>
        <td> <img src="media/screenshot4_dark.png" alt="Main screen" width="150"></td>
    </tr> 
</table>

### Stack

It's using:

- MVVM with coroutines
- Clean Architecture
- Jetpack Compose
- Google Maps
- Hilt
- Arrow
- Retrofit
- Moshi
- Glide
- ...


## Architecture

<img src="media/clean.png">

- app: Presentation Layer
- domain: Business Logic Layer
- data: Data Access Layer

## TODO
- [ ] End to end test
- [ ] Unit test
- [ ] CI/CD (Github Actions, Bitrise, Fastlane)
- [ ] Firebase Crashlytics
- [ ] Firebase Analytics
- [ ] Añadir DataStore para almacenar las preferencias del usuario (Like, Dislike, etc)
- [ ] Habilitar la opcion de ingredientes

## Contributions
No dude usar los [Issues](https://github.com/NearApps/FoodRecipesChallenge/issues) para presentar un problema por errores, sugerencias o solicitudes de funciones.