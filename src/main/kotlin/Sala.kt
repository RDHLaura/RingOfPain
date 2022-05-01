import java.util.Collections
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
            totalSalasCreadas++
            ultimas_salas.add(tipoSala)
            //var salaPrueba=mutableListOf<Carta>(Enemigo(), Enemigo(),Enemigo(), Item(), Enemigo(),Enemigo(), Item())
            generarSala()
            barajar()

            m++   //con esto cada 3 veces que se generen salas aumentamos n  y devolvemos m a cero
            if (m==2){
                minimoTier++
                m=0}
//        }
    }
    fun barajar(){
        cartasSala.shuffle()
    }

    fun generarTier():Int{
        if (totalSalasCreadas>5){
            var maxTier:Int= 5
            return (minimoTier..maxTier).random()}

        else{
            var maxTier:Int= totalSalasCreadas
            return (minimoTier..maxTier).random()}
    }


    fun generarSala(){
        var puertas1sala= listOf<TipoSalas>(TipoSalas.Finders_Keepers, TipoSalas.ESTANDAR)
        for ((clase, cantidad) in tipoSala.cartas){
            repeat(cantidad){
                when(clase){
                    "Clases.Enemigo"-> cartasSala.add(Enemigo(generarTier()))
                    "Clases.Item"-> cartasSala.add(Item())
                    "Clases.Puerta"->{
                        if(totalSalasCreadas==0){
                        cartasSala.add(Puerta(puertas1sala[cantidad]))
                        }
                    }
                }
            }
        }
        if(tipoSala.cartas.containsKey("Clases.Puerta")){
            cartasSala.add(Puerta(TipoSalas.ESTANDAR))
        }
        barajar()
        ultimas_salas.add(tipoSala)
    }
    fun rotarDerecha(){
        Collections.rotate(cartasSala,1)
    }

    fun rotarIzquierda(){
        Collections.rotate(cartasSala,-1)

    }
}