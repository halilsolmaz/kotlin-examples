/*-----------------------------------------------------------------------------------------------------
    Q: isPrime

    Ex: Int parametreli isPrimeV1 fonksiyonu senaryoya göre mantıklı olabilir ancak Long parametreli
    versiyonunda çok büyük sayılar için işlem çok uzun sürmektedir. Özellikle android gibi sistemlerde
    bu tercih edilmemektedir. (Yoruma alınan satırı inceleyeniz.)

    Bu durum da başka bir algoritma tercih edilebilir. Bu algoritma şu olabilir:
    Kural: Bir sayının asal olması için karekökünden daha küçük olan asal sayıların hiçbirisine bölünememesi gerekir.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks

fun main() = appHw001()

fun appHw001()
{
    println(if (isPrimeV1(1_000_003)) "Prime" else "Not Prime")

    println("---------------------------------------------------------------------")

    // println(if (isPrimeV1(710584055392819667)) "Prime" else "Not Prime")

    println(if (isPrimeV2(710584055392819667)) "Prime" else "Not Prime")

    println(if (isPrimeV2(17)) "Prime" else "Not Prime")
}

fun isPrimeV1(value: Int) : Boolean
{
    if (value <= 1)
        return false

    for (i in 2..value/2)
        if (value % i == 0)
            return false

    return true
}

fun isPrimeV1(value: Long) : Boolean
{
    if (value <= 1)
        return false

    for (i in 2..value/2)
        if (value % i == 0L)
            return false

    return true
}

fun isPrimeV2(value: Long) : Boolean
{
    if (value <= 1)
        return false

    if (value % 2 == 0L)
        return value == 2L

    if (value % 3 == 0L)
        return value == 3L

    if (value % 5 == 0L)
        return value == 5L

    if (value % 7 == 0L)
        return value == 7L

    // ..
    // Burada çok fazla olabilecek caseleri elemeye çalışıyoruz.
    // İhtiyaca göre burada daha fazla yazılabilir.

    var i = 11L
    while (i * i <= value) {
        if (value % i == 0L)
            return false
        i += 2
    }

    return true
}