/*-----------------------------------------------------------------------------------------------------
    1.
    Bir veri yapısının, veri yapısının verileri nasıl tuttuğundan bağımsız olarak dolaşılmasına (iterate) olanak sağlayan
    araçlara programlamada genel olarak iterator denir.

    Kotlin'de for döngü deyimiyle dolaşılabilir bir sınıfın Iterable<T> arayüzünü desteklemesi gerekir.

    Bu arayüzün iterator metodu Iterator<T> arayüz referansına geri döner. Bu arayüzün hasNext
    abstract metodu ile bir sonraki verinin varlığına ilişkin Boolean türden değer elde edilir. next metodu bir sonraki
    elemanın değerine geri döner, her next çağrısında bir sonraki elemandan önceki elemana konumlanılır. next metodu
    hasNext false olduğunda yani artık eleman kalmadığında çağrılırsa NoSuchElementException fırlatılır.

    Aşağıdaki iterator metodunun çağrılması ve döngü işlemi for döngü deyimiyle doğrudan yapılabilir.

        val iter = a.iterator()
        while (iter.hasNext())
            print("${iter.next()} ")

        karşılığı:

        for (value in a)
            print("$value ")

    Aşağıdaki örnekte bir dizi iterator ile açık açık dolaşılmıştır.

    2.
    RandomIntGenerator sınıfının 3 adet versiyonu yazılmıştır.

    Bkz: RandomIntGeneratorV1, RandomIntGeneratorV2, RandomIntGeneratorV3

    Not: RandomIntGeneratorV2 Java da yazılamaz. Çünkü Java da yerel değişkenler capture edildiği zaman değiştirilemez
    (effectively final)

    V1: Iterator içinde "mIndex" adında bir değişken kullanılmış ve sınıf seviyesinde bir değişken olarak tanımlanmıştır.
    V2: Iterator içinde count adında bir yerel değişken kullanılmıştır. Sınıf seviyesinde değil, iterator içinde tanımlanmıştır.
    V3: mIndex" Objectin elemanı olarak tanımlanmıştır.

    3.
    Iterable arayüzüne eklenti olarak yazılmış bir grup fonksiyon vardır. Bu fonksiyonlar genel olarak callback alırlar.
    Bu fonksiyonlar genel olarak iki gruba ayrılabilir:
        - 1. Intermediate operation functions: Veriler üzerinde çağrılacak callback'leri belirlemekte kullanılır. Bu fonksiyonlar
    aldıkları callback'i doğrudan çalıştırmazlar. Bir terminal operation function devam eden zincirin sonunda çağrıldığında
    bu callback'ler de çağrılır. Yani aslında bir ara fonksiyonun aldığı calllback'in çağrılabilmesi için bir terminal operation
    function çağrılması gerekir.

        - 2. Terminal operation functions: Bir zincir (pipeline) içerisinde ya bir işlem yapan ya da tüm belirlenen ara işlemlere
    göre bir değer döndüren metotlardır. Bir pipeline içerisinde istenildiği kadar intermediate function çağrısı olabilir
    ancak bir tane terminal function çağrısı yapılabilir.

    4.
    forEach ve filter eklenti fonksiyonları

    5.
    Aşağıdaki örneği ve write fonksiyonunu inceleyiniz

    6.
    Iterable arayüzüne eklenti olarak bulunan metotların bir çoğu String sınıfında da eklenti olarak bulunmaktadır. String
    sınıfı bu anlamda "iterable" değildir ancak "iterable" olarak kullanılabilmektedir.

    Anımsanacağı gibi String sınıfı da for döngü deyimi ile dolaşılabilir

    7.
    - one
    Aşağıdaki örnekte klavyeden girilen minimum ve maksimum değerler arasındaki fiyata sahip stokta bulunan
    ürünler listelenmiştir

    - two
    Yukarıdaki örnek için filter fonksiyonları ayrı ayrı da çağrılabilir


-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.classes.random.RandomIntGeneratorV1
import halilsolmaz.app.classes.random.RandomIntGeneratorV2
import halilsolmaz.app.classes.random.RandomIntGeneratorV3
import halilsolmaz.app.test.data.loadProductsFromFileAsIterable
import halilsolmaz.app.util.console.kotlin.readBigDecimal
import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.console.kotlin.readString
import halilsolmaz.app.util.iterable.kotlin.write
import halilsolmaz.app.util.number.isPrime
import kotlin.random.Random

fun main()
{
    println("-------------------------------one-one--------------------------------")
    one066one()
    println("-------------------------------one-two--------------------------------")
    one066two()
    println("-------------------------------two-one--------------------------------")
    two066one()
    println("-------------------------------two-two--------------------------------")
    two066two()
    println("-------------------------------two-three------------------------------")
    two066three()
    println("-------------------------------four-----------------------------------")
    four066()
    println("-------------------------------five-----------------------------------")
    five066()
    println("-------------------------------six-one--------------------------------")
    six066one()
    println("-------------------------------six-two--------------------------------")
    six066two()
    println("-------------------------------seven-one------------------------------")
    seven066one()
    println("-------------------------------seven-two------------------------------")
    seven066two()
}

fun one066one()
{
    val a = IntArray(10) { Random.nextInt(100) }

    val iter = a.iterator()

    while (iter.hasNext())
        print("${iter.next()} ")

    println()
}

/*********************************************************************************************************************/

