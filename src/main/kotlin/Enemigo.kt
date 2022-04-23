

class Enemigo():Carta() {
    companion object {
        var nombres:Int=0
    }

    //para pruebas, a sustituir
    var nombre:Int=0
    var vida:Int =6
    var ataque=3
    var defensa=1
    var velocidad=3
    var tipoEnemigo="Explosion"
    var almas=3

    init {
        nombres++
        nombre= nombres
    }

    //////////////////////////////////////////////////////////////////
    ////////////////////////Poner en la clase oficial///////////////
    fun muerto(){ //añade las almas al jugador y lo elimina de la lista de cartas de la sala
        Jugador.almas+=this.almas
        GameManager.salaActual.cartasSala.remove(this)
        if(GameManager.salaActual.cartasSala.indexOf(this)==0){ //si el enemigo que muere está en la posición 0 se coloca el último de la lista en esa posición
            GameManager.salaActual.cartasSala.add(0,GameManager.salaActual.cartasSala.last())
        }
    }

    fun ataque(jugador:Jugador){
        jugador.vida-=ataque //Cambiar formula TODO
    }
    fun ataque(enemigo: Enemigo){//Para ataques expansivos
        enemigo.vida-=ataque //Cambiar formula TODO
    }

    override fun toString(): String {
        return "Clases.Enemigo(num=$nombre)"
    }//,vida=$vida, ataque=$ataque, defensa=$defensa, velocidad=$velocidad, tipoEnemigo='$tipoEnemigo'

}