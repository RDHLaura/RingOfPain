
enum class  TipoSalas (

    var cartas:MutableMap<String, Int>,
    var num_cartas_sala:Int,
    var nivel_sala:Int, //con el nivel de la sala crear un selector para items y enemigos
    var salasRestantes:Int

        ){

    //Revisar esto, no me gusta


    ESTANDAR(mutableMapOf("Clases.Enemigo" to 6,
                            "Clases.Item" to 3,
                             "Clases.Puerta" to 3,
                             /*"Pocion" to 2,
                             "boost_stat" to 1,
                             "Tesoro" to 1,*/
    ), 12, 1, 15),
    GUARDIAS(mutableMapOf("Clases.Item" to 1, //tesoro
        "Clases.Enemigo" to 8),9, 1, 1), //mirar cuantas cartas son
    TIENDA (mutableMapOf("Clases.Item" to 3), 3, 1, 4),
    Finders_Keepers(mutableMapOf("Clases.Item" to 1), 1, 1, 2),
    FINAL (mutableMapOf("Clases.Enemigo" to 1), 1, 1, 1),
    AGRESIVIDAD(mutableMapOf("Clases.Enemigo" to 8,
        "Clases.Item" to 2
        /* "Clases.Puerta" to 2,
         "Pocion" to 2,
         "boost_stat" to 1,
         "Tesoro" to 1,*/
    ), 12, 1, 15),

}