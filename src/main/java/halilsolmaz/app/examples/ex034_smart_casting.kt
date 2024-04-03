/*-----------------------------------------------------------------------------------------------------

    1.
    Any sınıfı tüm sınıfların doğrudan ya da dolaylı olarak taban sınıfı biçimindedir. Java ve C# daki Object sınıfının
    Kotlin'deki karşılığıdır. Bu durumda Kotlin'de tüm referanslar Any türden bir referansa doğrudan (implicit) olarak
    atanabilir.

    2.
    Temel türler de bir sınıf olarak temsil edildiğinden Kotlin anlamında zaten kutulama (boxing) yapılmış olur.
    Ancak aşağı seviyede kutulama (Java anlamında kutulama da denebilir) Any sınıfına atamada gerçekleşir.

    3.
    Anımsanacağı gibi bir referansın dinamik türünün bir türü kapsayıp kapsamadığı instanceof operatörü ile test
    edilebilir. Bu operatör "downcasting" işleminin güvenli bir biçimde yapılabilmesi için kullanılır. Kotlin'de
    bu işlem is ve !is operatörü ile yapılabilir. is operatörü instance of operatörüne karşılık gelir. !is operatörü de
    Java'da aşağıdaki bir kontrolün karşılığı olarak düşünülebilir:
        if (!(a instanceof T))
            ...
     Kotlin'deki karşılığı:
        if (a !is T)
            ...
     Bu operatörün kullanımına ilişkin bazı  detaylar ileride ele alınacaktır.

     4.
     Kotlin'de akıllı dönüşüm (smart cast) denilen bir kavram vardır. Derleyici downcasting ya da unboxing durumlarında
     hedef türe dönüştürmenin güvenli olduğunu anlarsa as operatörüne gerek kalmaksınız dönüşüme ilişkin kod derleme zamanında
     otomatik olarak yazılır. Akıllı dönüşüm diğer detaylarıyla birlikte ileride ele alınacaktır.

     5.
     Any türünden bir dizide heterojen türler tutulabilir. is operatörü ile de dinamik tür kontrolü yapılabilir.

     Anahtar Notlar: Kotlin'de referans dizileri Array isimli generic bir sınıf ile yaratılabilir. Bu konu ileride
     ele alınacaktır.

     6.
     Downcasting ile ilgili example için bkz: randomGeneratorApp

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.random.Random

fun main()
{
    println("-------------------------------oneTwo-----------------------------------")
    oneTwo034()
    println("-------------------------------three-----------------------------------")
    three034()
    println("-------------------------------four-----------------------------------")
    four034()
}

fun oneTwo034()
{
    val a = 20
    val any: Any = a //boxing

    println(a.javaClass.name)
    println(any.javaClass.name)

    println("*********************")

    val a2 = 20.2
    val any2: Any = a2 //boxing

    println(a2.javaClass.name)
    println(any2.javaClass.name)

    println("*********************")

    val a3 = "halil"
    val any3: Any = a3 //boxing

    println(a3.javaClass.name)
    println(any3.javaClass.name)

    println("******Unboxing*******")

    val value = any as Int //unboxing
    val value2 = any2 as Double //unboxing
    val value3 = any3 as String //unboxing

    println(value)
    println(value2)
    println(value3)
}

/* ************************************************************************************************************** */

/*
                    F1
                 F2    F4
               F3
             F5

      => Aşağıda ki kodda F3, F5 gelirse haklı, diğerleri haksız dönüşümdür ve exception oluşur.
 */
fun three034()
{
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val x: F1 = createRandomF()

        println("---------------------------------------")
        println(x.javaClass.name)

        if (x is F3) {
            val y: F3 = x as F3
            y.c = 10

            println("y.c = ${y.c}")
        } else
            println("Haksız dönüşüm")

        println("---------------------------------------")
    }
}

fun four034()
{
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val x: F1 = createRandomF()

        println("---------------------------------------")
        println(x.javaClass.name)

        if (x is F3) {
            x.c = 10 //smart cast // artık x'i F3 olarak smart cast yaptığı için x direkt c'ye erişebilir.

            println("x.c = ${x.c}")
        } else
            println("Haksız dönüşüm")

        println("---------------------------------------")
    }
}

fun createRandomF(random: Random = Random) : F1
{
    return when (random.nextInt(5)) {
        0 -> F2()
        1 -> F3()
        2 -> F4()
        3 -> F5()
        else -> F1()
    }
}

open class F1 {
    //...
}

open class F2 : F1() {
    //...
}

open class F3(var c: Int  = 10) : F2() {
    //...
}

class F4 : F1() {
    //...
}

class F5 : F3() {
    //...
}