import Clases.*
fun main(args: Array<String>) {

    println(GameManager.salaActual.cartasSala)
    println("-----------------------------")
    println("-----------------------------")

    repeat(1){
        var enemigo:Carta=GameManager.salaActual.cartasSala[1]
        GameManager.seleccionarCarta(enemigo)
        println(GameManager.salaActual.cartasSala)
        println("-----------------------------")
    }
    println(GameManager.salaActual.tipoSala)
    println(Sala.totalSalasCreadas)

    repeat(9){
        GameManager.siguienteSala()
        println(GameManager.salaActual.tipoSala)
        println(Sala.totalSalasCreadas)
        println(GameManager.salaActual.cartasSala.filter { it is Puerta })
        println("-----------------------------")
    }


}




