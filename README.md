# TopTunes
Escenario practico consumo de API REST(last.fm).

_Aplicación desarrollada en kotlin usando la arquitectura MVVC, que presenta información obtenida mediante un consumo API REST._

_Contiene dos interfaces, la interfaz principal con el top 10 artistas Colombia y una interfaz con el top 5 canciones del artista._

_Se implementó la librería Retrofit2 en su versión 2.9.0 para realizar el consumo._

_La información de la interfaz principal se presenta en contenedores de tipo CardView, los cuales fueron inflados mediante un adaptador._

_Los datos presentados en la interfaz principal son name(artista), listeners y una imagen._

_Los datos presentados en la interfaz por atista son name(cancion), playcount y una imagen._

## Instrucciones de instalacion

_El proyecto se encuentra en la rama master._

_La clonacion del proyecto se realiza mediente la siguiente Url: https://github.com/barbosaivan/TopTunes.git_

_El nivel de API minimo requerido para la instalacion del la aplicacion es: 21_

_El android gradle plugin version usado es: 7.4.2_

## Funcionalidad
_La aplicación muestra un top de 10 artistas por país(Colombia), presentando nombre y cantidad de oyentes" y una imagen_

_La aplicación cuenta con una interfaz escroleable, al dar clic sobre un artista te envía a una nueva interfaz con top canciones por artista_

_La interfaz de top canciones por artista, presenta el nombre del artista y una lista de su top 5 canciones_

_La interfaz de top canciones por artista cuenta con un botón "ver más" que dirige al navegador del dispositivo a un sitio con más información del artista_

_El listado de canciones presenta nombre de la canción y reproducciones. Al presionar sobre esta dirige al navegador del dispositivo a un sitio con más información de esta canción_

## Url API REST
Top artistas por pais
_http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country={pais}&api_key={api_key}&format=json_
Top canciones por artista
_https://ws.audioscrobbler.com/2.0/?method=artist.gettoptracks&artist={nombre_artista}&api_key={api_key}&format=json_
 
 ## Herramientas
 * androidx
 
 * google material
 
 * retrofit2

 * Glide
 
 ## Dependencias implementasdas
 
* ViewModel

 _implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"_

* Corrutinas

_implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'_

* Dependecia andoroid ktx

_implementation("androidx.activity:activity-ktx:1.6.1")_

* Retrofit2

_implementation 'com.squareup.retrofit2:retrofit:2.9.0'_
_implementation 'com.squareup.retrofit2:converter-gson:2.9.0'_

* Glide
_implementation 'com.github.bumptech.glide:glide:4.15.1'_
 
 ## Autor
_Ivan Barbosa Ortega_

_Ejercicio como prueba para optar a la vacante de desarrollador Android en la empresa NecomPlus_

_Url documentacion api: https://www.last.fm/_

_Desarrollador Android || Ingeniero de sistemas_
