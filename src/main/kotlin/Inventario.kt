object Inventario {
    //Para pruebas
    var carta1=Carta()
    var carta2=Carta()
    //empieza la clase
    var objetos= mutableMapOf<String,Item?>(
        "Vela" to null,"Casco" to null,"Peto" to null, "Guantes" to null,
        "Pantalon" to null, "Botas" to null, "Escudo" to null, "Arma" to null,
        "Mascara" to null, "Bote" to null, "Collar" to null, "Amuleto" to null,
        "Piedra" to null, "Libro" to null, "Pergamino" to null)


    fun addObjeto(item: Item){
        //Hay que comprobar si el espacio en inventario para esa carta está libre o en caso contrario reemplazar eliminando los stats de esa carta del jugador
        if(objetos[item.tipo]==null){
            objetos[item.tipo]=item
            Jugador.actulizaStats(item)
        }else{
            Jugador.eliminaStats(objetos[item.tipo]!!)
            objetos[item.tipo]=item
            Jugador.actulizaStats(item)
        }
    }

}