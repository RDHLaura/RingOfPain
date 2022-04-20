fun main(args: Array<String>) {
    GameManager.siguienteSala()
    println(GameManager.salaActual.cartasSala)
    println("-----------------------------")
    println("-----------------------------")

    repeat(2){
        var enemigo:Carta=GameManager.salaActual.cartasSala[3]
        if(enemigo is Enemigo){
            GameManager.enemigo_ataque(enemigo)
            println(GameManager.salaActual.cartasSala)
            println(Jugador.vida)
        }
        println("-----------------------------")
    }



}