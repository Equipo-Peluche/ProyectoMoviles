# ProyectoMoviles 2024

Este proyecto se centra en el desarrollo de una API REST 1.0 dedicada a la gestión y consulta de información sobre dispositivos móviles. El objetivo principal es proporcionar a los usuarios una herramienta intuitiva para explorar y comparar diversas características de los móviles disponibles en el mercado.

## Entidad Relacion
[![ER-primerafase.png](https://i.postimg.cc/wBGW7fJQ/ER-primerafase.png)](https://postimg.cc/rd5GH9fD)

## Historias de usuario
- El usuario quiere que le recomiende los 5 moviles más vistos para obrtener un resumen general.
- El usuario quiere poder comparar 2 moviles.
- Yo como administrador quiero poder hacer CRUD sobre los moviles.
- El usuario tienen la capacidad de realizar consultas mediante la especificación de criterios de búsqueda. Se inicia la selección con la marca del móvil, lo cual presenta una lista con información resumida. Posteriormente, se pueden agregar más criterios como precio (mínimo y máximo, obligatorio en todas las búsquedas), cantidad de RAM, presencia de NFC, y tecnología de pantalla.

    Cualquier petición al REST puede contener uno o varios criterios para refinar la búsqueda.

    #### Tipos de filtros

    - **Almacenamiento**
    - **ScreenSize (Tamaño de Pantalla)**
    - **Batería**
    - **Tecnología de Pantalla**
    - **Cámara**
    - **Visita**
    - **Modelo**
    - **NFC**
    - **RAM**
    - **Peso**
    - **Precio**
    - **Procesador**

## Postman documentation

En este enlace podras encontrar los diversas pruebas que hemos hecho para el proyecto:
https://documenter.getpostman.com/view/163811/2s9YysCLz8

## Instrucciones de Uso

1. [Paso 1] Utiliza el enlace proporcionado en el apartado de postman. 
2. [Paso 2] Metete en postman.
3. [Paso 3] Aqui hay estan las diferentes request que le puedes hacer a la API de Spring.
4. [Paso 4] Elige una de las request y haz una peticion a la API-REST de Spring.
5. [Paso 5] Visualiza los resultados filtrados.

## Autores:

- [**David**](https://github.com/davidbelesp)   ARQUITECTURA

- [**Félix**](https://github.com/felixieshna)   BBDD 

- [**Jesús María**](https://github.com/jesusmariaieshna)    TEST

- [**Jose Antonio**](https://github.com/joseantoniorbieshna)    JAVA8

- [**Manuel**](https://github.com/ManuCB1)  CODER

- [**Alba**](https://github.com/Albamunru)  BBDD




