/*-----------------------------------------------------------------------------------------------------
    1.
    as? tür dönüştürme operatörü güvenli dönüşüm için kullanılabilmektedir.

    one040 da createRandomA metodu null döndürdüğünde as? operatörü de null değer üretecektir. Bu
    durum da exception oluşmayacağı gibi foo metodu da çağırılmayacaktır.

    Not: Aynı kod java da yazılmış olsaydı. null döndüğünde NPE fırlatılırdı.

    2.
    Birinci example'ın aynısı, smart cast ile yapılmıştır

    3.
    !! operatörü nullable type'dan normal türe dönüşüm için kullanılabilir fakat NPE fırlatabilir.
    !! operatörü derleyiciye şunu der: Ben null dönmeyeceğini garanti ettim, eğer null dönerse sen
    exception fırlatabilrsin.

    Not: null pointer exception(NPE) 'nin try catch ile handle edilmesi pek tavsiye edilmez.

    4.
    four040 da programcı createAByValue metoduna geçilen argümanlar ile birlikte null döndürmeyeceğini garanti
    atına aldığından NPE hiç oluşmaz.
    Örneği createAByValue metoduna null döndürebilecek değerleri de arguman verip sonucu gözlemleyiniz.

    5.
    kotlin.io paketi içerisinde bulunan readLine fonksiyonu String? türüne geri döner
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.random.Random


fun main()
{
    println("-------------------------------one-----------------------------------")
    one040()
    println("-------------------------------two-----------------------------------")
    two040()
    println("-------------------------------four-----------------------------------")
    four040()
    println("-------------------------------five-----------------------------------")
    five040()
}

fun one040()
{
    for (i in 1..readInt("Input a number:")) {
        val a: A040? = createRandomA()
        val b: B040? = a as? B040

        println("----------------------")
        println("b -> $b")
        b?.foo()
        println("----------------------")
    }
}

fun two040()
{
    for (i in 1..readInt("Input a number:")) {
        val a: A040? = createRandomA()
        val b: B040? = a as? B040

        if (b != null)
            b.foo()
        else
            println("null pointer")
    }
}
fun createRandomA(random: Random = Random) : A040?
{
    return when (random.nextInt(3)) {
        1 -> A040()
        2 -> B040()
        else -> null
    }
}
open class A040 {
    fun foo()
    {
        println("foo")
    }
}

class B040 : A040() {
    val x = 10
}

fun four040()
{
    for (i in 1..readInt("Input a number:")) {
        val a: AA040 = createAByValue(Random.nextInt(1, 3))!!

        a.foo()
    }
}

fun createAByValue(value: Int) : AA040?
{
    return when (value) {
        1 -> AA040()
        2 -> BB040()
        else -> null
    }
}
open class AA040 {
    fun foo()
    {
        println("foo")
    }
}

class BB040 : AA040() {
    val x = 10
}

fun five040()
{
    print("Bir yazı giriniz:")
    val s = readLine()!! // artık yerine readln() kullanılır.

    println(s.uppercase())
}
