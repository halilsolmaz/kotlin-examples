/*-----------------------------------------------------------------------------------------------------
    1.
    LocalDate sınıfının of metotları

    2.
    LocalDate sınıfının Month enum class parametreli of metodu

    3.
    LocalDate sınıfı (ve tüm diğer Java 8 tarih-zaman sınıfları) geçerlilik kontrolü yapar. Bu sınıflar geçerli olmayan
    bilgiler için DateTimeException nesnesi fırlatır

    4.
    LocalDate sınıfının now isimli static metodu sistemin tarih bilgisini elde etmekte kullanılır

    5.
    LocalDate sınıfının isAfter ve isBefore metotları ve equals metodu

    6.
    ChronoUnit enum sınıfı ile tarih-zaman ölçümleri yapılabilir

    7.
    LocalDate sınıfını kullanarak iki tarih arasındaki toplam yılı Double türden çıkartma operatörü
    ile hesaplayan kodları yazınız.

    8.
    LocalDate sıfınının plusXXX metotları

    9.
    Tarih-zaman sınıflarının withXXX metotları

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.console.kotlin.readString
import java.time.DateTimeException
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.time.Month

fun main()
{
    println("-------------------------------one--------------------------------")
    one076()
    println("-------------------------------two--------------------------------")
    two076()
    println("-------------------------------three--------------------------------")
    three076()
    println("-------------------------------four--------------------------------")
    four076()
    println("-------------------------------five--------------------------------")
    five076()
    println("-------------------------------six--------------------------------")
    six076()
    println("-------------------------------seven--------------------------------")
    seven076()
    println("-------------------------------eight--------------------------------")
    eight076()
    println("-------------------------------nine--------------------------------")
    nine076()
}

/*********************************************************************************************************************/

fun one076()
{
    val date = LocalDate.of(2023, 6, 21)

    println("${date.dayOfMonth}/${date.monthValue}/${date.year}")
    println("${date.dayOfMonth} ${date.month} ${date.year} ${date.dayOfWeek}")
}

/*********************************************************************************************************************/

fun two076()
{
    val date = LocalDate.of(2023, Month.JUNE, 21)

    println("${date.dayOfMonth}/${date.monthValue}/${date.year}")
    println("${date.dayOfMonth} ${date.month} ${date.year} ${date.dayOfWeek}")
}

/*********************************************************************************************************************/

fun three076()
{
    while (true) {
        try {
            val day = readInt("Gün bilgisini giriniz:")

            if (day == 0)
                break

            val month = Month.valueOf(readString("Ay bilgisini giriniz:JANUARY, FEBRUARY, MARCH, ..., DECEMBER:").uppercase())
            val year = readInt("Yıl bilgisini giriniz:")
            val date = LocalDate.of(year, month, day)

            println("${date.dayOfMonth}/${date.monthValue}/${date.year}")
            println("${date.dayOfMonth} ${date.month} ${date.year} ${date.dayOfWeek}")
        }
        catch (ignore: DateTimeException) {
            println("Geçersiz tarih!...")
        }
        catch (ignore: IllegalArgumentException) {
            println("Geçersiz ay bilgisi!...")
        }
    }

    println("Tekrar yapıyor musunuz?")
}

/*********************************************************************************************************************/

fun four076()
{
    val date = LocalDate.now()

    println("${date.dayOfMonth} ${date.month} ${date.year} ${date.dayOfWeek}")
}

/*********************************************************************************************************************/

fun five076()
{
    val today = LocalDate.now()
    val date = LocalDate.of(2023, Month.SEPTEMBER, 10)

    println(date.isAfter(today))
    println(today.isBefore(date))
    println(today == date)
}

/*********************************************************************************************************************/

fun six076()
{
    val today = LocalDate.now()
    val date = LocalDate.of(1999, Month.AUGUST, 17)

    println(ChronoUnit.DAYS.between(date, today))
    println(ChronoUnit.YEARS.between(date, today))
    println(ChronoUnit.MONTHS.between(date, today))
    println(ChronoUnit.WEEKS.between(date, today))
}

/*********************************************************************************************************************/

operator fun LocalDate.minus(localDate: LocalDate) = ChronoUnit.DAYS.between(localDate, this) / 365.0

fun seven076()
{
    val birthDate = LocalDate.of(1976, Month.SEPTEMBER, 10)
    val today = LocalDate.now()

    val age = today - birthDate

    println("Age:$age")
}

/*********************************************************************************************************************/

fun eight076()
{
    val today = LocalDate.now()
    val date = today.plusWeeks(20).plusDays(3)

    println(today)
    println(date)
}

/*********************************************************************************************************************/

fun nine076()
{
    val now = LocalDate.now()
    val birthDate = LocalDate.of(1976, Month.SEPTEMBER, 10)
    val birthDay = birthDate.withYear(now.year)

    val age = ChronoUnit.DAYS.between(birthDate, now) / 365.0

    println("%.20f".format(age))
    println(birthDay)
}

