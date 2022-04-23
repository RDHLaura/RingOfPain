object GameManager {
    var mapaSalas= mutableMapOf<Int, MutableList<TipoSalas>>( //poner las salas correctas
        0 to mutableListOf<TipoSalas>(TipoSalas.SALA_ESTANDAR),
        1 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers,TipoSalas.TIENDA, TipoSalas.SALA_ESTANDAR),
        2 to mutableListOf<TipoSalas>(TipoSalas.SALA_ESTANDAR),
        3 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers,TipoSalas.GUARDIAS, TipoSalas.SALA_ESTANDAR),
        4 to mutableListOf<TipoSalas>(TipoSalas.SALA_ESTANDAR),
        5 to mutableListOf<TipoSalas>(TipoSalas.AGRESIVIDAD,TipoSalas.TIENDA, TipoSalas.SALA_ESTANDAR),
        6 to mutableListOf<TipoSalas>(TipoSalas.SALA_ESTANDAR),
        7 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers,TipoSalas.GUARDIAS, TipoSalas.SALA_ESTANDAR),
        8 to mutableListOf<TipoSalas>(TipoSalas.SALA_ESTANDAR),
        9 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers,TipoSalas.GUARDIAS, TipoSalas.SALA_ESTANDAR),
    )
    var salaActual:Sala= Sala(mapaSalas[0]!![0]) //se inicia con la principal creada


    //////////////////interacción jugador con la carta seleccionada//////////////////////////////
    fun accionJugador(carta: Carta){ //el jugador selecciona una carta del anillo ataca/equipa
        when (carta){
            is Item->Inventario.addObjeto(carta) //crear una función que equipe cualquier objeto TODO
            is Enemigo -> ataqueJugador(carta)
            is Puerta -> siguienteSala(carta.tipoSalas)
        }
    }


    //////////////creación de sala//////////////////////////
    fun siguienteSala(tipoSalas: TipoSalas){ //crea la sala y usa el bote si lo tiene equipado y con usos disponibles
        salaActual=Sala(tipoSalas)
        if(Inventario.objetos["Bote"]!=null && Inventario.objetos["Bote"]!!.usos>0){
            Inventario.usarOjetoConsumible(Inventario.objetos["Bote"]!!)
        }
    }



    //cambiar fórmulas de ataque TODO

    ////////////////Funciones ataques///////////////////

    fun ataqueJugador(enemigo: Enemigo){ //el jugador realiza el ataque al enemigo seleccionado
        Jugador.ataque(enemigo)
        ataqueEnemigo(enemigo)
    }


    private fun ataqueEnemigo(enemigo: Enemigo){ //selecciona el tipo de ataque que realizará el enemigo dependiendo del tipo que sea
        when(enemigo.tipoEnemigo){
            "Normal"-> ataqueEnemigoEstandar(enemigo)
            "Explosion"->enemigo_ataque_explosivo(enemigo)
            "Veneno"->enemigo_ataque_veneno(enemigo)
        }
    }

    private fun ataqueEnemigoEstandar(enemigo: Enemigo){ //Comprueba que el enemigo esté en la posición 0 y 1 para hacer daño al jugador
        if(salaActual.cartasSala.indexOf(enemigo) in 0..1){
            enemigo.ataque(Jugador)
        }
    }

    fun anterior(elemento:Carta):Carta?{
        var lista= salaActual.cartasSala
        if (lista.size < 2) return null //no puede haber un elemento anterior si hay menos de 2 elementos
        val indice = lista.indexOf(elemento)
        return if (indice==0)  lista.last() //si es el primero devuelve el ultimo
        else lista.elementAt(indice-1) //si no, devuelve el anterior

    }

    fun siguiente(elemento:Carta):Carta?{
        var lista= salaActual.cartasSala
        if (lista.size < 2) return null //no puede haber un elemento anterior si hay menos de 2 elementos
        val indice = lista.indexOf(elemento)
        return if (indice==lista.size-1 && lista.first() is Enemigo) return lista.first() //si es el ultimo devuelve el primero
        else  lista.elementAt(indice+1)//si no, devuelve el siguiente
    }

    fun adyacentes( elemento:Carta):List<Enemigo> {
        val lista2 = mutableListOf<Enemigo>()
        anterior(elemento)?.let { if(it is Enemigo)lista2.add(it) } //si no es nulo añadelo
        siguiente(elemento)?.let { if(it is Enemigo)lista2.add(it) } //si no es nulo añadelo
        return lista2.distinct()
    }

    private fun enemigo_ataque_explosivo(enemigo: Enemigo){
        ataqueEnemigoEstandar(enemigo)//ataca al jugador
        val adyacentes = adyacentes(enemigo)
        enemigo.muerto()
        adyacentes.forEach { enemigo.ataque(it) }//adyacente sufre daño por enemigo explotado
        adyacentes.filter{it.tipoEnemigo!="Explosion"}.forEach{if(it.vida<=0) it.muerto()}
        adyacentes.filter { it.tipoEnemigo == "Explosion"}.forEach{if(it.vida<=0) enemigo_ataque_explosivo(it)}
    }

    fun enemigo_ataque_veneno(enemigo: Enemigo){
        //TODO
    }




}