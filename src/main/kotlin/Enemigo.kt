

class Enemigo(tier:Int):Carta() {
    val enemigoElegido: ClaseEnemigo

    init{
        val enemigosTotales = ClaseEnemigo.values()
        val enemigosMismoTier = enemigosTotales.filter { it.tier == tier }
        enemigoElegido = enemigosMismoTier.random()
    }
    override var nombre:String=enemigoElegido.nombre
    override var imagen = "sprites/enemigos/$enemigoElegido.png"
    var vidaActual:Int = enemigoElegido.vitalidad;
    val vidaTotal = enemigoElegido.vitalidad
    var danioFisico=enemigoElegido.danioFisico
    var danioEspecial: Int=enemigoElegido.danioEspecial
    var danioPenetrante: Int=enemigoElegido.danioPenetrante
    var defensa=enemigoElegido.defensa
    var velocidad=enemigoElegido.velocidad
    var efectoAlMorir: Efecto?=enemigoElegido.efectoAlMorir
    var tipoDanioEspecial=enemigoElegido.tipoDanioEspecial
    var almas=enemigoElegido.almas
    var tier: Int=enemigoElegido.tier

    var puedeAtacar=true
    var envenenado=false


    fun porcentajeVidaRestante():Double
    {
        return (1-(vidaTotal-vidaActual)/vidaTotal).toDouble()
    }

    //////////////////////////////////////////////////////////////////
    ////////////////////////Poner en la clase oficial///////////////
    fun comprobarMuerto():Boolean{
         if (vidaActual<=0){
             muerto()
             return true
        }else return false

    }
    fun muerto(){ //añade las almas al jugador y lo elimina de la lista de cartas de la sala
        Jugador.almas+=this.almas
        GameManager.salaActual.cartasSala.remove(this)
        if(GameManager.salaActual.cartasSala.indexOf(this)==0){ //si el enemigo que muere está en la posición 0 se coloca el último de la lista en esa posición
            GameManager.salaActual.cartasSala.add(0,GameManager.salaActual.cartasSala.last())
        }
    }

    fun ataque(jugador:Jugador){
        jugador.vida-=danioFisico //Cambiar formula TODO
    }
    fun ataque(enemigo: Enemigo){//Para ataques expansivos
        enemigo.vidaActual-=danioFisico //Cambiar formula TODO
    }

    override fun toString(): String {
        return "Enemigo(enemigoElegido=$enemigoElegido, nombre='$nombre', vidaActual=$vidaActual, velocidad=$velocidad,almas=$almas, tier=$tier)"
    }


}