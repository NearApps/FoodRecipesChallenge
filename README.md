# Food Recipes App
Aplicación de Android que consume [TheMealDB](https://www.themealdb.com/). 


## Demo
<table>
    <tr>
        <td> Home<br/><img src="media/screenshot1.png"  width="180"></td>
        <td> Home Dark<br/><img src="media/screenshot1_dark.png" alt="Main screen" width="180"></td>
        <td> Categories<br/><img src="media/screenshot2.png"  width="180"></td>
        <td> Categories Dark<br/><img src="media/screenshot2_dark.png" alt="Main screen" width="180"></td>
    </tr> 
    <tr>
       <td> Recipe Detail<br/><img src="media/screenshot2.png"  width="180"></td>
        <td> Recipe Detail Dark<br/><img src="media/screenshot2_dark.png" alt="Main screen" width="180"></td>
        <td> Recipe Map<br/><img src="media/screenshot4.png"  width="180"></td>
        <td> Recipe Map Dark<br/><img src="media/screenshot4_dark.png" alt="Main screen" width="180"></td>
    </tr> 
</table>

### Stack

It's using:

- MVVM with coroutines
- Clean Architecture
- Jetpack Compose
- Google Maps
- Hilt
- Arrow Kt (Typed Functional Programming)
- Retrofit
- Moshi
- Glide from landscapist library
- Vitamin Compose (UI Library)
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