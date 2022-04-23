import GameManager
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

 internal class GameManagerTest{

    val e1 = Enemigo()
    val e2 = Enemigo()
    val e3 = Item()
    val e4 = Enemigo()
    val e5 = Enemigo()

    val lista = mutableListOf<Carta>(e1,e2,e3,e4,e5)
    val lista2 = mutableListOf<Carta>(e1)
    val lista3 = mutableListOf<Carta>(e1,e2)

    @Test
    fun anterior() {
        GameManager.siguienteSala(TipoSalas.ESTANDAR)
        assertEquals(GameManager.anterior(GameManager.salaActual.cartasSala[0]),GameManager.salaActual.cartasSala[5])

    }

    @Test
    fun siguiente() {
        assertEquals(GameManager.anterior(GameManager.salaActual.cartasSala[0]),GameManager.salaActual.cartasSala[1])
    }

    @Test
    fun adyacentes() {
        assertEquals(GameManager.adyacentes(GameManager.salaActual.cartasSala[0]), mutableListOf( GameManager.salaActual.cartasSala[1]))
    }

    @Test
    fun explotarTodosUnItem() {
        GameManager.explotar(GameManager.salaActual.cartasSala[0] as Enemigo)
        assertEquals(GameManager.salaActual.cartasSala.size,5)
        GameManager.explotar(GameManager.salaActual.cartasSala[0] as Enemigo)
        assertEquals(GameManager.salaActual.cartasSala.size,1)
    }

}