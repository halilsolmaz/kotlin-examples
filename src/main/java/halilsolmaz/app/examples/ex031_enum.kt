/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'deki enum türü Java'dakine çok benzer.

    Not: enum kullanımı Android programlamada bazı durumlarda performası olumsuz yönde etkileyebilir. Bu tip
    durumlar ileride ela alınacaktır

    Not: Enum sabitler ilk kullanıldıklarında oluşturulur ve programnın sonuna kadar yaşarlar. Bu
    durum bazen android dünyasında problem yaratabilir.

    2.
    enum türleri enum ve class anahtar sözcükleri ile bildirilir.
    enum sabitleri (enum constants) ait oldukları enum türünden referanslardır.
    Şüphesiz bu referanslar da aynı enum türünden yaratılmış olan nesnelerin adreslerini tutarlar.

    3.
    enum class türünden nesne hiç bir şekilde yaratılamaz. Sabitlere ilişkin nesneler zaten yaratılmıştır.
    Bu anlamda bir enum class'ın ctor'ları private'dan öte bir erişime sahiptir. Çünkü private den farklı olarak
    enum sınıf içerisinde bile bir nesne yaratılamaz.

    4.
    enum türlerinin ordinal property elemanı o enum referansına ilişkin sabitin bildirim sıra numarasını verir.
    ordinal numarası sıfırdan başlar.

    5.
    enum türlerinin values metodu tüm enum sabitlerine ilişkin referanslardan oluşan dizi referansı döndürür.
    Yani enum türlerinin sabitlere ilişkin referanslar values isimli metot ile elde edilebilir

    6.
    enum türlerinin valueOf metodu parametresi ile aldığı yazıya ilişin bir enum sabiti varsa o sabitin tuttuğu adrese
    geri döner. Yoksa exception oluşur

    7.
    enum sabitlerine değer iliştirilebilir

    8.
    enum'ların eşitlik karşılaştırması ==(equals çağırır) veya ===(ref karşılaştırması yapar) operatörü ile yapılabilir.
    Enum'un equals metodu da referans karşılaştırması yaptığı için iki operator aynı anlamdadır.

    9.
    enum'lara başka elemanlar da eklenebilmektedir.

    10.
    enum sınıfları ile Java' da olduğu gibi Kotlin'de de Singleton bir sınıf yazılabilir. Kotlin'de Singleton sınıf
    yazmanın daha kolay bir yöntemi de ileride anlatılacaktır

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.console.kotlin.readString
import kotlin.random.Random


fun main()
{
    println("--------------------------------two-------------------------------------")
    two031()
    println("--------------------------------three-------------------------------------")
    three031()
    println("--------------------------------four-------------------------------------")
    four031()
    println("--------------------------------five-------------------------------------")
    five031()
    println("--------------------------------six-------------------------------------")
    six031()
    println("--------------------------------seven-------------------------------------")
    seven031()
    println("--------------------------------eight-------------------------------------")
    eight031()
    println("--------------------------------nine-------------------------------------")
    nine031()
    println("--------------------------------ten-------------------------------------")
    ten031()
}

fun two031()
{
    val favColor: Color = Color.BLUE

    println(favColor.toString())
}

fun three031()
{
    // val favColor = Color() // Error
    // println(favColor.toString())
}

fun four031()
{
    val favColor = Color.GREEN
    val ordinal = favColor.ordinal

    println("ordinal of $favColor is $ordinal")
}
fun five031()
{
    val ordinal = 2
    val color = Color.values()[ordinal]

    println(color)

    println("**********************")

    for (dayOfWeek in DayOfWeek.values())
        print("$dayOfWeek ")

    println()
}

fun six031()
{
    val s = readString("Input the day of week as string with three characters:")
    val dow = DayOfWeek.valueOf(s.uppercase())

    println(dow)
}

fun seven031()
{
    val colorValues = Color2.values()
    val monthValues = Month.values()
    val count = readInt("Bir sayı giriniz:")

    for (i in 1..count) {
        val favColor = colorValues[Random.nextInt(colorValues.size)]
        val month = monthValues[Random.nextInt(monthValues.size)]

        println("-------------------------------------------------------")
        println("(R=${favColor.r}, G=${favColor.g}, B=${favColor.b})")
        println("${month.textTR}, ${month.days}")
        println("-------------------------------------------------------")
    }
}

enum class Month(val days: Int, val textTR: String) {
    JAN(31, "Ocak"), FEB(28, "Şubat"), MAR(31, "Mart"), APR(30, "Nisan"), MAY(31, "Mayıs"),  JUN(30, "Haziran"),
    JUL(31, "Temmuz"), AUG(31, "Ağustos"), SEP(30, "Eylül"), OCT(31, "Ekim"), NOV(30, "Kasım"), DEC(31, "Aralık")
}

enum class Color2(val r: Int = 0, val g: Int = 0, val b: Int = 0) {
    RED(255), GREEN(g = 255), BLUE(b = 255), WHITE(255, 255, 255), BLACK
}


enum class DayOfWeek {
    SUN, MON, TUE, WED, THU, FRI, SAT
}

enum class Color {
    RED, GREEN, BLUE
}

fun eight031()
{
    val favColor = Color.GREEN
    val favColor2 = Color.BLUE
    val favColor3 = Color.GREEN

    println(if (favColor === favColor2) "Aynı renk" else "Farklı renkler")
    println(if (favColor == favColor3) "Aynı renk" else "Farklı renkler")
}
fun nine031()
{
    val count = readInt("Bir sayı giriniz:")
    val values = Month2.values()
    val size = values.size

    for (i in 1..count) {
        val month = values[Random.nextInt(size)]
        val year = Random.nextInt(1999, 2150)

        println("${year}, ${month.textTR}, ${month.getDaysByYear(year)}")
    }
}

enum class Month2(val days: Int, val textTR: String) {
    JAN(31, "Ocak"), FEB(28, "Şubat"), MAR(31, "Mart"), APR(30, "Nisan"), MAY(31, "Mayıs"),  JUN(30, "Haziran"),
    JUL(31, "Temmuz"), AUG(31, "Ağustos"), SEP(30, "Eylül"), OCT(31, "Ekim"), NOV(30, "Kasım"), DEC(31, "Aralık");
    companion object {
        private fun isLeapYear(year: Int) = year % 4 == 0 && year % 100 != 0 || year % 400 == 0
    }

    fun getDaysByYear(year: Int) = if (ordinal == 1 && isLeapYear(year)) 29 else days
}

fun ten031()
{
    val repository1 = DeviceRepository.INSTANCE
    val repository2 = DeviceRepository.INSTANCE

    println(if (repository1 === repository2) "Aynı nesne" else "Farklı nesneler")
}

enum class DeviceRepository {
    INSTANCE;
    //...
}