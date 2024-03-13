/*-----------------------------------------------------------------------------------------------------
    1.
    while döngü deyiminin parantezi içerisinde atama yapılması geçersizdir. Anımsanacağı gibi atama operatörü bir
    ifade oluşturmaz. Dolayısıyla değer üretmez.

    while ((value = readln().toInt()) != 0) //error
        ++count

    2.
    do-while döngü deyiminde Java ve C#'dan farklı olarak do-while döngü deyimi içerisinde bildirilmiş olan bir
    değişkenin while parantezi içerisinde kullanımı geçerlidir

    3.
    for döngü deyimi Java'daki klasik for döngüsü değildir. Java'daki for-each döngü deyiminin
    daha yetenekli bir biçimi olarak düşünülebilir. Kotlin'de klasik for döngüsü yoktur. Ancak klasik for döngüsünün
    olmaması bir eksiklik değildir. Kotlin'deki for döngü deyimiyle çeşitli operatörler ve infix fonksiyonlar yardımıyla
    klasik for döngü deyimi ihtiyacı karşılanabilmektedir. İleride detaylı olarak ele alınacaktır

    4.
    .. ile belirtilen operatör "range" sınıfları türünden referans üretir. Bu sınıflar Iterable arayüzünü
    desteklediği için for döngüsü ile dolaşılabilir. Iterable arayüzü ileride ele alınacaktır. Aslında Kotlin'deki
    for döngü deyimi Java'nın "for-each/enhanced for loop"'udur

    5.
    Bu döngü(bkz: fourFive012()) teknik olarak IntProgression sınıfı türünün infix step fonksiyonu
    kullanılarak yapılmıştır

    Not: step fonksiyonu pozitif tamsayı olmalıdır.

    6.
    downTo infix fonksiyonu ile for döngüsü içerisinde ters sırada dönen bir döngü yazılabilir

    Not: downTo ve step fonksiyonları birlikte kullanılabilir

    7.
    until infix fonksiyonu ile [a, b) aralığında döngü deyimi oluşturulabilir

    Not: downTo ve step fonksiyonları birlikte kullanılabilir

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    two012()
    println("---------------------------------------------------------------------")
    fourToSeven012()
}

fun two012()
{
    do {
        val a = readln().toInt() // Java da a'nın bildirimi do'dan önce yapılmalıydı.
        println(a)
    } while (a != 0)

    // a = 10 // error (a'nın scope alanı while'da bitti)
}

fun fourToSeven012()
{
    for (i in 1..10)
        print("$i ")

    for (i in 10..1) // range'in büyükten küçüğer giden bir kullanımı yoktur. Error vermez ama anlamsızdır.
        print("&i ")

    println()

    for (i in 1..10 step 2)
        print("$i ")

    println()

    for (i in 10 downTo 1)
        print("$i ")

    println()

    for (i in 10 downTo 1 step 3)
        print("$i ")

    println()

    for (i in 1 until 10)
        print("$i ")

    println()

    for (i in 1 until 10 step 3)
        print("$i ")
}
