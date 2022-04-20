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
        var cartas_afectadas_explosion= listOf<Carta>(
            salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)-1],
            salaActual.cartasSala[salaActual.cartasSala.indexOf(enemigo)+1]
        )
        cartas_afectadas_explosion.forEach{
            if(it is Enemigo){
                enemigo.ataque(it)
                if(it.vida<=0){
                    enemigo_ataque_expansivo(it)
                }
            }
        }
    }
    fun enemigo_ataque(enemigo: Enemigo){
        enemigo.ataque(Jugador)
        if(enemigo.tipoEnemigo=="Veneno" || enemigo.tipoEnemigo=="Explosion"){
            enemigo_ataque_expansivo(enemigo)
        }
    }

    fun siguienteSala(){
        salaActual=Sala(mapaSalas[Sala.totalSalasCreadas]!!.random())

    }


}