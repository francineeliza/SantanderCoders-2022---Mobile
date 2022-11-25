package Aula1
fun main(){

    println("Digite seu primeiro nome:")
    val nome: String = readln().take(2).lowercase()
    println("Digite seu sobrenome:")
    val sobrenome: String = readln().reversed().lowercase()
    println("Digite seu ano de nascimento:")
    val anoNascimento: String = readln().takeLast(2)
    println("nick gerado: $nome$sobrenome$anoNascimento")

}