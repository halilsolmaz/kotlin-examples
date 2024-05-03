/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'in şu anki versiyonunda (1.8.21) foksiyon çağırma operatör fonksiyonu yani invoke fonksiyonu
    yazılmış sınıflar türünden değişkenler ile fonksiyon çağırma operatörü kullanılabilir ancak isim fonksiyon olarak
    referans edilemez. IDE'nin mesajına göre bunun ileride ekleneceği öngürülmektedir.

    2.
    Aşağıdaki örnekte bir lambda fonksiyon tanımlanmıştır. Çağrılmamıştır

    - two
    lambda fonksiyon aşağıdaki gibi çağrılabilir.

    - three
    Bu örnek run ile de yapılabilir.

   3.
   Kod sentaksı anlamak için aşağıdaki örnekleri inceleyiniz

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.random.Random

fun main()
{
    println("-------------------------------one--------------------------------")
    one065()
    println("-------------------------------two-one--------------------------------")
    two065one()
    println("-------------------------------two-two--------------------------------")
    two065two()
    println("-------------------------------two-three--------------------------------")
    two065three()
    println("-------------------------------three-one--------------------------------")
    three065one()
    println("-------------------------------three-two--------------------------------")
    three065two()
    println("-------------------------------three-three--------------------------------")
    three065three()
    println("-------------------------------three-four--------------------------------")
    three065four()
}

data class MyNumber(val value:Int) {
    operator fun invoke(): Int
    {
        val x = readInt("Çarpanı giriniz:")

        return value * x
    }
}

fun one065()
{
    val a: Int = readInt("Bir sayı giriniz:")

    val myNumber = MyNumber(a)

    var result: Int = run(myNumber::invoke)

    // result = run(::myNumber) // Error: Unsupported [References to variables aren't supported yet]

    println(result)

    result = myNumber()

    println(result)
}

/*********************************************************************************************************************/

fun two065one()
{
    {
        val a = readInt("Bir sayı giriniz:")

        println(a * a)
    }
}

fun two065two()
{
    {
        val a = readInt("Bir sayı giriniz:")

        println(a * a)
    }()
}

fun two065three()
{
    run {
        val a = readInt("Bir sayı giriniz:")
        println(a * a)
    }
}

/*********************************************************************************************************************/

fun three065one()
{
    println({ a: Int, b: Int -> a + b }(readInt("Birinci sayıyı giriniz:"), readInt("İkinci sayıyı giriniz")))

}

fun three065two()
{
    val result = { a: Int, b: Int -> a + b }(readInt("Birinci sayıyı giriniz:"), readInt("İkinci sayıyı giriniz"))
    //...
    println(result)
}

fun three065three()
{
    val result = { a: Int, b: Int, block: () -> Int -> a + b + block() } (readInt("Birinci sayıyı giriniz:"), readInt("İkinci sayıyı giriniz"))  {val value = Random.nextInt(100); println(value); value}
    //...

    println(result)
}

fun three065four()
{
    val foo = { a: Int, b: Int, block: () -> Int -> a + b + block() }
    val result = foo(readInt("Birinci sayıyı giriniz:"), readInt("İkinci sayıyı giriniz"))  {val value = Random.nextInt(100); println(value); value}
    //...

    println(result)
}