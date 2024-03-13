/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'de de "implicit ve explicit conversion" kuralları belirlidir. Ancak Kotlin'de genel olarak
    farklı türler birbirine doğrudan atanamaz.

    2.
    Kotlin'de genel olarak farklı türler birbirine doğrudan (implicit) atanamaz

    - Int türden  bir sabit Long türüne doğrudan atanabilir veya ilkdeğer olarak verilebilir.
    - Kotlin'de Java' da olduğu gibi Byte ve Short türden sabit yoktur ancak sınırlar içerisinde kalması koşuluyla Int
    türden bir sabit Byte veya Short türüne doğrudan atanabilir. (Not: Yukarıdaki istisna durum Java'da char türü
    için de vardır. Ancak Kotlin'de Char türü için bu durum geçersizdir)

    3.
    Temel türlere ilişkin sınıfların toXXX metotları ile birbirlerine dönüşümleri sağlanabilir. Ancak Kotlin 1.4 ile
    bazı metotlarda değişiklikler olmuştur. Bu durum ileride ele alınacaktır.

 *  4.
    Anımsanacağı gibi küçük tamsayı türünden büyük tamsayı türüne yapılan dönüşümde kaynak türe ilişkin değer pozitif
    ise sayının eklenen yüksek anlamlı byte değerlerine ilişkin bitler sıfır ile beslenir. Sayının işareti negatif ise
    işaretin kaybolmaması için sayının yüksek anlamlı byte değerlerine ilişkin bitler 1(bir) ile beslenir.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    two014()
    println("---------------------------------------------------------------------")
    three014()
    println("---------------------------------------------------------------------")
    four014()
}

fun two014()
{
    val a: Int = 10

    // var b: Long = a // Error, ancak Java da bu durum geçerli
    var b: Long = 10 // istisna kural

    var c: Byte = 10 // istisna kural
    // var c2: Byte = 10L // Error, Sabit Int türden olmalı
    // var c3: Byte = 40000 // Error, Sabit sınırlar içerisinde olmalı

    var d: Short = 10 // istisna kural
    // var d2: Short = 10L // Error, Sabit Int türden olmalı
    // var d3: Short = 40000 // Error, Sabit sınırlar içerisinde olmalı

    // var e: Char = 10 // Error, Ancak Java da bu istisna geçerli
}

fun three014()
{
    val a = 10
    val b : Long = a.toLong()

    println("b = $b")
}

fun four014()
{
    print("Short türden bir sayı giriniz:")
    val a = readln().toShort()
    val b = a.toInt()

    println("a = %d".format(a))
    println("a = 0x%04X".format(a))
    println("----------------------------------------------")
    println("b = %d".format(b))
    println("b = 0x%08X".format(b))

    print("Byte türden bir sayı giriniz:")
    val c = readln().toByte()
    val d = a.toInt()

    println("c = %d".format(c))
    println("c = 0x%02X".format(c))
    println("------------------------------------------")
    println("d = %d".format(d))
    println("d = 0x%08X".format(d))
}