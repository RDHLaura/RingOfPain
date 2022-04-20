class Sala (var tipoSala: TipoSalas) {
    /*In each run, there are 15 main dungeon rooms, 2 Finders Keepers, 4 Shops and a floor 16 (?) ending floor,
  plus optional event dungeons that the player can choose to visit, and boss dungeon(s) - varying on which ending is taken.*/


    var cartasSala= mutableListOf<Carta>()
    //MAPA DE SALA: 10 SALAS
    companion object{
        var totalSalasCreadas=0
        var ultimas_salas= mutableListOf<TipoSalas>()
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
    }
    init{

        if (tipoSala.salasRestantes <= 0) {
            throw Exception("Se alcanzó el máx de ese tipo sala")
        } else {
            tipoSala.salasRestantes--
            totalSalasCreadas++
            ultimas_salas.add(tipoSala)
        }
    }

    fun generarSala(){
        if(tipoSala.nivel_sala==1){
            for ((clase, cantidad) in tipoSala.cartas){
                repeat(cantidad){
                    cartasSala.add(clase)
                }
            }
        }

    }

}