/*-----------------------------------------------------------------------------------------------------
    1.
    Exception işlemleri:
    Programın çalışma zamanı sırasında oluşan genel olarak hatalı durumlara exception denir. Aslında bir exception
    hata durumuna ilişkin olmayabilir. Bu durum nadiren karşımıza çıkar. Yani daha çok programın çalışma zamnında oluşan
    hatalı durumlara denir. Bu durumlara karşılık programcının kod içerisinde akışı belirlemesine "exception handling"
    denir. Kotlin'de Java'dan farklı olarak checked ve unchecked exception kavramları yoktur. Kotlin'de exception
    işlemleri şu anahtar sözcüklerle yapıolır:
        throw, try, catch, finally
    throw deyiminin genel biçimi aşağıdaki gibidir:
        throw <referans>
    Burada referans Throwable sınıfından doğrudan ya da dolaylı olarak türetilmiş bir sınıf türünden olmaldıır. Kotlin'de
    Throwable sınıfından Exception ve Error sınıfları türetilmiştir. Pratikte programclar Throwable sınıfından doğrudan
    türetme yapmazlar. Exception veya Error sınıfından doğrudan ya da dolaylı olarak türetme yaparlar. Error sınıfı
    ayrı bir throwable'dır. İleride ne için kullanıldığı ele alınacaktır. Java'da çok daha kritik öneme sahip olan
    RuntimeException isiml sınıftan da birçok sınıfı türetilmiştir. Throwable sınıfından doğrudan ya da dolaylı olarak
    türetilen sınıflara "exception classes" da denilmektedir.

    2.
    Bir kodun exception bakımından ele alınabilmesi için try bloğu içerisinde olması gerekir. try bloğunu bir veya
    birden fazla catch bloğu ile finally bloğu veya tek başına finally bloğu takip edebilir. Kotlin'de try hem deyim
    hem de ifsade biçiminde kullanılabilmektedir (try expression statment). Bir exceptiojn fırlatıldığında akış fırlatılan
    fonksiyondan bir daha geri dönmemek üzere (non-resumptive) çıkar. Akış bir try bloğu içerisinde o try bloğuna ilişkin
    catch bloklarına yukarıdan aşağıya sırasıyla kontrol eder. Uygun biri catch bloğu bulursa o catch bloğunu çalıştırır.
    Uygun catch bloğu, fırlatılan exception nesnesine ilişkin referansın atanabildiği (convert) türden catch parametresine
    sahip bloktur. Eğer hiç uygun blok bulamazsa, onu try bloğunu kapsayan try bloklarına ait catch bloklarına sırasıyla
    bakar, ilk bulduğu catch bloğunu çalıştırır. Diğer catch blokları çalıştırılmaz. Eğer hiç uygun catch bloğu bulunamazsa
    ve artık kapsayan hiç try bloğu kalmamışsa exception fırlatıldığı akış (thread) "abnormal" biri biçimde sonlanır. Akış
    try bloğundan nasıl çıkarsa çıksın finally bloğu çalıştıırılır. try bloğu hiç exception fırlatılmadan sonlanırsa tüm
    catch bloklarına atlanaran (varsa finally bloğu da çalıştırılarak) akış yoluna devam eder.

    3.
    consoleUtil içerisinde readInt, readLong... fonksiyonları try-catch ile NumberFormatException oluştuğunda
    tekrar kullanıcıdan input isteyecek şekilde güncellenmiştir.


-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readDouble
import halilsolmaz.app.util.console.kotlin.readInt

fun main()
{
    println("-------------------------------one-----------------------------------")
    one041()
    println("-------------------------------three-----------------------------------")
    three041()
}

fun one041()
{
    var a = 0.0; var b = 0.0

    while (true) {
        try {
            a = readDouble("Input the first number:", "Invalid Value!...")
            b = readDouble("Input the second number:", "Invalid value!...")

            println(divide041(a, b))
        }

        catch (ex: IllegalArgumentException) {
            println("Reason:${ex.message}")
        }
        if (a == 0.0)
            break
    }
}

fun divide041(a: Double, b: Double) : Double
{
    if (b == 0.0) {
        val msg = when (a) {
            0.0 -> "Undefined"
            else -> "Indeterminate"
        }

        throw IllegalArgumentException(msg)
    }

    return a / b
}

fun three041()
{
    var a = readInt("Birinci sayıyı giriniz:", "Hatalı giriş yaptınız:")
    var b = readInt("İkinci sayıyı giriniz:", "Hatalı giriş yaptınız:")

    println(a * b)

    println("----------------------")

    a = readInt("Birinci sayıyı giriniz:", "Hatalı giriş yaptınız:", "\nnumberone: ")
    b = readInt("İkinci sayıyı giriniz:", "Hatalı giriş yaptınız:", "\nnumbertwo: ")

    println(a * b)
}