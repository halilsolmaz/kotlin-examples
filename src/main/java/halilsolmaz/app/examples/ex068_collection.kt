/*-----------------------------------------------------------------------------------------------------
    1.
    Aşağıdaki örnekte count tane rasgele sayıdan oluşan dizi elde edilmiş ve dizinin elemanları ekrana basılmıştır
    Örnekte lambda fonksiyon içerisinde parametre kullanılmadığında bazı static kod analizi araçları uyarı verebilir.
    Bu uyarının kalkması için Lambda fonksiyon içerisindeki parametre alttire karakteri ile pas geçilecek şekilde
    belirtilebilir. Bu uyarı dikkate alınmasa da bir sorun oluşturmaz.

    2.
    Aşağıdaki örnekler de count tane rasgele sayıdan oluşan dizi elde edilmiş ve dizinin elemanları ekrana basılmıştır.

    3.
    Aşağıdaki örneklerde take ve drop eklenti fonksiyonları kullanılmıştır.

    take: filterda elde edilen elemanların take ile count tanesi alınır, kalanlar atılır.
    drop: filterda elde edilen elemanların drop ile count tanesi atılır, kalanlar alınır.
    dropLast: filterda elde edilen elemanların dropLast ile sondan count tanesi atılır, kalanlar alınır.

    4.
    Aşağıdaki örnekte generateSequence fonksiyonu ile count tane rasgele sayı üretilmiştir.

    generateSequence sonsuz tane değer üretir. take(count) ile sınırlayabiliriz.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.test.data.loadNamesFromFileAsList
import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.console.kotlin.readString
import kotlin.random.Random


fun main()
{
    println("-------------------------------one--------------------------------")
    one068()
    println("-------------------------------two-one--------------------------------")
    two068one()
    println("-------------------------------two-two--------------------------------")
    two068two()
    println("-------------------------------two-three--------------------------------")
    two068three()
    println("-------------------------------two-four--------------------------------")
    two068four()
    println("-------------------------------three-one--------------------------------")
    three068one()
    println("-------------------------------three-two--------------------------------")
    three068two()
    println("-------------------------------three-three--------------------------------")
    three068three()
    println("-------------------------------four--------------------------------")
    four068one()
}

fun one068()
{
    val count = readInt("Bir sayı giriniz:")

    IntArray(count) {it}.forEach { print("${Random.nextInt(100)} ") }
    println()
    IntArray(count) {it}.forEach { _ -> print("${Random.nextInt(100)} ") }
    println()
}

/*********************************************************************************************************************/

fun two068one()
{
    val count = readInt("Bir sayı giriniz:")

    IntRange(1, count).map { Random.nextInt(100) }.toIntArray().forEach { print("$it ") }
    println()
}

/*********************************************************************************************************************/

fun two068two()
{
    val count = readInt("Bir sayı giriniz:")

    (1..count).map { Random.nextInt(100) }.toIntArray().forEach { print("$it ") }
    println()
}

/*********************************************************************************************************************/

fun two068three()
{
    val count = readInt("Bir sayı giriniz:")

    (0 until count).map { Random.nextInt(100) }.toIntArray().forEach { print("$it ") }
    println()
}

/*********************************************************************************************************************/

fun two068four()
{
    val count = readInt("Bir sayı giriniz:")

    (1..count).forEach{ _ -> print("${Random.nextInt(200)}")}
    println()
}

/*********************************************************************************************************************/

fun three068one()
{
    try {
        val text = readString("Bir yazı giriniz:")
        val count = readInt("Sorgudan ilk kaç tanesi elde edilsin:")
        val allNames = loadNamesFromFileAsList("names.csv")
        val names = allNames.filter { it.contains(text, ignoreCase = true) }
            .take(count)
            .map { it.lowercase() }
            .toList()

        names.forEach(::println)
        println("Tüm koşula uygun veriler toplam ${allNames.count { it.contains(text, ignoreCase = true) }} tanedir")
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun three068two()
{
    try {
        val text = readString("Bir yazı giriniz:")
        val count = readInt("Sorgudan ilk kaç tanesi elde edilsin:")
        val allNames = loadNamesFromFileAsList("names.csv")
        val names = allNames.filter { it.contains(text, ignoreCase = true) }
            .drop(count)
            .map { it.lowercase() }
            .toList()

        names.forEach(::println)
        println("Tüm koşula uygun veriler toplam ${allNames.count { it.contains(text, ignoreCase = true) }} tanedir")
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun three068three()
{
    try {
        val text = readString("Bir yazı giriniz:")
        val count = readInt("Sorgudan son kaç tanesi atılsın:")
        val allNames = loadNamesFromFileAsList("names.csv")
        val names = allNames.filter { it.contains(text, ignoreCase = true) }
            .dropLast(count)
            .map { it.lowercase() }
            .toList()


        names.forEach(::println)
        println("Tüm koşula uygun veriler toplam ${allNames.count { it.contains(text, ignoreCase = true) }} tanedir")
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun four068one()
{
    val count = readInt("Bir sayı giriniz:")

    generateSequence { Random.nextInt(1, 100) }
        .take(count)
        .forEach {print("$it ")}
    println()
}

fun four068two()
{
    val count = readInt("Bir sayı giriniz:")

    generateSequence(2) {3 * it + 1}.take(count).forEach {print("$it ")}
    println()
}

fun four068three() {
    val start = readInt("Başlangıç değerini giriniz:")
    val end = readInt("Bitiş değerini giriniz:")
    val step = readInt("Adım değerini giriniz:")

    generateSequence(start) { it + step }.takeWhile { it < end }.forEach{print("$it ")}
    println()
}

fun four068four() {
    val start = readInt("Başlangıç değerini giriniz:")
    val end = readInt("Bitiş değerini giriniz:")
    val step = readInt("Adım değerini giriniz:")

    (start until end step step).forEach{print("$it ")}
    println()
}