fun one066two()
{
    val a = readInt("Birinci sayıyı giriniz:")
    val b = readInt("İkinci sayıyı giriniz:")

    val r = a..b
    val iter = r.iterator()

    while (iter.hasNext())
        print("${iter.next()} ")

    println()

    for (v in r)
        print("$v ")

    println()
}

/*********************************************************************************************************************/

fun two066one()
{
    val rig = RandomIntGeneratorV1(10, 0, 100)

    for (value in rig)
        print("%02d ".format(value))

    println("\n-------------------------")

    for (value in rig)
        print("%02d ".format(value))

    println()
}
fun two066two()
{
    val rig = RandomIntGeneratorV2(10, 0, 100)

    for (value in rig)
        print("%02d ".format(value))

    println("\n-------------------------")

    for (value in rig)
        print("%02d ".format(value))

    println()
}

fun two066three()
{
    val rig = RandomIntGeneratorV3(10, 0, 100)

    for (value in rig)
        print("%02d ".format(value))

    println("\n-------------------------")

    for (value in rig)
        print("%02d ".format(value))

    println()
}

/*********************************************************************************************************************/

fun four066()
{
    val randomIntGenerator = RandomIntGeneratorV3(readInt("Bir sayı giriniz:"), 0, 100)

    randomIntGenerator.forEach {print("$it ")}

    println()

    randomIntGenerator.filter { it % 2 == 0 }.forEach {print("$it ")}

    println()

    randomIntGenerator.filter { it.isPrime() }.forEach {print("$it ")}

    println()
}

/*********************************************************************************************************************/

fun five066()
{
    val randomIntGenerator = RandomIntGeneratorV1(readInt("Bir sayı giriniz:"), 0, 100)

    write(randomIntGenerator)
    write(randomIntGenerator.filter { it % 2 == 0 })
    write(randomIntGenerator.filter { it.isPrime() })
}

/*********************************************************************************************************************/

fun six066one()
{
    val s = readString("Bir yazı giriniz:")

    s.filter { it.isUpperCase() }.forEach(::println)
}

fun six066two()
{
    val s = readString("Bir yazı giriniz:")

    for (c in s)
        print("$c ")

    println()
}

/*********************************************************************************************************************/

fun seven066one()
{
    try {
        val products = loadProductsFromFileAsIterable("products-withheader.csv")
        val minPrice = readBigDecimal("Minimum fiyatı giriniz:")
        val maxPrice = readBigDecimal("Maximum fiyatı giriniz:")

        //products.forEach(::println)
        println("Filtered Products:")
        products.filter { it.stock > 0 && minPrice < it.price  && it.price < maxPrice }
            .forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

fun seven066two()
{
    try {
        val products = loadProductsFromFileAsIterable("products-withheader.csv")
        val minPrice = readBigDecimal("Minimum fiyatı giriniz:")
        val maxPrice = readBigDecimal("Maximum fiyatı giriniz:")

        //products.forEach(::println)
        println("Filtered Products:")
        products.filter { it.stock > 0}.filter{ minPrice < it.price }.filter {it.price < maxPrice }.forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}