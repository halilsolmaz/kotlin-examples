/*-----------------------------------------------------------------------------------------------------
       Sınıf Çalışması: Parametresi ile aldığı 1, 2 veya 3 basamaklı bir sayının Türkçe yazı karşılığını döndüren
    numToStr3DigitsTR fonksiyonunu yazınız ve aşağıdaki kod ile test ediniz.
    Açıklamalar:
        - Fonksiyon basamak sayısı kontrolü yapmayacaktır
        - Bu fonksiyonun daha geneli yazıldığında private olarak bildirilecektir. Şimdilik bunu görmezden geliniz
----------------------------------------------------------------------------------------------------------------------*/


package halilsolmaz.app.homeworks

import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.math.abs
import kotlin.random.Random

fun main() = runNumToStrTest()

fun runNumToStrTest()
{
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val value = Random.nextInt(-999, 1000)
        println("$value -> ${numToStr3DigitsTR(value)}")
    }

    println("Tekrar yapıyor musunuz?")
}

val g_onesTR = arrayOf("", "bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz")
val g_tensTR = arrayOf("", "on", "yirmi", "otuz", "kırk", "elli", "altmış", "yetmiş", "seksen", "doksan")

fun numToStr3DigitsTR(value: Int) : String
{
    val str = StringBuilder(countDigits(value))
    val arr = digits(value)

    if (value < 0) str.append("eksi") else str.append("")

    if (arr.size == 3)
    {
        if(arr[0] >= 2)
            str.append(g_onesTR[arr[0]])
        if(arr[0] >= 1)
            str.append("yüz")
        str.append(g_tensTR[arr[1]] + g_onesTR[arr[2]])
    } else if (arr.size == 2){
        str.append(g_tensTR[arr[0]] + g_onesTR[arr[1]])
    } else {
        if (value == 0) str.append("sıfır") else str.append(g_onesTR[abs(value)])
    }

    return str.toString()
}