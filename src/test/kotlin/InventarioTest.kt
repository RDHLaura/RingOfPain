import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class InventarioTest {

    @Before
    fun setUp() {
        val guantes=Item(tipo = "Guantes", categoria = "Pasivo", ataqueCritico = 1, vida=1, velocidad = 2)
        Inventario.addObjeto(guantes)
    }

    @Test
    internal fun addObjetos() {
        assertTrue(Inventario.objetos["Guantes"]!=null)
    }

    @Test
    fun espacioOcupado() {
        val guantes2=Item(tipo = "Guantes", categoria = "Pasivo", ataqueCritico = 1, vida=1, velocidad = 2)
        assertTrue(Inventario.espacioOcupado(guantes2))
    }

}