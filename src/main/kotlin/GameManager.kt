object GameManager {
    var mapaSalas= mutableMapOf<Int, MutableList<TipoSalas>>( //poner las salas correctas
        0 to mutableListOf<TipoSalas>(TipoSalas.PRINCIPAL),
        1 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers,TipoSalas.GUARDIAS),
        2 to mutableListOf<TipoSalas>(TipoSalas.PRINCIPAL),
        3 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers,TipoSalas.GUARDIAS),
        4 to mutableListOf<TipoSalas>(TipoSalas.PRINCIPAL),
        5 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers,TipoSalas.GUARDIAS),
        6 to mutableListOf<TipoSalas>(TipoSalas.PRINCIPAL),
        7 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers,TipoSalas.GUARDIAS),
        8 to mutableListOf<TipoSalas>(TipoSalas.PRINCIPAL),
        9 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers,TipoSalas.GUARDIAS),
    )
    lateinit var salaActual:Sala
    //////////////creación de sala//////////////////////////
    fun siguienteSala(){ //crea la sala y usa el bote si lo tiene equipado y con usos disponibles
        salaActual=Sala(mapaSalas[Sala.totalSalasCreadas]!!.random())
        if(Inventario.objetos["Bote"]!=null && Inventario.objetos["Bote"]!!.usos>0){
            Inventario.usarOjetoConsumible(Inventario.objetos["Bote"]!!)
        }
    }
    //cambiar fórmulas de ataque TODO

    //función que añada las almas al jugador cuando muere el enemigo TODO

    ////////////////Funciones ataque///////////////////

    fun ataqueBasicoEnemigo(enemigo: Enemigo){
        //Comprueba que el enemigo esté en la posición 0 y 1 para hacer daño al jugador
        if(salaActual.cartasSala.indexOf(enemigo)==0 || salaActual.cartasSala.indexOf(enemigo)==1){
            enemigo.ataque(Jugador)
        }
    }
    fun enemigo_ataque(enemigo: Enemigo){
        ataqueBasicoEnemigo(enemigo)
        when(enemigo.tipoEnemigo){
            "Explosion"->enemigo_ataque_explosivo(enemigo)
            "Veneno"->enemigo_ataque_veneno(enemigo)
        }
    }

    fun enemigo_ataque_explosivo(enemigo: Enemigo){

        var cartas_afectadas_explosion= mutableListOf<Carta>()
        if (salaActual.cartasSala.indexOf(enemigo)>0){
            cartas_afectadas_explosion.add(salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)-1])
            cartas_afectadas_explosion.add(salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)+1])
        }
        else if(salaActual.cartasSala.indexOf(enemigo)==0){//el enemigo está en la primera posición
            cartas_afectadas_explosion.add(salaActual.cartasSala[salaActual.cartasSala.lastIndex])
            cartas_afectadas_explosion.add(salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)+1])

        }else if(salaActual.cartasSala.indexOf(enemigo)==salaActual.cartasSala.lastIndex){//el enemigo está en la última posición
            cartas_afectadas_explosion.add(salaActual.cartasSala[0])
            cartas_afectadas_explosion.add(salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)-1])
        }

        cartas_afectadas_explosion.forEach{
            if(it is Enemigo){
                enemigo.ataque(it)

                salaActual.cartasSala.remove(enemigo)

                if(it.vida<=0){
                    ataqueBasicoEnemigo(enemigo)
                    salaActual.cartasSala.remove(it)
                    enemigo_ataque(it)
                }
            }
        }
    }

    fun enemigo_ataque_veneno(enemigo: Enemigo){
        //TODO
    }




}