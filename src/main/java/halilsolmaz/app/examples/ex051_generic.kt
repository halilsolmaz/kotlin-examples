/*-----------------------------------------------------------------------------------------------------
    1.
    Pair sınıfı çok fazla kullanılan basit bir generic sınıftır.

    2.
    Pair sınıfı bir data sınıf olduğundan bu sınıfın componentN üye fonksiyonları da bulunmaktadır.

    3.
    to generic infix fonksiyonu ile iki değerden bir Pair elde edilebilir

    4.
    Triple sınıfı

    5.
    Triple sınıfı (ve Pair sınıfı) immutable özelliktedir

    6.
    Triple sınıfının (ve Pair sınıfının) toList extension metotları ile elemanlardan oluşan liste elde edilebilir

    7.
    Triple sınıfının (ve Pair sınıfının) toList extension metotları ile elemanlardan oluşan liste elde edilebilir.

    Not: Triple sınıfı olmadan Pair ile bir triple oluşturulabilir. Örneğe bakınız.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one-----------------------------------")
    one051()
    println("-------------------------------two-----------------------------------")
    two051()
    println("-------------------------------three-----------------------------------")
    three051()
    println("-------------------------------four-----------------------------------")
    four051()
    println("-------------------------------five-----------------------------------")
    five051()
    println("-------------------------------six-----------------------------------")
    six051()
    println("-------------------------------seven-----------------------------------")
    seven051()
}

fun one051()
{
    val cities = arrayOf(Pair(34, "istanbul"), Pair(6, "ankara"), Pair(35, "izmir"))

    for (p in cities)
        println("${p.first}, ${p.second}")
}

fun two051()
{
    val cities = arrayOf(Pair(34, "istanbul"), Pair(6, "ankara"), Pair(35, "izmir"))

    for ((plate, name) in cities)
        println("${plate}, $name")
}

fun three051()
{
    val city = 67 to "zongudak"

    val (plate, name) = city

    println("$plate, $name")

}

fun four051()
{
    val points = arrayOf(Triple(100, 100, 200), Triple(-100, -100, -200))

    for ((x, y, z) in points)
        println("($x, $y, $z)")
}

fun five051()
{
    val point = Triple(100, 100, 100)

    // point.first = 10 // Error
}

fun six051()
{
    val point = Triple(100, 100, 100)

    val coordinates = point.toList()

    for (c in coordinates)
        println(c)
}

fun seven051()
{
    val triple = Triple(67, 372.5, "izmir")

    val list = triple.toList()

    for (c in list)
        println("$c ")

    println()

    /*
    Triple sınıfı olmasaydı aşağıdaki gibi de yapılabilirdi.
     */

    val triple3d = Pair(67, Pair(372.5, "izmir"))
    println(triple3d.first)
    println(triple3d.second.first)
    println(triple3d.second.second)

    println()
}