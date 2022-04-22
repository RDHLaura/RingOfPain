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

    fun enemigosAdyacentes(enemigo: Enemigo):MutableList<Carta>?{
        var cartas_afectadas_explosion= mutableListOf<Carta>()
        if(salaActual.cartasSala.size<=1) {
            return null
        }
        else if (salaActual.cartasSala.indexOf(enemigo)==salaActual.cartasSala.lastIndex){//el enemigo está en la última posición
            cartas_afectadas_explosion.add(salaActual.cartasSala[0])
            cartas_afectadas_explosion.add(salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)-1])
        }
        else if(salaActual.cartasSala.indexOf(enemigo)==0){//el enemigo está en la primera posición
            cartas_afectadas_explosion.add(salaActual.cartasSala[salaActual.cartasSala.lastIndex])
            cartas_afectadas_explosion.add(salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)+1])

        }else if(salaActual.cartasSala.indexOf(enemigo)>0){
            cartas_afectadas_explosion.add(salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)-1])
            cartas_afectadas_explosion.add(salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)+1])
        }
        return cartas_afectadas_explosion
    }


    private fun enemigo_ataque_explosivo(enemigo: Enemigo){ //tiene un problema, si mueren los dos adyacentes
        //solo vuelve a llamar la función para el primero de la lista
        ataqueEnemigoEstandar(enemigo)//ataca al jugador

        val adyacentes = enemigosAdyacentes(enemigo)
        enemigo.muerto()
        println(Jugador.almas)
        if( adyacentes!=null) {
            adyacentes.forEach {
                if (it is Enemigo) {
                    enemigo.ataque(it) //adyacente sufre daño por enemigo explotado
                }
            }
            adyacentes.forEach {
                if (it is Enemigo && it.vida <= 0 && it.tipoEnemigo == "Explosion") {
                    println(salaActual.cartasSala)
                    if (salaActual.cartasSala.filter { it is Enemigo }.size >1)
                        enemigo_ataque_explosivo(it)
                    else
                        it.muerto()



                }
            }


        }
    }

    fun enemigo_ataque_veneno(enemigo: Enemigo){
        //TODO
    }




}