package Aula2
fun main() {

    print("Digite um número: ")
    var tabuada: Int = readln().toInt()
    println("Tabuada do $tabuada")
    for (numero in 1..10){
        var resultado: Int = numero * tabuada
        println("$numero x $tabuada = $resultado")
    }


}