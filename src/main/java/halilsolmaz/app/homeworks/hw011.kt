/*-----------------------------------------------------------------------------------------------------
    Parametresi ile aldığı Long türden ve Int türden bir sayının basamaklarından oluşan diziyi döndüren digits fonksiyonunu
	yazınız ve test ediniz

	Not: Sayı negatif olsa bile basamak değerleri pozitif olacaktır
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks

import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.math.abs
import kotlin.math.log10
import kotlin.random.Random

fun main()
{
    runDigitsIntTest()
    runDigitsLongTest()
}

fun runDigitsLongTest()
{
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val value = Random.nextLong();
        print("$value -> ")
        write(digits(value))
    }
}

fun runDigitsIntTest()
{
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val value = Random.nextInt();
        print("$value -> ")
        write(digits(value))
    }
}

fun countDigits(value: Long) = if (value == 0L) 1 else log10(abs(value).toDouble()).toInt() + 1
fun countDigits(value: Int) = countDigits(value.toLong())

fun digits(value: Long) : IntArray
{
    val arr = IntArray(countDigits(value))
    var temp = abs(value)

    for (i in arr.size -1 downTo  0) {
        arr[i] = (temp % 10).toInt()
        temp /= 10
    }

    return arr
}

fun digits(value: Int) = digits(value.toLong())