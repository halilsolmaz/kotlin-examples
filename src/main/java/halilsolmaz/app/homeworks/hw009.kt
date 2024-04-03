/*-----------------------------------------------------------------------------------------------------
    Parametresi ile aldığı bir yazının pangram olup olmadığını test eden isPangramTR ve isPangramEN
    fonksiyonlarını yazınız ve aşağıdaki kod ile test ediniz
    Açıklama: Fonksiyonlar özel isim ve cümle anlamı kontrolü yapmayacaktır
    Türkçe pangram      : Pijamalı hasta yağız şoföre çabucak güvendi
    İngilizce pangram   : The quick brown fox jumps over the lazy dog
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks
fun main() = runIsPangramTest()

fun runIsPangramTest()
{
    runIsPangramTRTest()
    runIsPangramENTest()
}

fun runIsPangramTRTest()
{
    while (true) {
        print("Bir yazı giriniz:")
        val s = readln()

        if ("elma" == s)
            break

        println(if (isPangramTR(s)) "Pangram" else "Pangram değil")
    }
}

fun runIsPangramENTest()
{
    while (true) {
        print("Input a text:")
        val s = readln()

        if ("quit" == s)
            break

        println(if (isPangramEN(s)) "Pangram" else "Not a Pangram")
    }
}

fun isPangram(s: String, alphabet: String) : Boolean
{
    for (c in alphabet) {
        if (!s.contains(c, true))
            return false
    }

    return true
}

fun isPangramTR(s: String) = isPangram(s,"abcçdefgğhıijklmnoöprsştuüvyz")
fun isPangramEN(s: String) = isPangram(s,"abcdefghijklmnopqrstuvwxyz")
