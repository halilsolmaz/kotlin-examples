/*-----------------------------------------------------------------------------------------------------
    1.
    arrayOf generic fonksiyonu ile bir dizi ilk değer verme sentaksı biçiminde kullanılabilir. Diziler Kotlin'de de
    dolaşılabilir (iterable) olduğundan for döngü deyimi kullanılabilir.

    2.
    Dizilerin eleman sayısına size property elemanı ile erişilebilir.

    Dizilerin eleman sayısı count isimli extension fonksiyon ile de elde edilebilir

    3.
    Dizilerin indices property elemanı [0, size) aralığında bir IntRange referansına döner

        for (i in a.indices)  eş değer döngü:  for (i in 0 until a.size)

    4.
    joinToString fonksiyonu ile dizi içerisindeki elemanlar bir ayraç veya bir ön ek veya bir son ek ile birleştirilebilir

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.homeworks.randomIntArray
import halilsolmaz.app.homeworks.write

fun main()
{
    one029()
    println("---------------------------------------------------------------------")
    three029()
    println("---------------------------------------------------------------------")
    four029()
}

fun one029()
{
    val cities = arrayOf("ankara", "istanbul", "izmir")

    for (city in cities)
        println(city)

    val size = cities.size
    println("size = $size")

    val count = cities.count()
    println("count = $count")

}

fun three029()
{
    val a = arrayOf(10, 20, 30)

    for (i in a.indices)
        a[i] *= a[i];

    for (value in a)
        print("$value ")

    println()
}

fun four029()
{
    val a = randomIntArray(10, 0, 100)

    write(2, a)
    println()

    val str = a.joinToString("-", "{", "}")
    println(str)

    val str1 = a.joinToString(prefix = "{", separator = "-", postfix = "}")
    println(str1)

    val str2 = a.joinToString(prefix = "{", postfix = "}")
    println(str2)

    val str3 = a.joinToString()
    println(str3)
}