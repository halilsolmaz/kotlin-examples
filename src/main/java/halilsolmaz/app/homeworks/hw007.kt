/*-----------------------------------------------------------------------------------------------------
    Parametresi ile aldığı iki yazıdan birincisi içerisinde ikincisinden kaç tane olduğunu döndüren
    countString isimli fonksiyonu ignoreCase parametresi de içerecek şekilde yazınız
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks
import kotlin.random.Random

fun main() = runCountStringTest()

fun runCountStringTest()
{
    while (true) {
        print("Input the first text:")
        val s1 = readln()

        if (s1 == "quit")
            break

        print("Input the second text:")
        val s2 = readln()

        val ignoreCase = Random.nextBoolean()

        println(if (ignoreCase) "case insensitive" else "case sensitive")
        println("Count:${countString(s1, s2, ignoreCase)}")
    }
}

fun countString(s1: String, s2: String, ignoreCase: Boolean = false) : Int
{
    var idx = -1
    var count = 0

    while (true) {
        idx = s1.indexOf(s2, idx + 1, ignoreCase = ignoreCase)
        if (idx == -1)
            break
        count++
    }

    return count
}

// araban çok güzel çok çok ve Çok.