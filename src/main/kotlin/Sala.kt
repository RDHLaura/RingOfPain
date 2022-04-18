class Sala (var tipoSala: TipoSalas) {
    /*In each run, there are 15 main dungeon rooms, 2 Finders Keepers, 4 Shops and a floor 16 (?) ending floor,
  plus optional event dungeons that the player can choose to visit, and boss dungeon(s) - varying on which ending is taken.*/

    companion object{  //ver cuantas salas tiene un juego completo y cuales son las salas básicas y las secundarias

        var salasCreadas=0
    }
    init{
        salasCreadas++
    }


    fun generarSala(){
        TODO()
    }

}