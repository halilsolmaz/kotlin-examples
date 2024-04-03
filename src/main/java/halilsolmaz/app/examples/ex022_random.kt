/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin JVM'de rasgele üretimi için java.util paketi içerisinde Random sınıfı kullanılabilse de, Kotlin'inin standart
    kütüphanesi içerisinde de random sayı üretimi yapan "object" ve fonksiyonlar vardır. Bu araçlar JavaSE'deki Random
    sınıfı aynı algoritmayı kullanmazlar. Programcı rasgele sayı üretiminde özel bir durum yoksa Kotlin'in rasgele sayı
    üretimi yapan object ve fonksiyonlarını kullanmalıdır.

    2.
    Kotlinde Random object olarak tutulur. Bir object bildirimi yapıldığında o isimde bir tane referans yaratılır
    ve o nesnenin kullanılmasını sağlar. Singleton kalıbına karşılık gelir. tutulan referans o object
    ismi le aynıdır. İleri de daha ayrıntılı ele alınacaktır.

    3.
    Random "object"'inin nextInt, nextDouble gibi metotları vardır.

    4.
    Tohum değeri Random fonksiyonu ile verilerek istenilen tohum değerinden başlayan bir Random referansı
    elde edilebilir.

    Not: Burada ki Random bir fonksiyondur. Java da Random-seed işlemi Random sınıfının seek parametreli ctoru
    ile yapılırdı. Ancak Kotlinde Random bir sınıf değil objectdir.

    Not: java.util paketindeki Random sınıfıyla kotlin.random paketindeki Random object'inin içsel algoritmaları
    aynı olmak zorunda değildir. Aynı tohum değerinde farklı sayılar üretilir.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import kotlin.random.Random
fun main()
{
    three022()
    println("---------------------------------------------------------------------")
    fourFive022()
}

fun three022()
{
    for (i in 1..10)
        print("${Random.nextInt(100)} ") //[0, 100)

    println()
    println("---------------------------------------------------------------------")

    print("Birinci sayıyı giriniz:")
    val a = readln().toInt();

    print("İkinci sayıyı giriniz:")
    val b = readln().toInt();

    for (i in 1..10)
        print("${Random.nextInt(a, b)} ") //[a, b)

    println()
    println("---------------------------------------------------------------------")

    for (i in 1..10)
        println(Random.nextBoolean())
}

fun fourFive022()
{
    while (true) {
        print("Tohum değerini giriniz:")
        val seed = readln().toLong()

        val r = Random(seed)
        val rj = java.util.Random(seed)

        for (i in 1..10)
            print("${r.nextInt(0, 100)} ")

        println()

        for (i in 1..10)
            print("${rj.nextInt(99) + 1} ")

        if (seed == 0L)
            break
    }
}
