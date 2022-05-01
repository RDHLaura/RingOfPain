
class Puerta(var tipoSalas:TipoSalas):Carta (){

    fun usarPuerta(){ //llamar a esta función cuando el jugador seleccione la puerta
        GameManager.siguienteSala(tipoSalas)
    }
}