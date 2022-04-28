class Sala (var tipoSala: TipoSalas) {
    /*In each run, there are 15 Clases.main dungeon rooms, 2 Finders Keepers, 4 Shops and a floor 16 (?) ending floor,
  plus optional event dungeons that the player can choose to visit, and boss dungeon(s) - varying on which ending is taken.*/

    var cartasSala= mutableListOf<Carta>()
    //MAPA DE SALA: 10 SALAS
    companion object{
        var totalSalasCreadas=0
        var ultimas_salas= mutableListOf<TipoSalas>()
        var minimoTier=1 //usado para calcular el tier
        var m=0 //usado para los tiers tambien
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
            totalSalasCreadas++
            m++   //con esto cada 3 veces que se generen salas aumentamos n  y devolvemos m a cero
            if (m==2){
                minimoTier++
                m=0}
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
    fun generarTier():Int{
        if (totalSalasCreadas>5){
            var maxTier:Int= 5
            return (minimoTier..maxTier).random()}

        else{
            var maxTier:Int= totalSalasCreadas
            return (minimoTier..maxTier).random()}
    }
    fun generarSala(){

        for ((clase, cantidad) in tipoSala.cartas){
            repeat(cantidad){
                when(clase){
                    "Clases.Enemigo"-> cartasSala.add(Enemigo())
                    "Clases.Item"-> cartasSala.add(Item())
                    "Clases.Puerta"->mapaPuertasSalas[totalSalasCreadas]!!.forEach{cartasSala.add(Puerta(it))}
                }
            }
        }
        cartasSala.shuffle()
        ultimas_salas.add(tipoSala)
    }

}