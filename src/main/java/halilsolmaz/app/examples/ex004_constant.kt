/*-----------------------------------------------------------------------------------------------------
    Constants:

    1.)
    Sayı nokta içermiyorsa ve hiçbir sonek almamışsa Int veya Long türlerinden ilk olarak hangisinin
    sınırları içerisindeyse o türdendir. Sayı Long türü sınırları dışındaysa error oluşur.

    Not: Java da => long a = .. ; eğer .. yerine yazılan sayı int sınırlarını geçerse mutlaka sonuna L
    konulmalıdır ama kotlinde böyle bir durum söz konsu değildir.

    2.)
    Sayı nokta içermiyorsa ve L sonekini almışsa Long türdendir. Sayı Long türü sınırları dışındaysa
    error oluşur. Küçük harf L kullanılması geçersizdir

    3.)
    Kotlin'de bir sabitin sonunda D veya d soneki geçersizdir

    Not: Java da bu bu kullanıma izin verilir ve değişken Double türden sayılır

    4.)
    Sayı nokta içersin ya da içermesin F veya f sonekini almışsa Float türdendir

    5.)
    Sayı nokta içeriyorsa ve hiçbir sonek almamışsa Double türdendir

    6.)
    Kotlin'de nokta içeren bir sabitin noktadan önceki kısmı (tam kısmı) sıfır ise sıfır yazılmayabilir.
    Ancak noktadan sonraki kısmı (ondalık kısmı) sıfır ise noktadan sonra bir şey yazmamak geçersizdir.

  * Not1: Bunun nedeni val x = 3. dediğimizde aslında 3 bir sınıf nesnesi ve noktadan sonra bir class member
    beklenmektedir. Java da temel türler primitive type olduğu için böyle bir durum yaşanmaz.
    Not2: Java da ikiside geçerlidir
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    one()
    two()
    threeFourFive()
    six()
}

fun one()
{
    val x = 4000000000 //  java'da  x = 4000000000L
}

fun two()
{
    val x = 10L // Javada küçük l kullanılabilir ama önerilmez
    val y = 4000000000L
}

fun threeFourFive()
{
    // val x = 3D // error ancak Java da geçerli
    // val y = 3d // error ancak Java da geçerli

    var x = 4000000000F //Float
    var y = 3.4F // Float
    var z = 3F // Float

    var a = 3.4 // Double
}

fun six()
{
    val x = .3
    // val y = 3. // error
    val z = 3.toDouble()
}