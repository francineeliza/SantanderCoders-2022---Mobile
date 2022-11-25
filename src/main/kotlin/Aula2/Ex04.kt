package Aula2
fun main() {
    print("Digite o número de eleitores:")
    var eleitores: Int = readln().toInt()
    var votosA: Int = 0
    var votosB: Int = 0
    var votosC: Int = 0

    for(index in 1..eleitores){
        println("Vote em A, B ou C:")
        var voto: String = readln()

        when (voto.uppercase()){
            "A" -> votosA++
            "B" -> votosB++
            "C" -> votosC++
        }
    }
    var totalA: Double = (votosA / eleitores.toDouble()) * 100
    var totalB: Double = (votosB / eleitores.toDouble()) * 100
    var totalC: Double = (votosC / eleitores.toDouble()) * 100

    println("Candidato A - $votosA votos ($totalA%)")
    println("Candidato B - $votosB votos ($totalB%)")
    println("Candidato C - $votosC votos ($totalC%)")

}