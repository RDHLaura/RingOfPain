
class Puerta(var tipoSalas:TipoSalas):Carta (){


    fun usarPuerta(){
        GameManager.siguienteSala(tipoSalas)
    }
}