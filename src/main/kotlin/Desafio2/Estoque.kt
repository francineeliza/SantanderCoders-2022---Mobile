package Desafio2

import java.lang.NumberFormatException

var idAtual = 1
var pecas = mutableListOf<Peca>()

fun main() {
    menuPrincipal()
}
fun menuPrincipal() {
    println("ESCOLHA UMA OPÇÃO DO MENU ABAIXO:")
    println("1 - ADICIONAR ITEM")
    println("2 - EDITAR ITEM")
    println("3 - EXIBIR ITENS EM ESTOQUE")
    println("4 - EXIBIR TODOS OS ITENS")
    println("0 - FECHAR SISTEMA")

    try {
        val opcao = readln().toInt()
        lerOpcaoMenuPrincipal(opcao)
    } catch (e: NumberFormatException) {
        println("Opção inválida!")
        menuPrincipal()
    }
}
fun lerOpcaoMenuPrincipal(opcao: Int){
    when (opcao){
        1 -> addItem()
        2 -> editarItem()
        3 -> exibirEstoque()
        4 -> exibirTodos()
        0 -> return
        else -> menuPrincipal()
    }
}
fun addItem() {
    println("Informe o nome da peça:")
    val nome = readln()
    println("Informe a quantidade:")
    var quantidade: Int
    try {
        quantidade = validaQuantidade()
    } catch (e: LimiteEstoqueException){
        println("Quantidade Inválida!")
        menuPrincipal()
        return
    }
    val peca = Peca(idAtual, nome, quantidade)
    idAtual++
    pecas.add(peca)
    menuPrincipal()

}
fun editarItem() {
    println("Informe o ID do produto:")
    try {
        val idPeca = readln().toInt()
        var pecaEditada: Peca? = try { pecas.filter { it.id == idPeca }.first() } catch (e: NoSuchElementException) { null }
        if (pecaEditada == null) {
            println("ID não cadastrado!!!")
            menuPrincipal()
        }
        println("Informe novo nome")
        pecaEditada?.nome = readln()
        println("Informe nova quantidade:")
        try {
            pecaEditada?.quantidade = validaQuantidade()
        } catch (e: LimiteEstoqueException) {
            println("Quantidade Inválida!")
        }
        menuPrincipal()
    } catch (e: NumberFormatException) {
        println("ID digitado não é um número.")
        editarItem()
    }
}
fun exibirEstoque() {
    val estoque = pecas.filter { it.quantidade > 0 }
    exibirTodos(estoque)
}
fun exibirTodos(pecasAExibir: List<Peca> = pecas) {
    println("ID | Peça | Quantidade")
    for (peca in pecasAExibir) {
        println("#%04d".format(peca.id) + " | ${peca.nome} | ${peca.quantidade}")
    }
    menuPrincipal()
}
fun validaQuantidade(): Int {
    val quantidade = try { readln().toInt() } catch (e: NumberFormatException) { null }
    if (quantidade == null || quantidade > 999 || quantidade < 0){
        throw LimiteEstoqueException(null)
    }
    return quantidade
}
class Peca(val id: Int, var nome: String, var quantidade: Int) {}

class LimiteEstoqueException(s: String?) : IllegalArgumentException(s) {

}