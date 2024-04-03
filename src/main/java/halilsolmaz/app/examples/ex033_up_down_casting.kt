/*-----------------------------------------------------------------------------------------------------
    1.
    Aralarında türetme ilişkisi olmayan iki sınıf türünden referans birbirine doğrudan atanamaz

    Aralarında türetme ilişkisi olmayan sınıflar türünden iki referans as operatörü ile birbirine doğrudan atanabilir.
    Aşağıdaki kodda exception oluşur. as operatörü ileride detaylı olarak incelenecektir

    Not: Dilin yapısı nedeniyle as ile yapılan bu dönüşüm error oluşturmaz. Ancak exception oluşturur.

    2.
    Türemiş sınıf (sub class) türünden  bir referans taban sınıf (super class) türünden bir referansa doğrudan (implicit)
    atanabilir (upcasting)
    Bu durumda türemiş sınıf nesnenin taban sınıf kısmının adresi taban sınıf referansına atanmış olur.
    
    Not: two033 de c'nin gösterdiği x ile d'nin gösterdiği nesne aynıdır. Yani iki referansla da aynı nesneyi
    değiştirebiliriz.
    Ayrıca d c'ye upcasting yapıldığı için c sadece kendinde kalıtım olan x'e erişebilir, y'ye erişemez.

    3.
    Upcasting in anlamını anlatran bir example.

    Bir diğer example için bkz: CompanyDemoApp

    4.
    Bir referansın iki tane türü vardır: static type, dynmaic type
    Referansın static türü bildirildiği türdür. Derleme zamanına (compile time) ilişkindir ve değişmez. Referansın türü
    dendiğinde static tür anlaşılır.

    Referansın dinamik türü ise referansın gösterdiği nesnenin bellekte yaratıldığı gerçek türüdür

    Anahtar Notlar: Java'da bir referansın dinamik tür bilgisi "fully qualified" olarak şu şekilde elde edilebilir:
           <referans>.getClass().getName()
    Bunun Kotlin karşılığı:
            <referans>.javaClass.name
    biçimindedir.

    5.
    Taban sınıf türünden bir referans türemiş sınıf türünden bir referansa as operatörü ile atanabilir (downcasting).
    Bu işlem derleme zamanından geçmek içindir. Bu durumda çalışma zamanında kaynak referansın dinamik türünün as operatörüne
    verilen türü kapsayıp kapsamadığına bakılır. Kapsıyorsa haklı dönüşümdür, akış devam eder. Kapsamıyorsa haksız
    dönüşümdür, exception oluşur.

    Not: Aslında derleyici explicit casting işlemi gereken durumlarda programcıya şunu der; yaptığın atama sorun yaratabilir.
    Bu sorun bilgi kaybı, haksız dönüşüm vs olabilir. O yüzden bu işlemi bunun bilincinde olarak yap.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.random.Random

fun main()
{
    //println("--------------------------------one-------------------------------------")
    //one033()
    println("--------------------------------two-------------------------------------")
    two033()
    println("--------------------------------three-------------------------------------")
    three033()
    //println("--------------------------------four-------------------------------------")
    //four033()
    println("--------------------------------five-------------------------------------")
    five033()
}

fun one033()
{
    val a = A033()
    var b: B033 = a as B033
}

class A033 {
    //...
}

class B033 {
    //...
}

fun two033()
{
    val d = D033(10, 20)

    println("d.x = ${d.x}, d.y = ${d.y}")
    val c: C033 = d

    println("c.x = ${c.x}")

    ++c.x
    //++a.y // a sadece x'e ulaşabilir.
    println("c.x = ${c.x}")
    println("b.x = ${d.x}, b.y = ${d.y}")
}


class D033(var y: Int, x: Int) : C033(x)

open class C033(var x: Int)

fun three033()
{
    val t1 = T1(10)
    val t2 = T2(10, 20)
    val t3 = T3(10, 20, 30)

    doWork(t1)
    doWork(t2)
    doWork(t3)
}

fun doWork(t1: T1)
{
    println("t1.x = ${t1.x}")
}

open class T1(var x: Int)

open class T2(var y: Int, x: Int) : T1(x)

class T3(var z: Int, x: Int, y: Int) : T2(y, x)

fun four033()
{
    while (true) {
        val value = readInt("Bir sayı giriniz:")

        if (value == 0)
            break

        val x: H1

        x = if (value > 0) H2() else H1()

        println(x.javaClass.name) // x referansının dinamik türü stdout'a yazdırılıyor
    }
}

open class H1 {
    //...
}

class H2 : H1() {
    //...
}

/* ************************************************************************************************************** */

/*
                    E1
                 E2    E4
               E3
             E5

      => Aşağıda ki kodda E3, E5 gelirse haklı, diğerleri haksız dönüşümdür ve exception oluşur.
 */
fun five033()
{
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val x: E1 = createRandomE()

        println(x.javaClass.name)

        val y: E3 = x as E3

        y.c = 10

        println("y.c = ${y.c}")
    }
}

fun createRandomE(random: Random = Random) : E1
{
    return when (random.nextInt(5)) {
        0 -> E2()
        1 -> E3()
        2 -> E4()
        3 -> E5()
        else -> E1()
    }
}

open class E1 {
    //...
}

open class E2 : E1() {
    //...
}

open class E3(var c: Int  = 10) : E2() {
    //...
}

class E4 : E1() {
    //...
}

class E5 : E3() {
    //...
}