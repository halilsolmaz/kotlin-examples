/*-----------------------------------------------------------------------------------------------------
    1.
    LocalTime sınıfının atDate metodu

    2.
    LocalDate sınıfının atTime metodu

    3.
    LocalDateTime sınıfının toLocalDate ve toLocalTime sınıfları

    4.
    DateTimeFormatter sınıfı ile tarih ve/veya zaman bilgilerinin formatlanması

    5.
    LocalDate, LocalTime ve LocalDateTime sınıflarının parse metotları

    6.
    Aşağıdaki örnekte birden fazla formatter ile işlem yapan örnek bir fonksiyon yazılmıştır. Detaylar gözardı edilmiştir.
    Bir kütüphane içerisine daha detaylısı eklenecektir
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readString
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.Month

fun main()
{
    println("-------------------------------one--------------------------------")
    one077()
    println("-------------------------------two--------------------------------")
    two077()
    println("-------------------------------three--------------------------------")
    three077()
    println("-------------------------------four--------------------------------")
    four077()
    println("-------------------------------five--------------------------------")
    five077()
    println("-------------------------------six--------------------------------")
    six077()
}

/*********************************************************************************************************************/

fun one077()
{
    val currentTime = LocalTime.now()
    val today = LocalDate.now()
    val now = currentTime.atDate(today)

    println(now)
}

/*********************************************************************************************************************/

fun two077()
{
    val date = LocalDate.of(2020, Month.APRIL, 12)
    val datetime = date.atTime(LocalTime.now())

    println(datetime)
}

/*********************************************************************************************************************/

fun three077()
{
    val now = LocalDateTime.now()
    val date = now.toLocalDate()
    val time = now.toLocalTime()

    println(now)
    println(date)
    println(time)
}

/*********************************************************************************************************************/

fun four077()
{
    val now = LocalDateTime.now()
    val today = LocalDate.now()
    val currentTime = LocalTime.now()

    println(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a").format(now))
    println(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm:ss").format(now))
    println(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(today))
    println(DateTimeFormatter.ofPattern("kk:mm:ss").format(currentTime))
}

/*********************************************************************************************************************/

fun five077()
{
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val todayStr = formatter.format(today)

    println(today)
    println(LocalDate.parse(todayStr, formatter))
}

/*********************************************************************************************************************/

fun tryParse(str: String) : LocalDate?
{
    val formatters = arrayOf(DateTimeFormatter.ofPattern("dd-MM-yyyy"), DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    for (formatter in formatters) {
        try {
            return LocalDate.parse(str, formatter)
        }
        catch (ignore: DateTimeParseException) {

        }
    }
    return null
}

fun six077()
{
    while (true) {
        val str = readString("Tarih bilgisini giriniz:21/06/2023 veya 21-06-2023 veya 2023-06-21:")

        if (str == "elma")
            break

        val result = tryParse(str)
        println(if (result != null) DateTimeFormatter.ISO_DATE.format(result) else "Geçersiz tarih!...")
    }
}
