package study.me.please

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun getRandomPsychologyExpression() {
        var input: String? = ""
        while(input != "konec") {
            randomItemFromList(listOf(
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
            ))
            input = readLine()
        }
    }

    private fun randomItemFromList(list: List<Any>) {
        println(list.getOrNull((0..list.size).random()))
    }
}