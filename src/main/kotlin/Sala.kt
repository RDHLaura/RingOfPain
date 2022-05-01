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
        totalSalasCreadas++
        ultimas_salas.add(tipoSala)
        generarSala()
        barajar()

        m++   //con esto cada 3 veces que se generen salas aumentamos n  y devolvemos m a cero
        if (m==2){
            minimoTier++
            m=0}
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
        /*es llamada desde la función siguienteSala del GM,
        * crea un máximo de 3 puertas por sala estandar (las que tienen puertas, las demás pasan directamente a una sala
        * estándar), con el map mapaSalas establezco las puertas que va a tener cada sala.
        * Cuando es una sala con puertas, recorre el map incluyendo todas las salas en la variable puertas
        * que después de eliminar las puertas repetidas se incluirán en la sala*/
        val mapaSalas= mapOf<Int, List<TipoSalas>>(
            1 to listOf<TipoSalas>(TipoSalas.Finders_Keepers, TipoSalas.Finders_Keepers,TipoSalas.Finders_Keepers),
            3 to listOf<TipoSalas>(TipoSalas.GUARDIAS, TipoSalas.AGRESIVIDAD,TipoSalas.ESTANDAR),
            4 to listOf<TipoSalas>(TipoSalas.GUARDIAS, TipoSalas.AGRESIVIDAD,TipoSalas.ESTANDAR),
            5 to listOf<TipoSalas>(TipoSalas.TIENDA, TipoSalas.TIENDA, TipoSalas.TIENDA),
            7 to listOf<TipoSalas>(TipoSalas.GUARDIAS, TipoSalas.AGRESIVIDAD,TipoSalas.ESTANDAR),
            8 to listOf<TipoSalas>(TipoSalas.Finders_Keepers, TipoSalas.Finders_Keepers,TipoSalas.Finders_Keepers)
        )
        var puertas= mutableListOf<Puerta>()
        for ((clase, cantidad) in tipoSala.cartas){
            for (x in 0..cantidad-1){
                when(clase){
                    "Clases.Enemigo"-> cartasSala.add(Enemigo(generarTier()))
                    "Clases.Item"-> cartasSala.add(Item())
                    "Clases.Puerta"->puertas.add(Puerta(mapaSalas[totalSalasCreadas]!![x]))
                }
            }
        }

        cartasSala.addAll(puertas.distinct())
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