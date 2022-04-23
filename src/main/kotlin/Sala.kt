
class Sala (var tipoSala: TipoSalas) {
    /*In each run, there are 15 Clases.main dungeon rooms, 2 Finders Keepers, 4 Shops and a floor 16 (?) ending floor,
  plus optional event dungeons that the player can choose to visit, and boss dungeon(s) - varying on which ending is taken.*/


    var cartasSala= mutableListOf<Carta>()
    //MAPA DE SALA: 10 SALAS
    companion object{
        var totalSalasCreadas=0
        var ultimas_salas= mutableListOf<TipoSalas>()
    }
    init{
//        if (tipoSala.salasRestantes <= 0) {
//            throw Exception("Se alcanzó el máx de ese tipo sala")
//        } else {
  //          tipoSala.salasRestantes--
            totalSalasCreadas++
            ultimas_salas.add(tipoSala)
            var salaPrueba=mutableListOf<Carta>(Enemigo(), Enemigo(),Enemigo(), Item(), Enemigo(),Enemigo(), Item())
            generarSala()
            barajar()
//        }
    }
    fun barajar(){
        cartasSala.shuffle()
    }

    fun generarSala(){

        for ((clase, cantidad) in tipoSala.cartas){
            repeat(cantidad){
                when(clase){
                    "Clases.Enemigo"-> cartasSala.add(Enemigo())
                    "Clases.Item"-> cartasSala.add(Item())
                    //"Clases.Puerta"->cartasSala.add(Clases.Puerta())
                }
            }
        }
        cartasSala.shuffle()

    }
}