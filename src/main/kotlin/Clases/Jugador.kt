package Clases
object Jugador:Carta () {
    //stats principales
    var almas=0
    var vida:Int =12
    var ataque=3
    var defensa=2
    var velocidad=4
    var lucidez=0 //Bonifica el efecto curativo de pociones/aumenta la resistencia a la maldición (50 + lucidez)%/Almas adicionales lucidez*5 %/Permite obtener más recursos
    var envenenado=false //indica si el jugador está afectado por veneno
    //varian en función de las stats principales y de los objetos
    var ataqueCritico=0 //porcentaje
    var esquiva= 0 //Aumenta por velocidad (la mitad) y por objetos
    var sigilo=0 //Aumenta por velocidad (la mitad) y por objetos
    var resistencia_maldiciones=50 //si no hay cartas que aumenten este stat directamente se puede eliminar y se usaria la lucidez + 50, se usa como %
    var danioPenetrante=0

    fun ataque(enemigo: Enemigo){
        //el daño que hace teenienddo en cuenta la defensa
        if(enemigo.defensa>Jugador.ataque){
            var danioDefensa=0
            enemigo.vidaActual=enemigo.vidaActual- danioPenetrante}
        else{
            var danioDefensa=Jugador.ataque-enemigo.defensa
                if((0..100).random()<=Jugador.ataqueCritico){danioDefensa*=2}
            enemigo.vidaActual=enemigo.vidaActual-(danioDefensa)- danioPenetrante }
    }




}