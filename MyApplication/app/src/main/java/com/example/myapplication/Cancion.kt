package com.example.myapplication

interface reproducible {
    fun reproducir()
}

interface descargable {
    fun descargable()
}
class Cancion (var titulo: String): reproducible {

    var artista: String = "Desconocido"
    var duracion: Int = 2

    constructor(titulo: String, artista: String): this(titulo) {
        this.artista = artista
    }

    constructor(titulo: String, artista: String, duracion: Int): this(titulo) {
        this.artista = artista
        this.duracion = duracion
    }

    override fun reproducir() {
        println("Reproduciendo $titulo")
    }

}

class podcast(var nombre: String): reproducible, descargable {

    var episodios: Int = 0

    constructor(nombre: String, episodios: Int): this(nombre) {
        this.episodios = episodios
    }

    override fun reproducir() {
        println("Reproduciendo podcast $nombre")
    }

    override fun descargable() {
        println("Decargando podcast $nombre")
    }

}