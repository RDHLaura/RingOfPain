class Enemigo():Carta() {
    //para pruebas, a sustituir
    var vida:Int =6
    var ataque=1
    var defensa=1
    var velocidad=3
    var tipoEnemigo="Veneno"

    fun ataque(jugador:Jugador){ //Para ataques expansivos
        jugador.vida-=ataque //Cambiar formula TODO
    }
    fun ataque(enemigo: Enemigo){
        enemigo.vida-=ataque //Cambiar formula TODO
    }
}