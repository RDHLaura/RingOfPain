class Sala (var tipoSala: TipoSalas) {
    /*In each run, there are 15 main dungeon rooms, 2 Finders Keepers, 4 Shops and a floor 16 (?) ending floor,
  plus optional event dungeons that the player can choose to visit, and boss dungeon(s) - varying on which ending is taken.*/
    var cartasSala= mutableListOf<Carta>()

    companion object{
        var totalSalasCreadas=0
        lateinit var ultima_sala:TipoSalas
    }
    init{

        if (tipoSala.salasRestantes <= 0) {
            throw Exception("Se alcanzó el máx de ese tipo sala")
        } else {
            tipoSala.salasRestantes--
            totalSalasCreadas++
            ultima_sala = tipoSala
        }
    }

    fun generarSala(){
        for ((clase, cantidad) in tipoSala.cartas){
            repeat(cantidad){
                cartasSala.add(clase)
            }
        }
    }

}