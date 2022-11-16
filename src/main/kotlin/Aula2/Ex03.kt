fun main() {
    println("Digite 15 números:")
    val numeros: MutableList<Int> = mutableListOf()

    for (index in 0..14){
        numeros.add(readln().toInt())
    }
    numeros.reverse()
    for (elemento in numeros){
        println(elemento)
    }
}