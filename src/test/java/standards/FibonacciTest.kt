package standards

import org.junit.Assert.assertEquals
import org.junit.Test

class FibonacciTest {

    private val fib = Fibonacci()
    private val expectedMap = mapOf(
            0 to 0,
            1 to 1,
            2 to 1,
            3 to 2,
            4 to 3,
            5 to 5,
            6 to 8)

    @Test
    fun `fibM works as expected`() = test(fib::fibM)


    @Test
    fun `fibT works as expected`() = test(fib::fibT)


    @Test
    fun `fibR works as expected`() = test(fib::fibR)


    fun test(fib: (Int) -> Int) {
        expectedMap.forEach { (index, expected) ->
            assertEquals(expected, fib(index))
        }
    }

}