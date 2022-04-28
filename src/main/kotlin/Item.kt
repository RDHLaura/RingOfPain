import com.sun.jdi.InterfaceType

class Item(
    //para pruebas, a sustituir
    var tipo:String="guantes", //Determina que hueco de inventario ocupa
    var categoria:String="Usable", //Indica si el item es usable o es pasivo o modificador de stats
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


}