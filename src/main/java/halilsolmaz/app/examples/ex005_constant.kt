/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin' de hexadecimal sabitler 0x veya 0X ile yazılabilir

    2.
    Kotlin'de octal sabit yoktur. Sayının başına sıfır konması da geçersizdir

    NOT: Java da vardır

    3.
    Kotlin'de binary sabit 0b veya 0B ile kullanılabilmektedir

    4.
    Kotlin' de gerçek sayı sabitleri üstel olarak yazılabilir. Sayının değeri ne olursa olsun üstel olarak yazılan
    sabitler Double türdendir
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    val a = 0xA
    val b = 0b1010
    val avogadroNumber: Double = 6.02E23
    //val c = 012 //error ama Java da geçerli

    println("a = $a")
    println("b = $b")
    println("Avogadro Number = $avogadroNumber")
}