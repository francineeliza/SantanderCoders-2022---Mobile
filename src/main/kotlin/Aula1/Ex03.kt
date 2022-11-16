fun main(){
    println("Informe o valor da base de um triangulo")
    val base: Int = readln().toInt()
    println("Informe o valor da altura de um triangulo")
    val altura: Int = readln().toInt()
    val area: Int = base * altura / 2
    println("A area do triangulo é $area")
}