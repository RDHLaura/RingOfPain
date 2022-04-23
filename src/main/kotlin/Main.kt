
fun main(args: Array<String>) {

    println(GameManager.salaActual.cartasSala)
    println("-----------------------------")
    println("-----------------------------")

    repeat(1){
        var enemigo:Carta=GameManager.salaActual.cartasSala[1]
        GameManager.accionJugador(enemigo)
        println(GameManager.salaActual.cartasSala)
        println("-----------------------------")
    }



}




