fun main(args: Array<String>) {
    GameManager.siguienteSala(TipoSalas.PRUEBA)
    println(GameManager.salaActual.cartasSala)
    println("-----------------------------")
    println("-----------------------------")

    repeat(2){
        var enemigo:Carta=GameManager.salaActual.cartasSala[0]
        if(enemigo is Enemigo){
            GameManager.accionJugador(enemigo)
            println(GameManager.salaActual.cartasSala)
            println(Jugador.vida)
        }
        println("-----------------------------")
    }




}