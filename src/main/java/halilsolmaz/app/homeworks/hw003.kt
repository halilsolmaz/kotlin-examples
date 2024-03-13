/*----------------------------------------------------------------------------------------------------------------------
    Parametresi ile aldığı gün, ay ve yıl bilgisine ilişkin tarihin haftanın hangi gününe
    geldiğini döndüren getDayOfWeek global fonksiyonunu aşağıdaki açıklamalara uygun olarak yazınız.

    Açıklama:
    - Aşağıdaki test kodu ile fonksiyonlarınız için genel bir test yapınız
    - Programda tarih zamana ilişkin sınıflar kullanılmayacaktır.
    - getDayOfWeek fonksiyonu 1.1.1900 tarihinden sonraki tarihler için çalışacaktır.
    - Fonksiyonlar geçersiz bir tarih için -1 değerini döndürecektir
    - Haftanın günü bilgisi, 1.1.1900 ile verilen tarih arasındaki toplam gün sayısı hesaplanıp 7 değerine
    göre modu alınarak bulunabilir. Bu değere göre sıfır pazar, 1 pazartesi, ..., 6 değeri de Cumartesi
    gününe karşılık gelir
    - Programda dizi kullanılmayacaktır
    - Aşağıdaki fonksiyonların kesinlikle yazılması koşuluyla istediğiniz fonksiyonu ekleyebilirsiniz.
    - Yazılmış fonksiyonlar içerisinde değişiklik yapabilirsiniz. Ancak test etmeniz gerektiğini unutmayınız
    - Çözüm şu ana kadar gördüğümüz konular kullanılarak yapılacaktır
    - String referansına geri dönen fonksiyonlarda String sınıfını kullanmanız gerekmez. String literal oluştururak
    yapınız

    (İleride daha iyisi yazılacaktır)
----------------------------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks

fun main() = runtTest();

fun runtTest()
{
    while (true) {
        print("Gün?")
        val day = readInt()

        if (day <= 0)
            break

        print("Ay?")
        val month = readInt()

        print("Yıl?")
        val year = readInt()

        displayDateTR(day, month, year)
        displayDateEN(day, month, year)
    }

    println("Tekrar yapıyor musunuz?")
}

fun readInt() = readln().toInt()

fun displayDateTR(day: Int, month: Int, year: Int)
{
    val dayOfWeek = getDayOfWeek(day, month, year)

    println(when {
        dayOfWeek >= 0 -> "$day ${getMonthNameTR(month)} $year ${getDayOfWeekTR(dayOfWeek)}"
        else -> "Geçersiz Tarih"
    })
}

fun displayDateEN(day: Int, month: Int, year: Int)
{
    val dayOfWeek = getDayOfWeek(day, month, year)

    println(when {
        dayOfWeek >= 0 -> "$day${getDaySuffix(day)} ${getMonthNameEN(month)} $year ${getDayOfWeekEN(dayOfWeek)}"
        else -> "Invalid Date"
    })
}

fun getDaySuffix(day: Int) :String
{
    TODO()
}

fun getDayOfWeekTR(dayOfWeek: Int) : String
{
    TODO()
}

fun getMonthNameTR(month: Int) : String
{
    TODO()
}

fun getDayOfWeekEN(dayOfWeek: Int) : String
{
    TODO()
}

fun getMonthNameEN(month: Int) : String
{
    TODO()
}

fun getDayOfWeek(day: Int, month: Int, year: Int) : Int
{
    TODO()
}

fun getTotalDays(year: Int) : Int
{
    var totalDays = 0

    for (y in 1900 until year)
        totalDays += if (isLeapYear(y)) 366 else 365

    return totalDays
}

fun getDayOfYear(day: Int, month: Int, year: Int) : Int
{
    TODO()
}

fun getDaysOfMonth(month: Int, year: Int) : Int
{
    TODO()
}

fun isValidDate(day: Int, month: Int, year: Int) : Boolean
{
    TODO()
}

fun isLeapYear(year: Int) = year % 4 == 0 && year % 100 != 0 || year % 400 == 0