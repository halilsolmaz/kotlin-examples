/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'de bir User Defined Type'a (sınıf, interfacec vb.) ve temel türlere ilişkin bir sınıfa programcı fonksiyonlar
    ekleyebilir. Yani adeta sınıf bildirimine ekleme yapmış gibi fonksiyonlar yazılabilir. Bu tarz fonksiyonlara
    "extension functions" denir.

    one042'de fun Int.square() = this * this ile Int sınıfına square fonksiyonu eklendi.

    2.
    numberUtil sınıfı, extension functionlar kullanarak eklendi.

    Not: Sınıfta aynı isimli bir metod varsa ne olur?
    -

    3.
    infix fonksiyonlar: Fonksiyonlar infix fonksiyon olarak bildirilebilir. infix fonksiyonlar bir parametreli
    extension fonksiyon veya sınıfın üye fonksiyonu (metot) olmalıdır. Aşağıdaki örnek infix fonksiyonu göstermek için yazılmıştır.
    infix fonksiyonlar iki operandlı bir operatör biçiminde kullanılabilir. Bu durumda fonksiyon ismi operandlarının
    arasında kullanılabilir. Bu durumda fonksiyonun geri dönüş değeri infix olarak yazılan ifadenin değeri. Yani yine
    fonksiyon çağrılmış olur.

    4.
    Her iki parametreli fonksiyon infix fonksiyon olarak yazılmalı mıdır?
    Bu tamamen fonksiyona bağlıdır. Gereksiz yere infix fonksiyon yazmak veya infix olması iyi bir tasarım olan fonksiyonu
    infix yapmamak kötü teknik olarak düşünülebilir
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.number.isPrime
import halilsolmaz.app.util.number.numToStr3DigitsTR
import kotlin.random.Random

fun main()
{
    println("-------------------------------one-----------------------------------")
    one042()
    println("-------------------------------two-----------------------------------")
    two042()
    println("-------------------------------three---------------------------------")
    three042()
}

fun one042()
{
    while (true) {
        val a = readInt("Bir sayı giriniz:")

        println(a.square())
        if (a == 0)
            break
    }
}

fun Int.square() = this * this

fun two042()
{
    for (n in 0L..100)
        if (n.isPrime())
            print("$n ")

    println()
    println("-------------------")

    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val value = Random.nextInt(-999, 1000)
        println("$value -> ${value.numToStr3DigitsTR()}")
    }

}

fun three042()
{
    val a = readInt("Bir sayı giriniz:")
    val b = readInt("Bir sayı daha giriniz:")

    println(a add b)
    println(a.add(b))

    val op = Operation(a)

    println(op add b)
    println(op.add(b))
}

infix fun Int.add(b: Int) = this + b

class Operation(val a: Int) {
    infix fun add(b: Int) = a + b
}
