package Aula2
fun main(){
    println("Informe um número inteiro positivo:")
    var numero: Int = readln().toInt()
    var primosAteNumero = primos(numero)
    println(primosAteNumero)

}
fun primos(n: Int): MutableList<Int> {
    val lista = mutableListOf<Int>()
    for (num in 2..n) {
        if ((2 until num).none{ num % it == 0 })
            lista.add(num)
    }
    return lista
}