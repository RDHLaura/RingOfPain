fun main(args: Array<String>) {

    println(GameManager.salaActual.cartasSala)
    println("-----------------------------")
    println("-----------------------------")

    repeat(2){
        var enemigo:Carta=GameManager.salaActual.cartasSala[2]
        if(enemigo is Enemigo){
            GameManager.accionJugador(enemigo)
            println(GameManager.salaActual.cartasSala)
            println(Jugador.vida)
        }
        println("-----------------------------")
    }



}