# TopTunes
Escenario práctico de consumo de API REST(last.fm).

_Aplicación desarrollada en Kotlin usando la arquitectura MVVC, que presenta información obtenida mediante un consumo API REST._

_Se implementó la librería Retrofit2 en su versión 2.9.0 para realizar el consumo del servicio API REST._

_Se implementó la librería dagger hilt para realizar inyección de dependencias._

_Se implementó la librería coroutines para la gestión de tareas asíncronas._

_Se implementaron las librerías Junit, Mockito, Coroutines-test para la realización de las pruebas unitarias._

_Se implementó la librería Espresso para la realización de UI Test._

_La aplicación contiene dos interfaces: la interfaz principal con el top 10 artistas Colombia y una interfaz con el top 5 canciones del artista._

_La información de la interfaz principal se presenta en contenedores de tipo CardView, los cuales fueron inflados mediante un adaptador._

_Los datos presentados en la interfaz principal son name(artista), listeners y una imagen._

_Los datos presentados en la interfaz por artista son: name(canción), playcount y una imagen._

## Instrucciones de instalación

_El proyecto se encuentra en la rama máster._

_La clonación del proyecto se realiza mediante la siguiente URL: https://github.com/barbosaivan/TopTunes.git_

_El nivel de API mínimo requerido para la instalación de la aplicación es: 21._

_El android gradle plugin versión usada es: 7.4.2._

## Funcionalidad
_La aplicación muestra un top de 10 artistas por país (Colombia), presentando nombre y cantidad de oyentes y una imagen._

_La aplicación cuenta con una interfaz escroleable. Al dar clic sobre un artista, te envía a una nueva interfaz con el top canciones por artista._

_La interfaz de top canciones por artista presenta el nombre del artista y una lista de sus top 5 canciones._

_La interfaz de top canciones por artista cuenta con un botón "ver más" que dirige al navegador del dispositivo a un sitio con más información del artista._

_El listado de canciones presenta el nombre de la canción y reproducciones. Al presionar sobre esta, dirige al navegador del dispositivo a un sitio con más información de esta canción._

## Url API REST
Top artistas por país
_http://ws.audioscrobbler.com/2.0/?method=geo.gettopartists&country={pais}&api_key={api_key}&format=json_
Top canciones por artista
_https://ws.audioscrobbler.com/2.0/?method=artist.gettoptracks&artist={nombre_artista}&api_key={api_key}&format=json_
 
 ## Herramientas

 * retrofit2

 * dagger hilt

 * Mockito
 
 * Espresso

 * Glide
 
 * androidx
 
 * google material
 
 ## Dependencias implementasdas

* Retrofit2

_implementation 'com.squareup.retrofit2:retrofit:2.9.0'_

_implementation 'com.squareup.retrofit2:converter-gson:2.9.0'_

* Corrutinas

_implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'_

* dagger hilt

_implementation "com.google.dagger:hilt-android:2.44"_

_kapt "com.google.dagger:hilt-android-compiler:2.44"_

* Junit

_testImplementation 'junit:junit:4.13.2'_

* Mockito

_testImplementation 'org.mockito:mockito-inline:3.12.4'_

_testImplementation 'androidx.arch.core:core-testing:2.2.0'_

* Coroutines-test

_testImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4'_

* Espresso

_androidTestImplementation 'androidx.test.ext:junit:1.1.5'_

_androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'_

_androidTestImplementation 'androidx.test.espresso:espresso-contrib:3.5.1'_

_androidTestImplementation 'androidx.test:rules:1.5.0'_

_androidTestImplementation 'androidx.test.espresso:espresso-intents:3.5.1'_
 
* ViewModel

 _implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"_

* Dependecia andoroid ktx

_implementation "androidx.activity:activity-ktx:1.6.1"_

* Glide
  
_implementation 'com.github.bumptech.glide:glide:4.15.1'_
 
 ## Autor
_Ivan Barbosa Ortega_

_Ejercicio como prueba para optar a la vacante de desarrollador Android en la empresa NecomPlus_

_Url documentacion api: https://www.last.fm/_

_Desarrollador Android || Ingeniero de sistemas._
