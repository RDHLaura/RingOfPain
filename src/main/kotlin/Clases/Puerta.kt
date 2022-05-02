package Clases
class Puerta(var tipoSalas:TipoSalas):Carta (){

    fun usarPuerta(){
        GameManager.siguienteSala(tipoSalas)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Puerta

        if (tipoSalas != other.tipoSalas) return false

        return true
    }

    override fun hashCode(): Int {
        return tipoSalas.hashCode()
    }

}