/*-----------------------------------------------------------------------------------------------------
    1.
    Aşağıdaki örnekte getRandomTextEN fonksiyonu içerisindeki döngüde count tane String nesnesi yaratılacak ve
    sürekli referans nesneden kopartıldığından (çünkü String  immutable bir sınıf) son yaratılan nesne nin referansı
    kullanılacaktır. Bu durumda daha önce yaratılan nesneler için "yaratılma maliyeti" söz konusu olabilecektir.

    Not: String sınıfının immutable olmasının getirdiği en önemli dezavantajlardan birirdir.

    2.
    Yazılarla işlem yapan, mutable olan ve String sınıfına yardımcı iki tane temel sınıf bulunmaktadır:
    StringBuilder, StringBuffer.

    Bu sınıflar genel olarak aynıdır. Aralarındaki farklar ileride ele alınacaktır. Farkların sözkonusu olduğu koldar
    dışında StringBuilder sınıfı kullanılmalıdır. Bu sınıflar içerisinde Char türden dizi tutulduğundan yazı üzerinde
    değişiklik yapılabilmektedir. Bu sınıflar genel olarak String sınıfının immutable olmasının dezavantajlı olduğıu
    durumlarda kullanılır. StringBuffer sınıfının farkı ileride ele alınacaktır.

    Not: runGetRandomTextENTest025V2 de StringBuilder kullanılarak nesne yaratma maliyeti görece ortadan kaldırılmıştır

    3.
    Bu kodda reverse metodu sürekli nesne yarattığı için kötü yazılmıştır.

    4.
    mutable olan StringBuilder sınıfını kullanarak yazılan reverse metodu
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import kotlin.random.Random

fun main()
{
    one025()
    println("---------------------------------------------------------------------")
    two025()
    println("---------------------------------------------------------------------")
    three025()
    println("---------------------------------------------------------------------")
    four025()
    println("---------------------------------------------------------------------")
}

fun one025()
{
    runGetRandomTextENTest025V1()
}

fun runGetRandomTextENTest025V1()
{
    while (true) {
        print("Input count:")
        val count = readln().toInt()

        if (count <= 0)
            break

        val text = getRandomTextEN025V1(count)

        println(text)
    }
}

fun getRandomTextEN025V1(count: Int, random: Random = Random) : String
{
    var str = ""

    for (i in 1..count)
        str += (if (random.nextBoolean()) 'A' else 'a') + random.nextInt(26)

    return str;
}

fun two025()
{
    runGetRandomTextENTest025V2()
}

fun runGetRandomTextENTest025V2()
{
    while (true) {
        print("Input count:")
        val count = readln().toInt()

        if (count <= 0)
            break

        val text = getRandomTextEN025V2(count)

        println(text)
    }
}
fun getRandomTextEN025V2(count: Int, random: Random = Random) : String
{
    val sb = StringBuilder(count) // val tanımlanabildiğine dikkat edin.

    for (i in 1..count)
        sb.append((if (random.nextBoolean()) 'A' else 'a') + random.nextInt(26))

    return sb.toString()
}

fun three025()
{
    runReverseTest025V1()
}

fun runReverseTest025V1()
{
    while (true) {
        print("Input text:")
        val s = readln()

        if (s == "quit")
            break

        val str = reverse025V1(s)

        println("($str)")
    }
}

fun reverse025V1(s: String) : String
{
    var str = ""
    for (i in s.length - 1 downTo 0)
        str += s[i]

    return str
}

fun four025()
{
    runReverseTest025V2()
}

fun runReverseTest025V2()
{
    while (true) {
        print("Input text:")
        val s = readln()

        if (s == "quit")
            break

        val str = reverse025V2(s)

        println("($str)")
    }
}

fun reverse025V2(s: String) : String
{
    return StringBuilder(s).reverse().toString()
}

