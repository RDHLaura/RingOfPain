
object GameManager {

    var salaActual:Sala= Sala(TipoSalas.ESTANDAR) //se inicia con la principal creada
    var turno=0


    //////////////////interacción jugador con la carta seleccionada//////////////////////////////
    fun actualizarTurno(){
        turno++
        danyoVeneno()
    }

    fun accionJugador(carta: Carta){ //el jugador selecciona una carta del anillo ataca/equipa
        actualizarTurno()
        when (carta){
            is Item->Inventario.addObjeto(carta) //crear una función que equipe cualquier objeto TODO
            is Enemigo -> JugadorAtacaEnemigo(carta)
            is Puerta -> siguienteSala(carta.tipoSalas)
        }
    }


    //////////////creación de sala//////////////////////////
    fun siguienteSala(tipoSalas: TipoSalas=TipoSalas.ESTANDAR){ //crea la sala y usa el bote si lo tiene equipado y con usos disponibles
        //cif(Sala.ultimas_salas.last() in listOf<TipoSalas>(TipoSalas.Finders_Keepers, TipoSalas.TIENDA))
            //
        if(Inventario.objetos["Bote"]!=null && Inventario.objetos["Bote"]!!.usos>0){
            Inventario.usarOjetoConsumible(Inventario.objetos["Bote"]!!)
            salaActual=Sala(tipoSalas)
        }
    }


    //cambiar fórmulas de ataque TODO

    ////////////////Funciones ataques///////////////////

    fun JugadorAtacaEnemigo(enemigo: Enemigo){ //el jugador realiza el ataque al enemigo seleccionado
        if (Jugador.velocidad>enemigo.velocidad){
            Jugador.ataque(enemigo)
            enemigo.comprobarMuerto()
            ataqueEnemigo(enemigo)
        }
        else {
            ataqueEnemigo(enemigo)
            Jugador.ataque(enemigo)
        }
    }


    private fun ataqueEnemigo(enemigo: Enemigo){ //selecciona el tipo de ataque que realizará el enemigo dependiendo del tipo que sea
        when(enemigo.tipoDanioEspecial){
            null-> enemigoAtacaJugador(enemigo)
            TipoDanio.EXPLOSION->explotar(enemigo)
            TipoDanio.VENENO->enemigoLanzaVeneno(enemigo)
        }
    }

    private fun enemigoAtacaJugador(enemigo: Enemigo){ //Comprueba que el enemigo esté en la posición 0 y 1 para hacer daño al jugador
        if(salaActual.cartasSala.indexOf(enemigo) in 0..1){
            enemigo.ataque(Jugador)
        }
    }
////////////////función explotar//////////////
    fun anterior(elemento:Carta):Carta?{
        var lista= salaActual.cartasSala
        if (lista.filter { it is Enemigo }.size < 2 ) return null //no puede haber un elemento anterior si hay menos de 2 elementos
        val indice = lista.indexOf(elemento)
        if(indice<0)return null
        return if (indice==0)return  lista.last() //si es el primero devuelve el ultimo
        else  lista[indice-1] //si no, devuelve el anterior
    }

    fun siguiente(elemento:Carta):Carta?{
        var lista= salaActual.cartasSala
        if (lista.filter { it is Enemigo }.size< 2 ) return null //no puede haber un elemento anterior si hay menos de 2 elementos
        val indice = lista.indexOf(elemento)
        if(indice<0)return null
        return if (indice==lista.size-1) return lista.first() //si es el ultimo devuelve el primero
        else  lista.elementAt(indice+1)//si no, devuelve el siguiente
    }

    fun adyacentes( elemento:Carta):List<Enemigo> {
        val lista2 = mutableListOf<Enemigo>()
        anterior(elemento)?.let { if(it is Enemigo )lista2.add(it) } //si no es nulo añadelo
        siguiente(elemento)?.let { if(it is Enemigo )lista2.add(it) } //si no es nulo añadelo
        return lista2.distinct()
    }

    fun explotar(enemigo: Enemigo){
        enemigoAtacaJugador(enemigo)//ataca al jugador
        val adyacentes = adyacentes(enemigo)
        enemigo.muerto()
        if(adyacentes.isNotEmpty()){
            adyacentes.forEach { it.vidaActual=0 }//adyacente sufre daño por enemigo explotado
            adyacentes.filter{it.tipoDanioEspecial!=TipoDanio.EXPLOSION}.forEach{ if(it.vidaActual<=0) it.muerto()}
            adyacentes.filter { it.tipoDanioEspecial == TipoDanio.EXPLOSION}.forEach{if(it.vidaActual<=0) explotar(it)}
        }
    }


/////////////////función veneno/////////////////
    fun enemigoLanzaVeneno(enemigo: Enemigo){ //enemigo venenoso
        Jugador.envenenado=true
        enemigoAtacaJugador(enemigo)
    }
    fun danyoVeneno(){ //actualiza el daño de las cartas envenadas en el sig turno del veneno
        salaActual.cartasSala.forEach{ // TODO implementar función para que el jugador pueda envenenar cartas
            if(it is Enemigo && it.envenenado==true){
                enemigoLanzaVeneno(it)
                it.envenenado=false
            }
        }
        if(Jugador.envenenado==true){
            //TODO aplicar segundo daño a jugador
        }
    }




}