/*-----------------------------------------------------------------------------------------------------
    Kotlin'de Java'dan farklı olarak temel türler class olarak bildirilmiştir. Dolayısıyla birbirlerine
    implicit atanamazlar.

    Not: Kotlinde temel türler class olmasına rağmen o türden değişken bir referans değildir (Bu kotlinde
    sadece temel türleri temsil eden classlar için geçerlidir).

    Not: val bildiriminin java karşılığı finaldır. Bir kez değer atanabilir ve değiştirilemez.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples
fun main()
{
    val a: Int = 5
    val b: Long
    // b = a // error
}