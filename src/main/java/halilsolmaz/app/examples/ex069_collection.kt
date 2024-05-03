/*-----------------------------------------------------------------------------------------------------
    1.
    Aşağıdaki örnekte [-2 * PI, 2 * PI] aralığında ve 0.1 artım miktarında sin fonksiyonun değerleri elde edilmiştir.

    2.
    Aşağıdaki örneği inceleyiniz.

    3.
    Aşağıdaki örnekleri inceleyiniz.

    4.
    Aşağıdaki hepsi birbirinden farklı count tane sayı üretilmiştir. Şüphesiz count sayısının aralıktaki toplam sayıyı
    aşmaması gerekir. Aşması durumunda artık üretim yapılamaz ve sonsuz döngü oluşur

    distinct: gelen sayıların farklı olmasını sağlar.

    5.
    Aşağıdaki örneği inceleyiniz.

    Not: toTypedArray() fonksiyonu, bir koleksiyonu belirli bir türde bir diziye dönüştürmek için kullanılır.
    Kodda, numericLotteryNumbers fonksiyonunun bir Array<IntArray> dönmesi gerekiyor. Ancak generateSequence fonksiyonu,
    bir dizi dönmez, bunun yerine bir Sequence döndürür. Dolayısıyla, toList() fonksiyonu kullanılarak bu Sequence bir
    liste haline getirilir ve toTypedArray() fonksiyonuyla da bu liste bir Array<IntArray>'e dönüştürülür.


-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.array.kotlin.writeFnc
import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.math.PI
import kotlin.math.sin
import kotlin.random.Random

fun main()
{
    println("-------------------------------one-one--------------------------------")
    one069one()
    println("-------------------------------one-two--------------------------------")
    one069two()
    println("-------------------------------two--------------------------------")
    two069()
    println("-------------------------------three-one--------------------------------")
    three069one()
    println("-------------------------------three-two--------------------------------")
    three069two()
    println("-------------------------------four-one--------------------------------")
    four069one()
    println("-------------------------------four-two--------------------------------")
    four069two()
    println("-------------------------------five--------------------------------")
    five069()
}

fun one069one()
{
    val start = -2 * PI
    val end = 2 * PI
    val incValue = 0.1

    generateSequence(start) { it + incValue }.takeWhile { it <= end }.map { sin(it) }.forEach(::println)
}

/*********************************************************************************************************************/

fun one069two()
{
    generateSequence(-2 * PI) { it + 0.1 }.takeWhile { it <= 2 * PI }.map { sin(it) }.forEach(::println)
}

/*********************************************************************************************************************/

fun two069()
{
    val count = readInt("Bir sayı giriniz:")

    generateSequence ({ Random.nextInt(1, 30)}) {3 * it + 1}
        .take(count)
        .forEach{print("$it ")}
}

/*********************************************************************************************************************/

fun three069one() = generateSequence { readInt("Bir sayı giriniz:") }.takeWhile {it > 0}.forEach { printCollatzV1(it) }

fun printCollatzV1(value: Int)
{
    var a = value

    generateSequence(a) { a = if (a % 2 == 0) a / 2 else  3 * a + 1; a }
        .takeWhile{a > 1}
        .forEach{print("$it ")}
    println(1)
}

/*********************************************************************************************************************/

fun three069two() = generateSequence { readInt("Bir sayı giriniz:") }.takeWhile {it > 0}.forEach { printCollatzV2(it) }

fun printCollatzV2(value: Int)
{
    var a = value

    generateSequence(a) { a = when { a % 2 == 0 -> a / 2 else ->  3 * a + 1}; a }
        .takeWhile{a > 1}
        .forEach{print("$it ")}
    println(1)
}

/*********************************************************************************************************************/

fun four069one()
{
    while (true) {
        val count = readInt("Bir sayı giriniz:")

        if (count == 0)
            break

        generateSequence { Random.nextInt(1, 100) }
            .distinct()
            .take(count)
            .forEach {print("$it ")}

        println()
    }
}

/*********************************************************************************************************************/

fun four069two()
{
    while (true) {
        val count = readInt("Bir sayı giriniz:")

        if (count == 0)
            break

        generateSequence { Random.nextLong(Long.MIN_VALUE, Long.MAX_VALUE) }
            .distinct()
            .take(count)
            .forEach {print("$it ")}

        println()
    }
}

/*********************************************************************************************************************/

fun five069() = numericLotteryNumbers(readInt("Kaç tane kupon oynamak istersiniz?")).forEach{ it.writeFnc(2) }

fun numericLotteryNumbers(count: Int, random: Random = Random) : Array<IntArray>
{
    return generateSequence { numericLotteryNumbers(random) }.take(count).toList().toTypedArray()
}

fun numericLotteryNumbers(random: Random = Random): IntArray
{
    return generateSequence { random.nextInt(1, 50) }.distinct().take(6).sorted().toList().toIntArray()
}
