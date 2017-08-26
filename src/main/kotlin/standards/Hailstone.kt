package standards

import kotlin.system.measureTimeMillis


fun next(n: Long): Long =
        if (n and 1 == 0L) n / 2 else n * 3 + 1


tailrec fun stoppingNumber(n: Long, ctr: Int): Int =
        if (n == 1L) ctr else stoppingNumber(next(n), ctr + 1)


fun maxStoppingNumber(upperBound: Int): Pair<Int, Int> {

    tailrec fun maxStoppingNumber(current: Int, max: Int, maxi: Int): Pair<Int, Int> {
        val s = stoppingNumber(current.toLong(), 1)

        return when {
            s == 1 -> Pair(maxi, max)
            (s > max) -> maxStoppingNumber(current - 1, s, current)
            else -> maxStoppingNumber(current - 1, max, maxi)
        }
    }

    return maxStoppingNumber(upperBound, 0, 0)
}


fun main(args: Array<String>) {
    println(
            measureTimeMillis {
                println("(n, stop-number) = ${maxStoppingNumber(1_000_000)}")
            }
    )
}