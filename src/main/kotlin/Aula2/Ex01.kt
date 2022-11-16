fun main() {

    println("Digite 10 valores:")
    val valores: MutableList<Int> = mutableListOf()

    for (index in 0..9){
        valores.add(readln().toInt())
    }
    valores.sort()
    println("Menor valor: ${valores.first()}")
    println("Maior valor: ${valores.last()}")
}