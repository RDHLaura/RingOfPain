enum class TipoSalas (
    /*In each run, there are 15 main dungeon rooms, 2 Finders Keepers, 4 Shops and a floor 16 (?) ending floor,
     plus optional event dungeons that the player can choose to visit, and boss dungeon(s) - varying on which ending is taken.*/
    cartas:MutableMap<String, MutableList<Carta>>
        ){

    //Revisar esto, no me gusta
    PRINCIPAL(mutableMapOf("enemigos" to mutableListOf<Carta>(),
                            "items" to mutableListOf<Carta>(),
                            "puertas" to mutableListOf<Carta>())),
    GUARDIAS(mutableMapOf("tesoro" to mutableListOf<Carta>())),
    TIENDA (mutableMapOf("enemigos" to mutableListOf<Carta>())),
    FINAL (mutableMapOf("enemigos" to mutableListOf<Carta>()))

}