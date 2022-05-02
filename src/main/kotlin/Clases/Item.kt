package Clases
import com.sun.jdi.InterfaceType

class Item(
    //para pruebas, a sustituir
    var tipo:String="guantes", //Determina que hueco de inventario ocupa
    var categoria:String="Equipable", //Indica si el item es equipable o es consumible o modificador de stats
    var ataqueCritico: Int =0,
    var vida:Int =0,
    var ataque: Int =0,
    var defensa: Int =0,
    var velocidad: Int =0,
    var lucidez: Int =0,
    var esquiva: Int =0,
    var sigilo: Int =0,
    var resistencia_maldiciones: Int =0,
    var usos:Int=1,
    var cooldown:Int?=null
):  Carta() {

    /*incluir estas funciones en la clase final*/
    fun usarItem(){
        Jugador.vida+=vida
        Jugador.ataque+=ataque
        Jugador.defensa+=defensa
        Jugador.velocidad+=velocidad
        Jugador.lucidez+=lucidez
        Jugador.ataqueCritico+=ataqueCritico + lucidez
        Jugador.esquiva+=esquiva + (velocidad/2)
        Jugador.sigilo+=sigilo + (velocidad/2)
        Jugador.resistencia_maldiciones+= resistencia_maldiciones + lucidez

    }
    fun eliminarItem(){
        Jugador.vida-=vida
        Jugador.ataque-=ataque
        Jugador.defensa-=defensa
        Jugador.velocidad-=velocidad
        Jugador.lucidez-=lucidez
        Jugador.ataqueCritico-=ataqueCritico
        Jugador.esquiva-=esquiva - (velocidad/2)
        Jugador.sigilo-=sigilo - (velocidad/2)
        Jugador.resistencia_maldiciones-= resistencia_maldiciones + lucidez
    }


}