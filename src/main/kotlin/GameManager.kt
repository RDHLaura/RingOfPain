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
    /////////////////////////cambiar fórmulas de ataque////////////////////////////////////



    fun enemigo_ataque_expansivo(enemigo: Enemigo){ //Debe ser recursiva. Hacer pruebas TODO

        var cartas_afectadas_explosion= mutableListOf<Carta>()
        if (salaActual.cartasSala.indexOf(enemigo)>0){
                cartas_afectadas_explosion.add(
                salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)-1])
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
                    salaActual.cartasSala.remove(it)
                    enemigo_ataque_expansivo(it)
                }
            }
        }
    }
    fun enemigo_ataque(enemigo: Enemigo){
        //Comprueba que el enemigo esté en la posición 0 y 1 para hacer daño al jugador
        if(salaActual.cartasSala.indexOf(enemigo)==0 || salaActual.cartasSala.indexOf(enemigo)==1){
            enemigo.ataque(Jugador)
        }
        if(enemigo.tipoEnemigo=="Veneno" || enemigo.tipoEnemigo=="Explosion"){
            enemigo_ataque_expansivo(enemigo)
        }
    }

    fun siguienteSala(){
        salaActual=Sala(mapaSalas[Sala.totalSalasCreadas]!!.random())
    }


}