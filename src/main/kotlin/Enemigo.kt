class Enemigo():Carta() {
    companion object {
        var numero:Int=-1
    }
    init {
        numero++
    }
    //para pruebas, a sustituir
    var num= numero
    var vida:Int =6
    var ataque=2
    var defensa=1
    var velocidad=3
    var tipoEnemigo="Veneno"


    fun ataque(jugador:Jugador){ //Para ataques expansivos
        jugador.vida-=ataque //Cambiar formula TODO
    }
    fun ataque(enemigo: Enemigo){
        enemigo.vida-=ataque //Cambiar formula TODO
    }

    override fun toString(): String {
        return "Enemigo(num=$num,vida=$vida, ataque=$ataque, defensa=$defensa, velocidad=$velocidad, tipoEnemigo='$tipoEnemigo')"
    }

}