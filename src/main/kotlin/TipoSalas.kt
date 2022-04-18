enum class  TipoSalas (

    var cartas:MutableMap<String, Int>,
    var num_cartas_sala:Int
        ){

    //Revisar esto, no me gusta
    PRINCIPAL(mutableMapOf("enemigo" to 5,
                            "item" to 1,
                            "puerta" to 2,
                            "pocion" to 2,
                            "boost_stat" to 1,
                            "tesoro" to 1,
                            ), 12),
    GUARDIAS(mutableMapOf("tesoro" to 1,
                            "enemigo" to 8),9), //mirar cuantas cartas son
    TIENDA (mutableMapOf("item" to 3), 3),
    Finders_Keepers(mutableMapOf("item" to 1), 1), //quien lo encuentra se lo queda
    FINAL (mutableMapOf("enemigos" to 1), 1)

}