/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin de char türü tamsayı tutmasına rağmen yüksesk seviyeli bir dil olarak tasarlandığı için
    direkt int bir değer atanamaz.

    Not: Java da böyle bir kullanıma izin verilir.

    2.
    Kotlin de tek tırnak içerisinde özel karakterler dışında birden fazla karakter yazılamaz.

    3. Kotlin'de desteklenen "escape sequence" karakterlerine Java dan farklı olarak '\$' 'da dahildir

    4. Kotlin'de backtic '`'  karakteri ile bir anahtar sözcük tek başına değişken ismi yapılabilir. Şüphesiz çok kullanışlı
    değildir.

    Not: Kotlin ve Java birlikte kullanıldığında;
    - Kotlin de ki bir keyword java da keyword olmadığı için kullanılmış olabilir. Bu durum da eğer bu
    anahtar kelimeler tamamen yasaklı olsaydı Kotlin de bu isimler çağırılamazdı. Mesela Java da Sample
    sınıfının fun isimli bir metodu şöyle çağırılabilir: Sample.'fun'()

    5.
    İki tane iki tırnak karakteri arasında ters bölü tek başına kullanıldığında escape sequence karakter bekler

    6.
    $ karakterinin yazıda kullanımı

    7.
    Sabitlerin basamakları arasında alttire karakteri istenildiği kadar kullanılabilir.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    oneTwo()
    escapeCharacters()
    four()
    fiveSix()
    seven()
}

fun oneTwo()
{
    val ch1 = '$'
    val ch2 = '\u000A' // kesinlikle 2 byte olarak yazılmalı
    // val ch2: Char = 85 // error ama Java da geçerli
    // val ch3 =  'ab' // error
}
fun escapeCharacters()
{
    var ch1 = '\''
    var ch2 = '"'
    var ch3 = '\"'
    var ch4 = '\\'
    var ch5 = '$'
    var ch6 = '\$' // Java da desteklenmez
    var ch7 = '\t'
    var ch8 = '\n'
    var ch9 = '\r'
}

fun four()
{
    val `val` = 10
    val `if` = 20

    println(`val`)
    println(`if`)
}

fun fiveSix()
{
    println("C:\test\numbers.dat")
    println("***********")
    println("C:\\test\\numbers.dat")

    println("***********")
    println("10\$")
}

fun seven()
{
    val a = 4_000_000_000
    val a2 = 40_00_000_000
    val b = 1__________________0
    val c = 0b0100_1000__0001_1000
    val d = 1_0.0_5_6

    println("a = $a")
    println("a2 = $a2")
    println("b = $b")
    println("c = $c")
    println("d = $d")
}