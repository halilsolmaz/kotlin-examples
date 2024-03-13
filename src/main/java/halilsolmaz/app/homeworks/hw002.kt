/*-----------------------------------------------------------------------------------------------------
    Parametresi ile aldığı Int türden bir n sayısı için n-inci asal sayıyı döndüren getPrime isimli
    fonksiyonu yazınız. Fonksiyon n'nin pozitif olmayan değerleri için kontrol yapmayacaktır

    Not: Aşağıda GetPrime için iki adet fonksiyon yazılmıştır. Bura da hangisinin kullanılacağı
    sslında  isPrime fonksiyonuna ve ihtyaçlara bağlıdır diyebiliriz. Long parametreli isPrimeV2
    fonksiyonu zaten çift sayıları hızlıca elediği ve diğer bir çok kontrolü yaptığı için getPrimeV2
    fonksiyonunu kullanmak daha mantıklı olabilir. Tabi ki senaryoya bağlıdır.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks

fun main() = runGetPrimeTest()

fun runGetPrimeTest()
{
    while (true) {
        print("Bir sayı giriniz:")
        val n = readln().toInt()

        if (n <= 0)
            break

        println("${n}. asal sayı: ${getPrime(n)}")
    }

    while (true) {
        print("Bir sayı giriniz:")
        val n = readln().toInt()

        if (n <= 0)
            break

        println("${n}. asal sayı: ${getPrimeV2(n)}")
    }
}

fun getPrime(n: Int) : Long {
    var count = 2
    var value = 3L

    if (n == 1)
        value = 2L
    else if (n == 2)
        value = 3L
    else {
        while (count != n) {
            value += 2
            if (isPrimeV2(value))
                count++
        }
    }
    return value
}

fun getPrimeV2(n: Int) : Long
{
    var count = 0
    var value = 2L

    while (true) {
        if (isPrimeV2(value))
            ++count

        if (count == n)
            return value

        ++value
    }
}