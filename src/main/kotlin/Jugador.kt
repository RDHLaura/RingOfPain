object Jugador {
    //stats principales
    var almas=0
    var vida:Int =12
    var ataque=3
    var defensa=2
    var velocidad=4
    var lucidez=0 //Bonifica el efecto curativo de pociones/aumenta la resistencia a la maldición (50 + lucidez)%/Almas adicionales lucidez*5 %/Permite obtener más recursos

    //varian en función de las stats principales y de los objetos
    var ataqueCritico=0 //porcentaje
    var esquiva= 0 //Aumenta por velocidad (la mitad) y por objetos
    var sigilo=0 //Aumenta por velocidad(la mitad) y por objetos
    var resistencia_maldiciones=50 //si no hay cartas que aumenten este stat directamente se puede eliminar y se usaria la lucidez + 50 %


    fun actulizaStats(item: Item){
        Jugador.vida+=item.vida
        Jugador.ataque+=item.ataque
        Jugador.defensa+=item.defensa
        Jugador.velocidad+=item.velocidad
        Jugador.lucidez+=item.lucidez
        Jugador.ataqueCritico+=item.ataqueCritico + item.lucidez
        Jugador.esquiva+=item.esquiva + (item.velocidad/2)
        Jugador.sigilo+=item.sigilo + (item.velocidad/2)
        Jugador.resistencia_maldiciones+= item.resistencia_maldiciones + item.lucidez
    }

  
    fun eliminaStats(item: Item){
        Jugador.vida-=item.vida
        Jugador.ataque-=item.ataque
        Jugador.defensa-=item.defensa
        Jugador.velocidad-=item.velocidad
        Jugador.lucidez-=item.lucidez
        Jugador.ataqueCritico-=item.ataqueCritico
        Jugador.esquiva-=item.esquiva - (item.velocidad/2)
        Jugador.sigilo-=item.sigilo - (item.velocidad/2)
        Jugador.resistencia_maldiciones-= item.resistencia_maldiciones + item.lucidez
    }



}
