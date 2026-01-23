package com.example.ejemploskotlin00

fun main() {
    mostrarNombres("Marcos", "Marta")
    mostrarNombres2("Marcos", "Paula", "Baldum Jr.")

    mostrarNombres2()
}

fun mostrarEdad(edad: Int) {
    if (edad in 0 .. 17) {
        print("Es menor de edad.")
    } else if (edad in 18 .. 60) {
        print("Es mayor de edad.")
    } else {
        print("Es de 3ª edad.")
    }
}

fun diasDeLosMeses(mes: Int) {
    when(mes) {
        1,3,5,7,9,11 -> print("Tiene 31 días.")
        2 -> print("Tiene 28 días.")
        4,6,8,10,12 -> print("Tiene 30 días.")
        else -> print("Valor incorrecto.")
    }
}

fun mostrarProducto(nombre: String, precio: Float=0f, oferta: Boolean=false) {
    print("El producto es $nombre ")
            //precio.let { "El precio es $precio" } ?: "Precio desconocido")

    if (precio == 0f) {
        println("el precio es desconocido.")
    } else {
        println("el precio es $precio")
    }
    if(oferta) {
        println("Esta de oferta")
    } else {
        println("No esta de oferta")
    }
    println("============================================")
}

fun mostrarNombres(nom1: String, nom2: String) {
    println("$nom1 $nom2")
}

fun mostrarNombres2(vararg nombres: String) {
    var indice: Int = 0;
    while (indice < nombres.size){
        println("Nombre: ${nombres.get(indice)}")
        indice++
    }
}

fun funcionLet() {
    val nombre: String? = null

    nombre?. let {
        println("El nombre en mayuscula es ${it.uppercase()}")
    } ?: print("Nombre no definido.")
}