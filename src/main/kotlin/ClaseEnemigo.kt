enum class ClaseEnemigo(
    var nombre:String,
    var vitalidad:Int,
    var danioFisico: Int,
    var danioPenetrante: Int,
    var velocidad: Int,
    var defensa:Int,
    var almas: Int,
    var efectoAlMorir: Efecto?,
    var tipoDanioEspecial: TipoDanio?,
    var danioEspecial: Int,
    var tier: Int

) {
    EsporaExplosiva("Espora Explosiva",2,0,1,4,1,1,Efecto.EXPLOSION,TipoDanio.EXPLOSION,4,1),
    GnollLadron("Gnoll ladrón",10,3,2,5,3,1,Efecto.TESORO,null,0,1),
    Escorpion("Escorpión",3,2,1,10,0,1,null,TipoDanio.VENENO,1,1),
    Zombie("Zombie",4,4,0,3,1,1,null,null,0,1),
    Ghoul("Ghoul",6,4,1,5,1,2,null,null,0,1),
    EsporaVenenosa("Espora venenosa",2,1,1,5,0,3,Efecto.EXPLOSIONVENENOSA,TipoDanio.VENENO,4,2),
    Barghest("Barghest",12,7,2,6,12,4,null,TipoDanio.PUAS,6,2),
    DeminoPequenio("Demonio Pequeño",8,4,3,9,1,4,null,null,0,2),
    CaballeroCaido("Caballero caido",6,6,2,8,2,3,null,null,0,2),
    LanceroVenenoso("Lancero venenoso",6,3,0,14,3,4,null,TipoDanio.VENENO,3,2),
    MastinPutridoEnorme("Mastin Putrido Enorme",18,12,2,12,3,5,null,null,0,2),
    Ifrit("Ifrit",20,6,2,11,0,5,Efecto.EXPLOSION,TipoDanio.EXPLOSION,20,2),
    Gargola("Gargola",26,7,2,8,5,6,null,null,0,3),
    PerroInfernal("Perro Infernal",20,11,3,9,3,6,null,null,0,3),
    Hipogrifo("Hipogrifo",36,6,4,12,8,6,null,null,0,3),
    CaballeroFlamigero("Caballero Flamígero",25,7,3,6,6,5,Efecto.EXPLOSION,TipoDanio.EXPLOSION,6,4),
    Pesadilla("Pesadilla",30,8,2,14,8,20,null,null,0,4),
    Archidemonio("Archidemonio",45,13,3,8,10,25,null,TipoDanio.PUAS,2,4),
    ReyLich("Rey Lich",110,20,5,13,12,50,null,null,0,5)


}