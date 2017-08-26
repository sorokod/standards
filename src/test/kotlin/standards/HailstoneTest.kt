package standards

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test


class HailstoneTest {

    private val stoppinNumbers = mapOf(
            1 to 1,
            4 to 3,
            27 to 112,
            77031 to 351,
            837799 to 525)


    @Test
    fun `test Stopping Number`() {
        stoppinNumbers.forEach { (index, expected) ->
            assertEquals(expected, stoppingNumber(index.toLong(), 1))
        }
    }


    @Test
    fun `test Max Stopping Number 100 000`() {
        assertEquals(Pair(77031, 351), maxStoppingNumber(100_000))
    }


    @Test
    fun `test Max Stopping Number 1 000 000`() {
        assertEquals(Pair(837799, 525), maxStoppingNumber(1_000_000))
    }

}