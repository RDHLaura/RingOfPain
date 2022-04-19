import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class JugadorTest {
    @Before
    fun setUp() {
        val guantes=Item(tipo = "Guantes", categoria = "Pasivo", ataqueCritico = 1, vida=1, velocidad = 2)
        Inventario.addObjeto(guantes)
    }

    @Test
    internal fun usarItem() {
        assertEquals(Jugador.vida,13)
    }

    @Test
    internal fun JugadorSigilo(){
        assertEquals(Jugador.sigilo,1)
    }

    @Test
    internal fun eliminarItem() {
        //sustituyo por otro item
        val guantes2=Item(tipo = "Guantes", categoria = "Pasivo",defensa=2, lucidez = 1)
        Inventario.addObjeto(guantes2)
        assertEquals(Jugador.vida,12)
        assertEquals(Jugador.defensa,4)
        assertEquals(Jugador.resistencia_maldiciones, 51)
    }
}