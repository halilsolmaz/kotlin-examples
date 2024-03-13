/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'de fonksiyon içerisinde fonksiyon bildirimi yapılabilir. İçteki fonksiyon bildirildiği yerden
    bildirildiği bloğun sonuna kadar çağrılabilir. Başka bir yerden çağrılamaz.
    Bu tür fonksiyonlara "yerel (local) fonksiyonlar" denir

    2.
    Yerel fonksiyonlar içerisinde kendisinden önce bildirilen yerel değişkenler ve parametre değişkenleri
    kullanılabilir. Bu kavrama "capture" denir

    Yerel fonksiyonlar içerisinde kendisinden önce bildirilen yerel fonksiyonlar da çağrılabilir.
    Bu kavrama da "capture" denir.

    3.
    Yerel fonksiyonlar içerisinde kendisinden önce bildirilen yerel değişkenler kullanılabilir hatta değiştirilebilir.

    Anahtar Notlar: Java'da yakalanan (capture) değişkenlere faaliyet alanları boyunca bir kez atama yapılabilir.
    Bu atamanın da yakalanmadan önce yapılması zorunludur (effectively final)

    4.
    Java ve Kotlinde mod işlemi için;
    - Birinci operandın işareti sonucun işaretini belirler.

    5.
    % operatörüne karşılık gelen fonksiyon Kotlin'in ilk sürümlerinde "mod" isimli bir fonksiyondu. Daha
    sonra mod fonksiyonu "rem" fonksiyonu olarak değiştirildi. Ancak Kotlin 1.5 ile birlikte bir çok eklenen
    matematiksel (extension olarak yazılan) fonksiyon ile birlikte Matematikteki mod işlemine karşılık "mod" isimli
    fonksiyon da eklendi. Bu anlamda mod fonksiyonu operatör fonksiyonu değildir

    6.
    Ex: Parametresi ile aldığı 3 basamaklı Int türden bir sayının basamakları toplamını döndüren
    sum3Digits fonksiyonu ve test kodunu yazınız. Fonksiyon basamak sayısı kontrolü yapmayacaktır

    7.
    Temel türlere ilişkin sınıflar immutable'dır.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    oneTwoThree009()
    println("---------------------------------------------------------------------")
    fourFive009()
    println("---------------------------------------------------------------------")
    six009()
}

fun foo009(a: Int)
{
    var temp = a
    fun isEven() = temp++ % 2 == 0

    if (isEven())
        println("$temp is even")
    else
        println("$temp is odd")

    if (isEven())
        println("$temp is even")
    else
        println("$temp is odd")
}

fun oneTwoThree009()
{
    print("Bir sayı giriniz:")
    val a = readln().toInt()

    foo009(a)
}

fun fourFive009()
{
    println(10 % 3)
    println(10 % -3)
    println(-10 % 3)
    println(-10 % -3)
    println("---------------------------------------------------------------------")
    println(10.mod(3))
    println(10.mod(-3))
    println(-10.mod(3))
    println(-10.mod(-3))
}

fun six009()
{
    println("Give a three digit number")
    val value = readln().toInt()
    println("value = $value")
    val result = sum3Digits(value)
    println("sumOfDigits: $result")
}
fun sum3Digits(value: Int) : Int
{
    val a = value / 100
    val b = value / 10 % 10
    val c = value % 10

    return kotlin.math.abs(a + b + c)
}
