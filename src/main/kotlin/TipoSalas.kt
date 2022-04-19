enum class  TipoSalas (

    var cartas:MutableMap<Carta, Int>,
    var num_cartas_sala:Int,
    var nivel_sala:Int, //con el nivel de la sala crear un selector para items y enemigos
    var salasRestantes:Int
        ){

    //Revisar esto, no me gusta
    PRINCIPAL(mutableMapOf(Enemigo() to 5,
                            Item() to 1
                           /* "Puerta" to 2,
                            "Pocion" to 2,
                            "boost_stat" to 1,
                            "Tesoro" to 1,*/
                            ), 12, 1, 15),
    GUARDIAS(mutableMapOf(Item() to 1, //tesoro
                            Enemigo() to 8),9, 1, 1), //mirar cuantas cartas son
    TIENDA (mutableMapOf(Item() to 3), 3, 1, 4),
    Finders_Keepers(mutableMapOf(Item() to 1), 1, 1, 2),
    FINAL (mutableMapOf(Enemigo() to 1), 1, 1, 1)
}