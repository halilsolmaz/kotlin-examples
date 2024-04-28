/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'de diziler Array isimli bir sınıf ile temsil edilir. Array sınıfı generic bir sınıftır.

    Aşağıdaki örnekte Array sınıfı kullanılarak bir String dizisi yaratılmıştır. String dizisinin başlangıçta
    tüm elemanlarına örnekte boş string verilmiştir.

    Başlangıçta verilen değere ilişkin sentaks ve semantic ileride ele alınacaktır

    2.
    Array sınıfı kullanılarak aşağıdaki gibi bir String dizisi oluşturulabilir

    3.
    Generic fonksiyonlar:

    Generic fonksiyonlarda generic parametre türleri tespit edilebiliyorsa açılım yapmaya gerek olmaz.

    4.
    Aşağıdaki örnekte argümanın türü tespit edebilse bile açılım yapılmak zorundadır. Çünkü K'nın türünün tespit edilmesi için
    açılım yapılması gerekir.

    Yani örnekteki gibi eğer sadece bir tane açılımı vererek diğer açılımın type deduction ile anlaşılmasına rağmen
    Error oluşur. Eğer en az biri için bile açılım yapmak gerekiyorsa, tüm parametreler için açılım yapılmalıdır.

    5.
    Generic fonksiyonların parametrelerine de kısıt (sınır) verilebilir.

    6.
    Generic sınıfların içerisinde generic metotlar da bildirilebilir (member generics)


-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import java.io.Closeable
import java.io.FileInputStream
import kotlin.random.Random

fun main()
{
    println("-------------------------------one-----------------------------------")
    one052()
    println("-------------------------------two-----------------------------------")
    two052()
    println("-------------------------------three-----------------------------------")
    three052()
    println("-------------------------------four-----------------------------------")
    four052()
    println("-------------------------------five-----------------------------------")
    five052()
    println("-------------------------------six-----------------------------------")
    six052()

}

fun one052()
{
    val a = Array(3) {""}

    for (s in a)
        println(if (s == "") "Boş String" else s)

    println("-------------------------------------")

    for (i in a.indices)
        a[i] = getRandomTextEN025V2(Random.nextInt(5, 10))

    for (s in a)
        println(if (s == "") "Boş String" else s)
}

fun two052()
{
    val a = Array(3) {"xxx"}

    for (s in a)
        println(s)
}

fun three052()
{
    val a = "ankara"
    val b = 10

    display<String, Int>(a, b) // bu ve aşağıdaki, aynı ve geçerlidir.
    display(a, b)

    display(true, 3.4)
}

fun <T, K> display(t: T, k: K)
{
    println(t)
    println(k)
}

fun four052()
{
    val a = "ankara"
    val b = 10

    // display<Int>(a) // Error
    display<String, Int>(a, b)
}

fun <K, T> display(t: T) : K?
{
    println(t)

    return null
}

fun five052()
{
    // doWork<Int, Closeable>(FileInputStream("test.txt")) // Geçerli
    // doWork<Int, Double>(3.4) // Error, çünkü Double sınıfı closable değildir.
}

fun <R, T: Closeable> doWork(t: T) : R?
{
    t.use {
        //....
    }

    return null
}

fun six052()
{
    val s = Sample052<Int>()

    s.foo("ankara", 10)
    s.foo(2.3, 5)
}

class Sample052<T> {
    fun <K> foo(k: K, t: T)
    {
        println(k)
        println(t)
    }
}