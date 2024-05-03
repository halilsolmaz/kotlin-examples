/*-----------------------------------------------------------------------------------------------------
    1.
    Dizilerin fonksiyon türden parametreli ctor'ları ile her bir eleman için dizi yaratılırken ne yapılacağı belirlenebilir
    Generic olan Array sınıfının fonksiyon türden parametresi olmayan ctor'u yoktur. Aşağıdaki örneği inceleyiniz.

    2.
    Lambda fonksiyon kullanım örneği

    3.
    Lambda fonksiyonlar içerisinde kendisinden önce bildirilen yerel değişkenler ve parametre değişkenleri kullanılabilir
    ve değerleri değiştirilebilir

    Not: Java'da bir yakalanan yerel bir değişken veya bir parametre değişkeni faaliyet alanı boyunca değiştirilemez
    (effectively final)

  * 4.
    Aşağıdaki örnekte bir fonksiyonun parametresi olan fonksiyonun da parametresi fonksiyon türündendir.
    Çok kullanılmasa da bilinmesin de fayda var.

    Örnekte:
    callback: foo fonksiyonunun aldığı parametre. Bu parametre, (Int, Int) -> Int türünden bir
    fonksiyonu parametre olarak alır ve Int türünden bir değer döndürür.

    5.
    Bir başka örnek ise;

    fun foo(callback : ((Int, Int) -> Int, (Double) -> Double) -> (Int, Int) -> String)
    {
        //...
    }

    -> İlk parametresi: Int, Int parametreli ve geri dönüş değeri Int olan bir fonksiyon
    -> İkinci Parametresi: Double parametreli ve Double geri dönüşlü bir fonksiyon ve bu callback'in
    geri dönüş değeri Int, Int parametreli ve String'e geri dönen bir fonksiyon

    6.
    Lambda fonksiyonlarda kullanılmayacak parametreler alttire karakteri ile atlanabilir

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.array.kotlin.randomIntArrayFnc
import halilsolmaz.app.util.array.kotlin.writeFnc
import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.string.kotlin.randomTextEN
import kotlin.random.Random

fun main()
{
    println("-------------------------------one-----------------------------------")
    one062()
    println("-------------------------------two-----------------------------------")
    two062()
    println("-------------------------------three-----------------------------------")
    three062()
    println("-------------------------------four-----------------------------------")
    four062()
    println("-------------------------------five-----------------------------------")
    five062()
    println("-------------------------------six-----------------------------------")
    six062()
}

fun one062()
{
    val a = IntArray(10) {it + 5}
    val s = Array(10) { Random.randomTextEN(it + 1)}

    a.writeFnc()
    s.writeFnc()
}

/*********************************************************************************************************************/

fun two062()
{
    val flags = BooleanArray(5) {true}

    for (f in flags)
        println(f)
}

/*********************************************************************************************************************/

fun three062()
{
    val count = readInt("Bir sayı giriniz:")
    val a = Random.randomIntArrayFnc(count, 0, 100)

    a.forEach { print("%02d ".format(it)) }
    println()

    var factor = readInt("Çarpılacak sayıyı giriniz:")
    val b = a.transform { it * factor++} // factor'un burada kullanılabildiğine ve değiştirilebildiğine dikkat edin.

    b.forEach { print("$it ") }
    println()
}

/*********************************************************************************************************************/

fun four062()
{
    foo {it(10, 20)}
}

fun foo(callback : ((Int, Int) -> Int) -> Int)
{
    println(callback{x, y -> x + y})
}

/*********************************************************************************************************************/

fun five062() {
    val resultFunction = foo3 { intOperation, doubleOperation ->
        { x, y ->
            val sum = intOperation(x, y)
            val squaredSum = doubleOperation(sum.toDouble())
            "Sonuç: $squaredSum"
        }
    }

    val result = resultFunction(3, 4)
    println(result)
}

fun foo3(callback: ((Int, Int) -> Int, (Double) -> Double) -> (Int, Int) -> String): (Int, Int) -> String {
    return callback({ x, y -> x + y }, { it * it })
}

/*********************************************************************************************************************/

fun six062()
{
    val f: (Int, Int, String) -> String = {_, _, s -> ":$s:"}

    println(f(6, 312, "ankara"))
}

