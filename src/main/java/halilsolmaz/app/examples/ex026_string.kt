/*-----------------------------------------------------------------------------------------------------
    1.
    Char türünün bazı isXXX metotları

    2.
    Char türünün upperCase metodu. Bu ve lowercase metodu String'e geri döner. Char dondüren versiyonları için upperCaseChar
    ve lowerCaseChar metotları kullanılmalıdır.

    Not: String bir çalışma sorusu için bkz: hw008

    3.
    String sınıfının substring metotları

    4.
    String sınıfının substringBefore ve substringAfter metotları

    5.
    String sınıfının substringBefore ve substringAfter metotlarının  missingDelimiterValue(2. parametre) parametreleri
    String türdendir. Ayraç bulunamazsa default olarak yazının kendisini döner. Programcı bu parametre için, ayraç
    bulamadığında döneceği yazıyı argüman olarak geçebilir.

    String sınıfının substringBefore ve substringAfter metotları ayraç olarak bir String alabilirler.

    Not: Bu metotlar java da doğrudan yoktur.

    6.
    String sınıfının substringBefore ve substringAfter metotlarının  missingDelimiterValue parametreleri String türdendir.
    Ayraç bulunamazsa default olarak yazının kendisini döner. Programcı bu parametre için, ayraç bulamadığında döneceği yazıyı
    argüman olarak geçebilir.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    one026()
    println("---------------------------------------------------------------------")
    two026()
    println("---------------------------------------------------------------------")
    three026()
    println("---------------------------------------------------------------------")
    four026()
    println("---------------------------------------------------------------------")
    fiveSix026()
}

fun one026()
{
    print("Bir karakter giriniz:")
    val ch = readln()[0]

    println(if (ch.isDigit()) "rakam" else "rakam değil")
    println(if (ch.isWhitespace()) "boşluk" else "boşluk değil")
    println(if (ch.isLetter()) "alfabetik" else "alfabetik değil")
}

fun two026()
{
    print("Bir karakter giriniz:")
    val ch = readln()[0]

    println(ch.uppercase())
}

fun three026()
{
    val s = "ankara"

    println(s.substring(2))
    println(s.substring(2, 5)) //[2, 5)
    println(s.substring(2..4)) //[2, 4]
    println(s.substring(2 until 5)) //[2, 5)

    println("********************")

    val s2 = "a"
    println(s2.substring(1)) // Error vermez, "" döner.
}

fun four026()
{
    val s = "ankara-istanbul-izmir"

    println(s.substringAfter('-'))
    println(s.substringBefore('-'))
}

fun fiveSix026()
{
    val s = "ankara"
    println(s.substringAfter('-'))
    println(s.substringBefore('-'))

    println("********************")

    val s1 = "ankara"
    println(s1.substringAfter('-', "city1"))
    println(s1.substringBefore('-', "city2"))

    println("********************")

    val s2 = "ankara-;istanbul-;izmir"
    println(s2.substringAfter("-;", "city1")) // istanbul-;izmir
    println(s2.substringBefore("-;", "city2")) // ankara

    println("********************")

    val s3 = "ankara-;istanbul-;izmir"
    println(s3.substringAfterLast("-;", "city1")) // izmir
    println(s3.substringBeforeLast("-;", "city2")) // ankara-;istanbul
}