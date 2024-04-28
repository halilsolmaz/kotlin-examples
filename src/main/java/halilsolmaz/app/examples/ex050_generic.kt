/*-----------------------------------------------------------------------------------------------------
    1.
    Aşağıdaki örnekte Kotlin invariant özelliğe sahip olduğundan error oluşur.

    2.
    Generic bir sınıfın generic parametresi out ile bildirildiğinde covariant özellik kullanılabilir.

    3.
    Aşağıdaki örnekte sınıf contravariant değildir. Açılım contravariant yapılmıştır.

    4.
    Aşağıdaki örnekte sınıf contravariant yapılmıştır

    5.
    out ve in anahtar sözcükleri eğer sınıfın bildiriminde yazılacaksa sınıfın property elemanları immutable olmalıdır.

    6.
    Generic parametrelere kısıtlar verilebilir. Aşağıdaki örnekte Kample sınıfının T generic parametresinin türünün
    Closeable arayüzünü destekkleyen bir tür ile açılımı zorunludur. Bu kısıta aynı zamanda üstten sınır (upper bound)
    da denilmektedir
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import java.io.Closeable
import java.io.FileOutputStream
import java.lang.*

fun main()
{
    println("-------------------------------one-two-----------------------------------")
    oneTwo050()
    println("-------------------------------three-----------------------------------")
    three050()
    println("-------------------------------four-----------------------------------")
    four050()
    println("-------------------------------five-----------------------------------")
    five050()
    println("-------------------------------six-----------------------------------")
    six050()
}

fun oneTwo050()
{
    val s = Sample050(Integer.valueOf(10));
    // foo050_one(s) // Error

    val s1 = Mample050(Integer.valueOf(10));
    foo050_two(s1)
}

fun foo050_one(s: Sample050<Number>)
{
    println(s.x.toShort())
}

fun foo050_two(s: Mample050<Number>)
{
    println(s.x.toShort())
}

class Sample050<T>(var x: T)

class Mample050<out T>(val x: T)

/**********************************************************************************************************************/

fun three050()
{
    val s = Cample050<Number>();

    coo050(s)
}

fun coo050(s: Cample050<in Integer>)
{
    println(s.x)
}

class Cample050<T>(var x: T? = null)

/********************************************************************************************************************/

fun four050()
{
    val s = Dample050<Number>();

    doo050(s)
}

fun doo050(s: Dample050<Integer>)
{
    println(s)
}

class Dample050<in T> {
    //...
}

/********************************************************************************************************************/

fun five050()
{
    val s = Hample050(65)

    val m = Mest050();

    m.hoo050(s)
}

class Mest050 {
    fun hoo050(s: Hample050<Number>)
    {
        println(s.x.toChar())
    }
}
class Hample050<out T>(val x: T) // Eğer var olsaydı Error oluşurdu.

/********************************************************************************************************************/

fun six050()
{
    val s = Kample050<FileOutputStream, Int>()

    s.koo050(FileOutputStream("text.dat"))
}

class Kample050<T: Closeable, K> {
    fun koo050(t: T)
    {
        //...
        t.use {
            //...
        }
    }
}
