package Desafio1

private const val PAES = 1
private const val SALGADOS = 2
private const val DOCES = 3
private const val FINALIZAR = 0
private val listaCategorias = listOf(PAES, SALGADOS, DOCES, FINALIZAR)


private const val LINHA = "..............."

val produtoPaoFrances = "Pão Francês"
val produtoPaoDeLeite = "Pão de Leite"
val produtoPaoDeMilho = "Pão de Milho"

val valorPaoFrances = 0.60
val valorPaoDeLeite = 0.40
val valorPaoDeMilho = 0.50

val paes: List<Pair<String, Double>> = listOf(
    Pair(produtoPaoFrances, valorPaoFrances),
    Pair(produtoPaoDeLeite, valorPaoDeLeite),
    Pair(produtoPaoDeMilho, valorPaoDeMilho),
)

val produtoCoxinha = "Coxinha"
val produtoEsfiha = "Esfiha"
val produtoPaoDeQueijo = "Pão de Queijo"

val valorCoxinha = 5.00
val valorEsfiha = 6.00
val valorPaoDeQueijo = 3.00

val salgados: List<Pair<String, Double>> = listOf(
    Pair(produtoCoxinha, valorCoxinha),
    Pair(produtoEsfiha, valorEsfiha),
    Pair(produtoPaoDeQueijo, valorPaoDeQueijo),
)

val produtoCarolina = "Carolina"
val produtoPudim = "Pudim"
val produtoBrigadeiro = "Brigadeiro"

val valorCarolina = 1.50
val valorPudim = 4.00
val valorBrigadeiro = 2.00

val doces: List<Pair<String, Double>> = listOf(
    Pair(produtoCarolina, valorCarolina),
    Pair(produtoPudim, valorPudim),
    Pair(produtoBrigadeiro, valorBrigadeiro),
)

private val menuPrincipal = """
        1..................Pães
        2..............Salgados
        3.................Doces
        0......Finalizar compra
    """.trimIndent()

val menuPaes = """
        1 - $produtoPaoFrances...........R$ $valorPaoFrances
        2 - $produtoPaoDeLeite..........R$ $valorPaoDeLeite
        3 - $produtoPaoDeMilho..........R$ $valorPaoDeMilho
        0 - Voltar
    """.trimIndent()

val menuSalgados = """
        1 - $produtoCoxinha...........R$ $valorCoxinha
        2 - $produtoEsfiha..........R$ $valorEsfiha
        3 - $produtoPaoDeQueijo..........R$ $valorPaoDeQueijo
        0 - Voltar
    """.trimIndent()

val menuDoces = """
        1 - $produtoCarolina...........R$ $valorCarolina
        2 - $produtoPudim..........R$ $valorPudim
        3 - $produtoBrigadeiro..........R$ $valorBrigadeiro
        0 - Voltar
    """.trimIndent()

val itensComanda = mutableListOf<String>()
var total: Double = 0.0

fun main() {
    println("BEM VINDO A PARADARIA E-PADOCA!!!!")
    ePadoca()
    println("====================Comanda E-padoca=======================\n" +
            "Item${LINHA}Produto${LINHA}Qtd${LINHA}Valor${LINHA}Total")
    itensComanda.forEach { item ->
        println(item)
    }
    println("Valor total R$ %.2f".format(total))
}

fun ePadoca() {

    do {
        println(menuPrincipal)
        println("Escolha uma das opções do cardápio:")
        val escolhaMenuPrincipal = readln().toInt()
        var finalizaCompra = "N"

        when (escolhaMenuPrincipal) {
            PAES -> selecionaProduto(menuPaes, paes)
            SALGADOS -> selecionaProduto(menuSalgados, salgados)
            DOCES -> selecionaProduto(menuDoces, doces)
            else -> {
                println("Você deseja finalizar a compra? (S/N)")
                finalizaCompra = readln().uppercase()
                if (finalizaCompra == "N") {
                    continue
                } else if (finalizaCompra == "S") {
                    adicionaCupom()
                }
            }
        }
    } while (escolhaMenuPrincipal != 0 || finalizaCompra != "S")
}

private fun adicionaCupom() {
    println("Deseja adicionar um cupom (S/N)?")
    var adicionaCupom = readln().uppercase()
    if (adicionaCupom == "N") {
        return
    } else if (adicionaCupom == "S") {
        println("Digite o nome do cupom")
        var nomeCupom = readln().uppercase()
        when (nomeCupom) {
            "5PADOCA" -> total *= 0.95
            "10PADOCA" -> total *= 0.90
            "5OFF" -> total -= 5.00
            else -> {
                println("Cupom inválido.")
                adicionaCupom()
            }
        }
    }
}

private fun selecionaProduto(
    menuSelecionado: String,
    produtos: List<Pair<String, Double>>
) {
    do {
        println(menuSelecionado)
        val produtoSelecionado = readln().toInt()

        for ((index, produto) in produtos.withIndex()) {
            if (index.inc() == produtoSelecionado) {
                selecionaQuantidadeDoProduto(produto)
            }
        }
    } while (produtoSelecionado != 0)

}

fun selecionaQuantidadeDoProduto(produto: Pair<String, Double>) {
    println("Quantos vai querer?")
    val quantidade = readln().toInt()
    val totalItem = quantidade * produto.second
    val item = itemComanda(
        produto = produto.first,
        quantidade = quantidade,
        valorUnitario = produto.second,
        total = totalItem
    )
    itensComanda.add(item)
    total += totalItem
}

fun itemComanda(
    produto: String,
    quantidade: Int,
    valorUnitario: Double,
    total: Double
): String = "${itensComanda.size.inc()}$LINHA$produto$LINHA$quantidade$LINHA$valorUnitario" +
        "${LINHA}R$$total"