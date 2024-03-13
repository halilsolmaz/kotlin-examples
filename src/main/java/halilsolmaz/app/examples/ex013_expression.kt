/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlinde "etiketli break"(labeled break)  kullanımı syntax açısından Java'dan biraz farklıdır.
    - Etiket bildirimi sonunda @ atomu yazılmalıdır.
    - break@<etiket ismi> deyimi boşluk içeremez.

    2.
    Kotlin'de switch deyimi yoktur. Ancak benzer şekilde kullanılabilecek when ifadesi (ifadesel deyimi) vardır.
    Java 14 ile birlikte switch'in ifade olarak kullanımı da Java'ya eklenmiştir (switch expression).
    Bu anlamda switch de artık ifadesel deyim olarak kullanılabilir. switch expression, when expression'a
    oldukça benzemektedir.

    Not: ifade değer üretmek demektir, deyim ise çalıştırmak anlamındadır.

    3.
    when ifadesinin switch deyimine benzer kullanımı. when ifadesinde aşağı düşme (fall through) özelliği yoktur.

    4.
    when ifadesinin parantezsiz kullanımı için bakınız four013()

    Not: Java da böyle bir kullanım geçersizdir.

    5.
    when'in ifadesini biçimin ürettiği değerin kullanımı için bkz five013

    6.
    when ifadesinin in ve !in (not in) operatörleri ile kullanımı. in ve !in operatörleri ileride ele alınacaktır

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    one013()
    println("---------------------------------------------------------------------")
    twoThree013()
    println("---------------------------------------------------------------------")
    four013()
    println("---------------------------------------------------------------------")
    five013()
    println("---------------------------------------------------------------------")
    six013()
}

fun one013()
{
    EXIT_LOOP@
    for (i in 10..20) {
        for (k in 2..34) {
            println("($i, $k)")
            if ((i + k) % 11 == 0)
                break@EXIT_LOOP // bitişik yazılmak zorundadır.
        }
    }
}

fun twoThree013 ()
{
    println("code giriniz")
    val code = readln().toInt();
    when (code) {
        212, 216 -> println("İstanbul")
        312 -> println("Ankara")
        372 -> println("Zonguldak")
        else -> println("Geçersiz telefon kodu!...")
    }
}

fun four013()
{
    println("sayı giriniz")
    val n = readln().toInt();
    when {
        n > 0 -> println("Pozitif")
        n == 0 -> println("Sıfır")
        else -> println("Negatif")
    }

    println("---------------------------------------------------------------------")
    // Bu ifade şu şekilde de yapılabilirdi:

    println(when {
        n > 0 -> "Pozitif"
        n == 0 -> "Sıfır"
        else -> "Negatif"
    })
}

fun five013()
{
    print("Bir sayı giriniz:")
    val a = readln().toInt()

    val message = when {
        a > 0 -> "Pozitif"
        a == 0 -> "Sıfır"
        else -> "Negatif"
    }

    println(message)
}

fun six013()
{
    print("Bir sayı giriniz:")
    val value = readln().toInt()

    when (value) {
        in 10..20 -> println("10 <= value <= 20")
        !in 1..3 -> println("value < 1 || value > 3")
        else -> println("Geçersiz değer")
    }
}