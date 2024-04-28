/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'de referans türlerine bile null atanamaz.

    var p: Person = null //error

    Not: Java da atanabilir.

    2.
    Kotlin de null erişiminin bilinçli yapılması ve exception oluşmaması için nullable type vardır.

    3.
    Kotlin'de T bir tür olmak üzere T? nullable type olarak adlandırılır.

        var s : Person? = null

    Kotlin'de temel türler sınıf olarak bildirildiğinden temel türlere ilişkin sınıflar türünden nullable referanslar da
    olabilir.

        var a : Int? = null

    4.
    Kotlin'de nullable bir referans ile o referansa ilişkin sınıfın elemanlarına nokta operatörü erişilemez.
    Kotlin'de nullable bir referans ile ?. operatörü kullanılarak elemanlara erişilebilir.

    5.
    ?. operatörünün kullanımında  hiç bir zaman NullPointerException (NPE) fırlatılmasına yol açmaz.

    6.
    Elvis Operatörü(?:): Bu operatör aslında "null coalecing operatör"'dür. Ancak Elvis Presley'nin gözleri ve saçına
    benzetildiği için "Elvis operator" de denilmektedir.

    Not: Nullable referans ve null check çok fazla kullanıldığı için böyle bir operator dile eklenmiştir.

    7.
    seven039 da if deyiminin doğru kısmında a'nın null olamayacağını derleyici anlamış ve smart cast yapılmıştır


-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.homeworks.write
import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.random.Random

fun main()
{
    println("-------------------------------four-----------------------------------")
    four039()
    println("-------------------------------five-----------------------------------")
    five039()
    println("-------------------------------six-----------------------------------")
    six039()
    println("-------------------------------seven-----------------------------------")
    seven039()
}

fun four039()
{
    val s : String? = "ankara"

    // println(s.length) //Error
    println(s?.length)
}

fun five039()
{
    for (i in 1..readInt("Bir sayı giriniz:")) {
        val s: String? = randomText()
        val len: Int? = s?.length

        println(if (len != null) len else "text üretilemedi")
    }
}

fun six039()
{
    for (i in 1..readInt("Bir sayı giriniz:")) {
        val s: String? = randomText()
        val len: Int? = s?.length

        println(len ?: "text üretilemedi")
    }
}

fun randomText(random: Random = Random) = if (random.nextBoolean()) getRandomTextEN025V2(10) else null

fun seven039()
{
    val n = readInt("n:")
    val min = readInt("min:")
    val max = readInt("max:")
    val a = randomIntArray(n, min, max)

    //println("Length of an array:${a?.size}") // null kontrolü olmasaydı böyle kullanılmalıydı
    if (a != null) {
        println("Length of an array:${a.size}") // smart cast
        write(a)
    }
    else
        println("Invalid Values")
}

fun randomIntArray(n: Int, min: Int, max: Int) : IntArray?
{
    if (n <= 0 || min > max)
        return null

    val result = IntArray(n)

    for (i in result.indices)
        result[i] = Random.nextInt(min, max)

    return result
}