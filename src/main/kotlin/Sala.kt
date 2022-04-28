class Sala (var tipoSala: TipoSalas) {
    /*In each run, there are 15 Clases.main dungeon rooms, 2 Finders Keepers, 4 Shops and a floor 16 (?) ending floor,
  plus optional event dungeons that the player can choose to visit, and boss dungeon(s) - varying on which ending is taken.*/

    var cartasSala= mutableListOf<Carta>()
    //MAPA DE SALA: 10 SALAS
    companion object{
        var numSalaActual=0
        var ultimas_salas= mutableListOf<TipoSalas>()
    }
    init{
//        if (tipoSala.salasRestantes <= 0) {
//            throw Exception("Se alcanzó el máx de ese tipo sala")
//        } else {
  //          tipoSala.salasRestantes--

            ultimas_salas.add(tipoSala)
            var salaPrueba=mutableListOf<Carta>(Enemigo(), Enemigo(),Enemigo(), Item(), Enemigo(),Enemigo(), Item())
            generarSala()
            barajar()
            numSalaActual++
//        }
    }
    fun barajar(){
        cartasSala.shuffle()
    }
    var mapaPuertasSalas= mutableMapOf<Int, MutableList<TipoSalas>>( //poner las salas correctas
        0 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers), //fija, da paso a una puerta de QLESLQ, después se llama a la siguiente sala
        1 to mutableListOf<TipoSalas>(TipoSalas.ESTANDAR), //fija
        2 to mutableListOf<TipoSalas>(TipoSalas.ESTANDAR), //
        3 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers, TipoSalas.ESTANDAR),
        4 to mutableListOf<TipoSalas>(TipoSalas.ESTANDAR),
        5 to mutableListOf<TipoSalas>(TipoSalas.AGRESIVIDAD,TipoSalas.TIENDA, TipoSalas.ESTANDAR),
        6 to mutableListOf<TipoSalas>(TipoSalas.ESTANDAR),
        7 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers, TipoSalas.ESTANDAR),
        8 to mutableListOf<TipoSalas>(TipoSalas.ESTANDAR),
        9 to mutableListOf<TipoSalas>(TipoSalas.Finders_Keepers, TipoSalas.ESTANDAR),
    )
    fun generarSala(){

        for ((clase, cantidad) in tipoSala.cartas){
            repeat(cantidad){
                when(clase){
                    "Clases.Enemigo"-> cartasSala.add(Enemigo())
                    "Clases.Item"-> cartasSala.add(Item())
                    "Clases.Puerta"->mapaPuertasSalas[numSalaActual]!!.forEach{cartasSala.add(Puerta(it))}
                }
            }
        }
        cartasSala.shuffle()
        ultimas_salas.add(tipoSala)
    }
}