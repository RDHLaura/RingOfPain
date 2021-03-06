package Clases
object Inventario {

    var objetos= mutableMapOf<String,Item?>(
        "Vela" to null,"Casco" to null,"Peto" to null, "Guantes" to null,
        "Pantalon" to null, "Botas" to null, "Escudo" to null, "Arma" to null,
        "Mascara" to null, "Bote" to null, "Collar" to null, "Amuleto" to null,
        "Piedra" to null, "Libro" to null, "Pergamino" to null)


    fun espacioOcupado(item:Item):Boolean{return objetos[item.tipo] != null}/*para preguntar al usuario si quiere reemplazar el objeto por el nuevo, si es así llamar a la funcion addObjeto*/

    fun usarOjetoConsumible(item: Item){//faltaría por añadir el uso de turnos en el cooldown y se podría usar para pergaminos y para libros
        if(item.categoria=="Consumible" && item.usos>0){
            item.usarItem() //modificarla para los casos en que sea efectos especiales TODO
            item.usos--
            if(item.usos<=0 && item.cooldown==null){ objetos[item.tipo]=null}//si no tiene usos restante y no tiene cooldown(para el caso en el que los usos se recargan) se elimina del inventario
        }
    }


    fun addObjeto(item: Item){ //añade el objeto al inventario
        //Comprueba si el item es usable o pasivo y si el espacio en inventario para esa carta está libre o
        //en caso contrario reemplazar eliminando los stats de esa carta al jugador
        if(item.categoria=="Usable"){
            objetos[item.tipo]=item
        }else{
            if(espacioOcupado(item)==false){
                objetos[item.tipo]=item
                item.usarItem()
            }else{
                objetos[item.tipo]!!.eliminarItem()
                objetos[item.tipo]=item
                item.usarItem()
            }
        }
    }


}