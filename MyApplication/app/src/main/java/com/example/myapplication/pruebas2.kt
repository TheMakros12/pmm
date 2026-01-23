package com.example.myapplication

fun main() {

    val cancion: Cancion = Cancion("SELEDA")
    println(cancion.titulo)
    println(cancion.artista)

    val cancion2: Cancion = Cancion("JOYY", "Raul Clyde")
    println(cancion2.titulo)
    println(cancion2.artista)

    val cancion3: Cancion = Cancion("Margiela", "Omar Courtz", 3)
    println(cancion3.titulo)
    println(cancion3.artista)
    println(cancion3.duracion)

    val podcast = podcast("Worldcast")
    println(podcast.nombre)
    println(podcast.episodios)

    val podcast2 = podcast("El Club de la Corchea", 44)
    println(podcast2.nombre)
    println(podcast2.episodios)

}