/*-----------------------------------------------------------------------------------------------------
    1.
    Bazı fonksiyonlar içeride yapacakları işlemlerin detaylarını dışarıdan alırlar. Bu kavrama callable ya da callback
    denilmektedir.

    Java dünyasında bu kevram abstract sınıflar ya da interface'ler ile ilgili metotlarının override
    edilmesiyle gerçekleştirilir. Yani metodun ilgili parametresi genel olarak bir interface ya da abstract class türden olur
    ve bu metodu çağıran programcı ilgili referansa o referansa ilişkin sınıfsa türetilmiş interface ise implemente edilmiş
    bir sınıfa nesnenin adresini (referansını) verir ve metot da ilgili sanal metodu çağırarak aslında nasıl yapacağını
    bilmeden yazılmış olur.

    Bu tarz metotlara (fonksiyonlara) programlama dillerinde genel olarak "High Order Function (HOF)"
    denir. Kotlin'de HOF'lar genel olarak function türleri ile yazılır. Şüphesiz interface kullanılarak da yazılabilir.

    Kotlin'de bir fonksiyonun son parametresi function türündense ve bu parametreye bir lambda function geçilecekse
    bu durumda bu lambda function fonksiyon çağırma operatöründen sonra yazılabilir. Ayrıca fonksiyon tek parametreli
    ise ve fonksiyonun o tek parametresi de bir function türünden ise hiç fonksiyon çağırma operatörü kullanmadan doğrudan
    lambda function yazılabilir.

    2.
    Aşağıdaki HOF'lar durumu göstermek için detaylar gözardı edilerek yazılmıştır. Metodun kodunun detaylı ve iyi olarak
    nasıl yazılması gerektiğine değil callback/callable kavramlarına odaklanınız

    Aşağıdaki copyIf extension fonksiyonu parametresi ile aldığı koşula uyan elemanlardan oluşan yeni bir dizi referansına
    geri dönmektedir

    3.
    two061 da ki şöyle de yapılabilir. Aşağıdaki copyIf extension fonksiyonu parametresi ile aldığı koşula uyan
    elemanlardan oluşan yeni bir dizi referansına geri dönmektedir. Örnekte son parametre olan function türünden
    parametreye geçilen lambda function fonksiyon çağırma operaytöründen sonra yazılmıştır. Bu tarz durumlarda bu
    çağırma biçimi tavsiye edilir.

    4.
    two061 da ki şöyle de yapılabilir.

    5.
    Aynı örnek için write func yerine forEach callback func yazılmıştır.

    6.
    Aynı örneğe transform metodu callback yapacak şekilde eklenmiştir.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.homeworks.write
import halilsolmaz.app.util.array.kotlin.randomIntArrayFnc
import halilsolmaz.app.util.array.kotlin.writeFnc
import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.number.isPrime
import kotlin.random.Random

fun main()
{
    println("-------------------------------two-----------------------------------")
    two061()
    println("-------------------------------three-----------------------------------")
    three061()
    println("-------------------------------four-----------------------------------")
    four061()
    println("-------------------------------five-----------------------------------")
    five061()
    println("-------------------------------six-----------------------------------")
    six061()
}

fun two061()
{
    val count = readInt("Bir sayı giriniz:")
    val a = Random.randomIntArrayFnc(count, 0, 100)

    a.writeFnc(2)

    val primes = IntArray(a.size)

    val n = a.copyIf(primes, {it.toLong().isPrime()})

    primes.writeFnc(n, 2)
}

fun IntArray.copyIf(dest: IntArray, predicate: (Int) -> Boolean) : Int
{
    var idx = 0

    for (value in this)
        if (predicate(value))
            dest[idx++] = value

    return idx
}

/*********************************************************************************************************************/

fun three061()
{
    val count = readInt("Bir sayı giriniz:")
    val a = Random.randomIntArrayFnc(count, 0, 100)

    a.writeFnc(2)

    val primes = IntArray(a.size)

    val n = a.copyIf(primes) { it.toLong().isPrime() }

    primes.writeFnc(n, 2)
}

/*********************************************************************************************************************/

fun four061()
{
    val count = readInt("Bir sayı giriniz:")
    val a = Random.randomIntArrayFnc(count, 0, 100)

    a.writeFnc(2)

    val primes = IntArray(a.size)
    val f: (Int) -> Boolean = {it.toLong().isPrime()}

    val n = a.copyIf(primes, f)

    primes.writeFnc(n, 2)
}

/*********************************************************************************************************************/

fun five061()
{
    val count = readInt("Bir sayı giriniz:")
    val a = Random.randomIntArrayFnc(count, 0, 100)

    a.forEach { print("%02d ".format(it)) }

    val primes = IntArray(a.size)

    val n = a.copyIf(primes) {it.toLong().isPrime()}

    println()

    primes.forEach { print("%02d ".format(it)) }
    println();
}

fun IntArray.forEach(block: (Int) -> Unit)
{
    for (value in this)
        block(value)
}

/*********************************************************************************************************************/

fun six061()
{
    val count = readInt("Bir sayı giriniz:")
    val a = Random.randomIntArrayFnc(count, 0, 100)

    a.forEach { print("%02d ".format(it)) }
    println()

    val squares = a.transform { it * it }

    squares.forEach { print("$it ") }
    println()
}

fun IntArray.transform(block: (Int) -> Int) : IntArray
{
    val result = IntArray(this.size)

    for (i in this.indices)
        result[i] = block(this[i])

    return result
}