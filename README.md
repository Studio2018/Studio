# Studio
Plataforma móvil para espacios educativos

Esta compuesto por Arduino, Android Studio y eclipse en el cual se involucran procesos tanto para el espacio físico (Silla), como el aplicativo móvil(Studio).

Android Studio
La aplicación inicia creando una cuenta en la plataforma, la cual esta enlazada con la base de datos de firebase que me registra los nuevos usuario. Dentro, el usuario puede realizar cuatro tareas:

1. Crear y compartir archivos
para esta actividad el usuario podrià crear algunas categorias de diferentes temas donde se subirian archivos relacionados y se compartirian con los amigos o grupos ya declarados en la aplicación. Ademas cada archivo y categoria existia dentro de un nodo de la base de datos con el fin de agilizar el proceso de compartir. Para la realizacion de esta actividad se hizo uso del expandable list y su adadptador el cual tiene un hasmap como contenedor de las categorias y el list de strings que determinan el nombre de los archivos. Como adicional, se crearon algunos pop up en los campos de texto como metodo para crear categorias o archivos.

2. Playlist
En la cual el usuario puede amenizar su espacio de trabajo. En esta tarea, hay 3 actividades. La primera en donde estan las playlist del usuario representados en elementos ImageButton los cuales son seleccionados y me despliegan una list view con las respectivas canciones que integran la playlist, el usuario tiene la posibilidad de seleccionar una canción en especifico o reproducir directamente toda la playlist. Los elementos multimedia se desarrollaron con las variables media player.

3.Calendario
El calendario se llevo a cabo utilizando un el widget de calendar picker y la implementacion 'com.squareup:android-times-square:1.6.5@aar' para que el calendario tuviese una vie de cuadrados, adicionalmente se hizo una list view y el espacio de los imputs para crear los distintos eventos. el calendario funciona con yn calendar picker que al instanciarse toma el valor de la fecha y a traves del calendar picker puede tomar el valor de cualquier fecha del calendario siempre y cuando esta este despues de la fecha actual, asi mismo puede seleccionar rangos de fechas. con los imputs se crean eventos, objetos tipo evento que a traves de un base adapter se adecuan a la lista permitiendo ver todos los eventos que se tienen.

4.Cuenta
Aquí, el usuario observa su lista de contactos y añade mediante la lectura de un código QR y a su vez, este puede generar un código QR para que otros puedan añadirlo a su lista de contactos. Estos usuarios son actualizados en la base de datos de firebase.
