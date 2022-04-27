import java.util.Collections
class Sala (var tipoSala: TipoSalas) {
    /*In each run, there are 15 main dungeon rooms, 2 Finders Keepers, 4 Shops and a floor 16 (?) ending floor,
  plus optional event dungeons that the player can choose to visit, and boss dungeon(s) - varying on which ending is taken.*/


    var cartasSala= mutableListOf<Carta>()
    //MAPA DE SALA: 10 SALAS
    companion object{
        var totalSalasCreadas=0
        var ultimas_salas= mutableListOf<TipoSalas>()
    }
    init{
        if (tipoSala.salasRestantes <= 0) {
            throw Exception("Se alcanzó el máx de ese tipo sala")
        } else {
            tipoSala.salasRestantes--
            totalSalasCreadas++
            ultimas_salas.add(tipoSala)
            generarSala()
        }
    }

    fun generarSala(){
        if(tipoSala.nivel_sala==1){
            for ((clase, cantidad) in tipoSala.cartas){
                repeat(cantidad){
                    when(clase){
                        "Enemigo"-> cartasSala.add(Enemigo())
                        "Item"-> cartasSala.add(Item())
                    }

                }
            }
        }
    }

    fun rotarDerecha(){
        Collections.rotate(cartasSala,1)
    }

    fun rotarIzquierda(){
        Collections.rotate(cartasSala,-1)
    }

}