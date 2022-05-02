package Clases
object GameManager {

    var salaActual:Sala= Sala(TipoSalas.ESTANDAR) //se inicia con la principal creada

    //////////////creación de sala//////////////////////////
    fun siguienteSala(tipoSalas: TipoSalas=TipoSalas.ESTANDAR){ //crea la sala y usa el bote si lo tiene equipado y con usos disponibles
        if(Inventario.objetos["Bote"]!=null && Inventario.objetos["Bote"]!!.usos>0){
            Inventario.usarOjetoConsumible(Inventario.objetos["Bote"]!!)
        }
        when(Sala.totalSalasCreadas){ // crea salas fijas en ciertas posiciones del mapa de salas
            1->salaActual=Sala(TipoSalas.Finders_Keepers)
            5 -> salaActual=Sala(TipoSalas.TIENDA)
            8 -> salaActual=Sala(TipoSalas.Finders_Keepers)
            9 -> salaActual=Sala(TipoSalas.FINAL)
            else ->  salaActual=Sala(tipoSalas)
        }
    }

    //////////////////interacción jugador //////////////////////////////
    fun pasarCartaIzq(){
        detectar(salaActual.cartasSala[0])
        salaActual.rotarIzquierda()
    }
    fun pasarCartaDcha(){
        detectar(salaActual.cartasSala[1])
        salaActual.rotarDerecha()
    }
    fun detectar(carta: Carta){ //comprueba si la carta que se pasa es un enemigo, y según el sigilo del jugador tiene más probabilidad de no ser detectado
        if(carta is Enemigo && (0..99).random()<=Jugador.sigilo) {
            (carta as Enemigo).ataque(Jugador)
        }
    }
    fun seleccionarCarta(carta: Carta){ //el jugador selecciona una carta del anillo
        when (carta){
            is Item->Inventario.addObjeto(carta) //crear una función que equipe cualquier objeto TODO
            is Enemigo -> ataque_a_enemigo(carta)//llama a ataqueEnemigo que llama a la función de
            is Puerta -> carta.usarPuerta()
        }
    }


    ////////////////funciones de ataque///////////////////
    fun ataque_a_enemigo(enemigo: Enemigo){ /*se determina el orden de ataque y  el jugador realiza el ataque al enemigo seleccionado,
                                                 se llama a la función para que el enemigo haga su atque*/
        if (Jugador.velocidad>=enemigo.velocidad){
            Jugador.ataque(enemigo)
            if(enemigo.tipoDanioEspecial in listOf<TipoDanio>(TipoDanio.EXPLOSION)){ //incluir los tipos que hagan daño a pesar de morir
                ataqueEnemigo(enemigo)
            }else{
                enemigo.comprobarMuerto()
                ataqueEnemigo(enemigo)
            }
        }
        else {
            ataqueEnemigo(enemigo)
            Jugador.ataque(enemigo)
        }
    }

    private fun ataqueEnemigo(enemigo: Enemigo){ //selecciona el tipo de ataque que realizará el enemigo dependiendo del tipo que sea
        when(enemigo.tipoDanioEspecial){
            TipoDanio.EXPLOSION->explotar(enemigo)
            //TipoDanio.VENENO->//TODO
            else-> enemigo.ataque(Jugador)
        }
    }



////////////////función explotar//////////////
    fun anterior(elemento:Carta):Carta?{ //el adyacente de la izq
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
        enemigo.ataque(Jugador)//ataca al jugador
        val adyacentes = adyacentes(enemigo)
        enemigo.muerto()
        if(adyacentes.isNotEmpty()){
            adyacentes.forEach { enemigo.ataque(it) }//adyacente sufre daño por enemigo explotado
            adyacentes.filter{it.tipoDanioEspecial!=TipoDanio.EXPLOSION}.forEach{ if(it.vidaActual<=0) it.muerto()}
            adyacentes.filter { it.tipoDanioEspecial == TipoDanio.EXPLOSION}.forEach{if(it.vidaActual<=0) explotar(it)}
        }
    }


/////////////////función veneno/////////////////





}