object Inventario {
    //Para pruebas
    var carta1=Carta()
    var carta2=Carta()
    //empieza la clase
    var objetos= mutableMapOf<String,Carta?>(
        "Vela" to null,"Casco" to null,"Peto" to null, "Guantes" to null,
        "Pantalon" to null, "Botas" to null, "Escudo" to null, "Arma" to null,
        "Mascara" to null, "Bote" to null, "Collar" to null, "Amuleto" to null,
        "Piedra" to null, "Libro" to null, "Pergamino" to null)

    fun actulizaStats(carta: Carta){
        Jugador.vida+=carta.vida
        Jugador.ataque+=carta.ataque
        Jugador.defensa+=carta.defensa
        Jugador.velocidad+=carta.velocidad
        Jugador.lucidez+=carta.lucidez
        Jugador.ataqueCritico+=carta.ataqueCritico
        Jugador.esquiva+=carta.esquiva
        Jugador.sigilo+=carta.sigilo
    }
    fun eliminaStats(carta: Carta){
        fun actulizaStats(carta: Carta){
            Jugador.vida-=carta.vida
            Jugador.ataque-=carta.ataque
            Jugador.defensa-=carta.defensa
            Jugador.velocidad-=carta.velocidad
            Jugador.lucidez-=carta.lucidez
            Jugador.ataqueCritico-=carta.ataqueCritico
            Jugador.esquiva-=carta.esquiva
            Jugador.sigilo-=carta.sigilo
        }
    }
    fun addObjeto(carta: Carta){
        //Hay que comprobar si el espacio en inventario para esa carta está libre o en caso contrario reemplazar eliminando los stats de esa carta del jugador
        if(objetos[carta.tipo]==null){
            objetos[carta.tipo]=carta
            actulizaStats(carta)
        }else{
            eliminaStats(objetos[carta.tipo]!!)

        }

    }

}