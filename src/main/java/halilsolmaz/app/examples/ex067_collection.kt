/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'de Collection sınıfları, veri kümelerini organize etmek ve işlemek için kullanılan temel yapılardır.
    Bu sınıflar, farklı veri türlerini (sayılar, metinler, nesneler vb.) depolamak ve yönetmek için çeşitli yöntemler sunar.

    Collection Sınıflarının Temel Özellikleri:
    - Data Storage: Collection sınıfları, birbiriyle ilişkili veri öğelerini tek bir yapı içinde saklar.
    - Sorting: Verileri belirli bir kritere göre sıralama imkanı sunar.
    - Filtering: Belirli koşullara uyan veri öğelerini seçmek için kullanılır.
    - Searching: Belirli bir veri öğesini bulmak için kullanılır.
    - Transformation: Veri öğelerini farklı formatlara dönüştürmek için kullanılır.

    Collection Sınıflarının Kullanım Alanları:
    - Arrays: Sabit sayıda veri öğesini depolamak için kullanılır.
    - Lists: Değişken sayıda veri öğesini depolamak ve yönetmek için kullanılır.
    - Sets: Benzersiz veri öğelerini depolamak için kullanılır.
    - Maps: Anahtar-değer çiftlerini depolamak için kullanılır.
    - Ranges: Kesişim, birleşme ve fark gibi küme işlemleri gerçekleştirmek için kullanılır.

    2.
    Kotlin'de standart collection sınıflar genel olarak immutable ve mutable olmak üzere iki gruba ayrılır. Bu ayrım
    arayüzler düzeyinde yapılır. Genel olarak "mutable collection"'lar MutableXXX biçiminde isimlendirilmiştir. Bu durumda
    içerisinde Mutable geçmeyen arayüzler Immutable olur. Sınıflar için bu isimlendirmede istisnalar bulunmaktadır.

    3.
    Collection arayüzünü destekleyen sınıfların MutableCollection veya Collection parametreli ctor'ları bulunur.

    4.
    Aralarında öncelik sonralık ilişkisi bulunan collection sınıflara genel olarak liste tarzı collection sınıflar
    denir ve bu collection sınıflar List<E> veya MutableList<E> arayüzünü desteklerler. Aslında MutableList<E> arayüzü Kotlin'de
    List<E> arayüzünden türetilmiştir. Buradaki List<E> arayüzü ile JavaSE'deki List<E> arayüzü aynı değildir. JavaSE'deki
    List<E> arayüzü Kotlin'deki MutableList<E> arayüzüne karşılık gelir. Collection sınıflar için immutable ve mutable
    collection arayüzleri için genel olarak durum böyledir.

    Not: Linked listte başa eleman almak O(1) karmaşıklıktadır.

    5.
    Mutable liste tarzı collection sınıfların MutableList arayüzünden gelen Collection parametreli addAll metotları bulunur.

    6.
    Aşağıdaki örnekleri inceleyiniz.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.test.data.loadNamesFromFileAsList
import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.console.kotlin.readString
import halilsolmaz.app.util.iterable.kotlin.write
import java.util.*

fun main()
{
    println("-------------------------------three--------------------------------")
    three067()
    println("-------------------------------four--------------------------------")
    four067()
    println("-------------------------------five--------------------------------")
    five067()
    println("-------------------------------six-one--------------------------------")
    six067one()
    println("-------------------------------six-two--------------------------------")
    six067two()
    println("-------------------------------six-three--------------------------------")
    six067three()
    println("-------------------------------six-four--------------------------------")
    six067four()
    println("-------------------------------six-five--------------------------------")
    six067five()
}

/*********************************************************************************************************************/

fun three067()
{
    val mutableList = mutableListOf(10, 20, 30)
    val linkedList = LinkedList(mutableList)

    linkedList.forEach{print("$it ")}

    println()
}

/*********************************************************************************************************************/

fun four067()
{
    val mutableList = mutableListOf("ankara", "istanbul", "İzmir")
    val mutableArrayList: MutableList<Int> = ArrayList()

    println(mutableList.javaClass.name)
    println(mutableArrayList.javaClass.name)

    mutableList.forEach(::println)
    mutableArrayList.forEach(::println)
}

/*********************************************************************************************************************/

fun five067()
{
    val linkedList = LinkedList<Int>()

    linkedList.addAll(mutableListOf(10, 20, 30))
    linkedList.forEach{print("$it ")}
    println()
}

/*********************************************************************************************************************/

fun six067one()
{
    val intList = ArrayList<Int>()

    while (true) {
        val value = readInt("Bir sayı giriniz:")

        if (value == 0)
            break

        intList.add(value)
    }

    write(intList)
}

/*********************************************************************************************************************/

fun six067two()
{
    try {
        val str = readString("Bir yazı giriniz:")
        loadNamesFromFileAsList("names.csv").filter {it.contains(str)}.forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun six067three()
{
    try {
        val str = readString("Bir yazı giriniz:")

        loadNamesFromFileAsList("names.csv")
            .filter{it.contains(str)}
            .map { it.length } // map: List<String> -> List<Int>
            .forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun six067four()
{
    try {
        val str = readString("Bir yazı giriniz:")

        val lengths = loadNamesFromFileAsList("names.csv")
            .filter{it.contains(str)}
            .map { it.length }
            .toList()

        write(lengths)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun six067five() {
    try {
        val text = readString("Bir yazı giriniz:")
        val allNames = loadNamesFromFileAsList("names.csv")
        val names = allNames
            .filter { it.contains(text, true) }
            .map { it.lowercase() }
            .toList()

        allNames.filter { it.contains(text, ignoreCase = true) }.forEach(::println)
        println("--------------------------------------------------------------------")
        names.forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}