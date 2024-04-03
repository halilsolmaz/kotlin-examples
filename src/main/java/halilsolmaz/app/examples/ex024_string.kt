/*-----------------------------------------------------------------------------------------------------
    1.
    String sınıfı Java da ki gibi immutable dır. İki tırnak içerisindeki ifadeler String türündendir.

    2.
    Klavyeden String okunması durumunda elde edilen nesneler farklıdır.

    3.
    Özdeş String atomları için aynı adres kullanılır.

    4.
    String sınıfının compareTo metodunun ignoreCase parametresi ile büyük küçük harf duyarsız (case insensitive)
    karşılaştırma yapılabilir.

    5.
    Kotlin Stringte java dan farklı olarak == ve != operatörleri(equals override edilmiş), adres karşılaştırması
    değil yazı karşılaştırması yaparlar. (Referans karşılaştırması için == ve !=== kullanılabilir)

    Not: equals metodunun ignorecase parametresi default olarak false'dur.

    6.
    String sınıfının toUpperCase ve toLowerCase metodu Kotlin 1.5 ile birlikte deprecated olmuştur.
    Bu fonksiyon yerine upperCase ve lowerCase fonksiyonu kullanılmalıdır.

    7.
    String sınıfının indexOf ve lastIndexOf metotları bulunmaktadır. (örnek için bkz: hw007)

    Not: Java dan farklı olarak indexOf ve lastIndexOf metodlarının ignorecase parametresi vardır.

    8.
    isBlank ve isEmpty fonksiyonları. isBlank fonksiyonu yazının tamamı boşluk (whitespace) karakterlerinden oluşuyorsa
    true döndürür. isEmpty fonksiyonu yerine s == "" karşılaştırması kullanılabilir.

    9.
    Kotlin'e ait bazı sınıflarda isXXX metotlarının isNotXXX versiyonları da bulundurulur. Okunabilirlik açısından
    "mantıksal değil operatörü" ile isXXX çağırmak yerine isNotXXX çağrılmalıdır.

    Not: Java da böyle bir yaklaşım yoktur.

    10.
    String sınıfının indexer elemanı ile yazının bir indekteki karakter elde edilebilir. indexer elemanı [] operatör fonksiyonu
    gibi düşünülebilir. Operatör fonksiyonları ileride ele alınacaktır.

    Not: Tabiki immutable olduğu için atama yapılamaz.

    11.
    String sınıfının tüm karakterleri for döngüsü ile elde edilebilir. Yani String sınıfı "iterable"'dır. Iterable kavramı
    ileride ele alınacaktır.

    Not: Java da String sınıfı iterable değildir.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
   /* println("---------------------------------------------------------------------")
    two024()
    println("---------------------------------------------------------------------")
    three024()
    println("---------------------------------------------------------------------")
    five024()
    println("---------------------------------------------------------------------")
    seven024()*/
    println("---------------------------------------------------------------------")
    eight024()
    println("---------------------------------------------------------------------")
    ten024()
    println("---------------------------------------------------------------------")
    eleven024()
}

fun two024()
{
    print("Birinci yazıyı giriniz:")
    val s = readln()

    print("İkinci yazıyı giriniz:")
    val k = readln()

    println(s === k)
}

fun three024()
{
    val s1 = "ankara"
    val s2 = "ankara"

    println(s1 == s2)
    println(s1 != s2)
    println(s1 === s2)
    println(s1 !== s2)
}

fun five024()
{
    val s1 = "ankara"
    val s2 = "AnKara"

    println(s1 == s2)
    println(s1.equals(s2, true))
}

fun seven024()
{
    val s1 = "İyi bir Android programcısı olmak için çok çalışmak gerekir. Çok çok çalışmak gerekir"
    val s2 = "Çok"

    println(s1.indexOf(s2))
    println(s1.indexOf(s2, 66))
    println(s1.indexOf(s2, ignoreCase = true))

    println("***********************")

    val s3 = "İyi bir Android programcısı olmak için çok çalışmak gerekir. Çok çok çalışmak gerekir"
    val s4 = "çok"
    val index = s3.lastIndexOf(s4)

    println(index)
}

fun eight024()
{
    print("Bir yazı giriniz:")
    val s = readln()

    println(s.isBlank())
    println(s.isEmpty())
    println(s == "")
}

fun ten024()
{
    val s = "HaLil"

    for (i in 0 until s.length)
        print("${s[i]} ")

    println()
}

fun eleven024()
{
    val s = "HaliL"

    for (ch in s)
        print("$ch ")

    println()
}