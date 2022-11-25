package Aula1
fun main (){

    println("Digite o lado do quadrado:")
    val lado: Int = readln().toInt()
    val area: Int = lado * lado
    val perimetro: Int = 4 * lado

    println("A area do quadrado e de $area e seu perimetro de $perimetro")
}
