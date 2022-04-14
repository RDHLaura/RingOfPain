object Jugador {
    //stats principales
    var almas=0
    var vida:Int =12
    var ataque=3
    var defensa=2
    var velocidad=4
    var lucidez=0 //Bonifica el efecto curativo de pociones

    //varian en función de las stats principales y de los objetos
    var ataqueCritico=0 //porcentaje
    var esquiva= 0 //Aumenta por velocidad (la mitad) y por objetos
    var sigilo=0 //Aumenta por velocidad(la mitad) y por objetos
    var multiplicador_almas=0 //porcentaje que aumenta las almas adicionales
    var resistencia_maldiciones=50



    fun actulizaStats(carta: Carta){
        Jugador.vida+=carta.vida
        Jugador.ataque+=carta.ataque
        Jugador.defensa+=carta.defensa
        Jugador.velocidad+=carta.velocidad
        Jugador.lucidez+=carta.lucidez
        Jugador.ataqueCritico+=carta.ataqueCritico + carta.lucidez
        Jugador.esquiva+=carta.esquiva + (carta.velocidad/2)
        Jugador.sigilo+=carta.sigilo + (carta.velocidad/2)
        Jugador.resistencia_maldiciones+= carta.resistencia_maldiciones + carta.lucidez

    }
    fun eliminaStats(carta: Carta){
        Jugador.vida-=carta.vida
        Jugador.ataque-=carta.ataque
        Jugador.defensa-=carta.defensa
        Jugador.velocidad-=carta.velocidad
        Jugador.lucidez-=carta.lucidez
        Jugador.ataqueCritico-=carta.ataqueCritico
        Jugador.esquiva-=carta.esquiva
        Jugador.sigilo-=carta.sigilo

    }



}