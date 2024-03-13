/*-----------------------------------------------------------------------------------------------------
    1.
    if ifadesinin koşul operatörü yerine kullanımı (bkz. one011)
    Anahtar Notlar: Kotlin'de Java'dan farklı olarak koşul operatörü (conditional operator(a ? b : c)) yoktur

    2.
    if deyimin return ile bu kullanım şeklinde Java dan farklı olarak return ve if deyimi aynı satırda
    olmalıdır.

    3 if deyimi else deyimi ile birlikte tek bir ifade gibi düşünülmelidir. Dangling else durumu bu şekilde
    analiz edilmelidir..

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    one011()
    println("---------------------------------------------------------------------")
    two011()
}

fun one011()
{
    val a = readln().toInt()
    println(if (a % 2 == 0) "Even" else "Odd")
}

fun equals011() : String
{
    val a = readln().toInt(); val b = readln().toInt()
    return if (a == b)
        "Equal"
    else
        "Not equal"
}
fun two011()
{
    println(equals011())
}