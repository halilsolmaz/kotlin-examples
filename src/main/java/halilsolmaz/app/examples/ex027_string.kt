/*-----------------------------------------------------------------------------------------------------
    1.
    String template kullanımı ve İki tırnak içerisinde escape sequence kullanımı

    2.
    """ ve """ arasındaki String'lere raw (regular) string denir. Bu string sabitlerinde escape sequence karakterler
    kullanılamaz. (What you see is what you get)

    3.
    İki tırnak arasında bulunan String sabitleri aynı satırda yazılmalıdır. Aksi durumda error oluşur.
    Bu problem raw string kullanılarak çözülebilir. Raw stringlerde tüm karakterler kendi anlamındadır.
    (WYSIWYG)

    4.
    Raw string'lerde iki tırnak karakteri tek başına kullanılabilir.
    Raw string'lerde tek tırnak karakteri tek başına kullanılabilir.

    5.
    Raw string içerisinde $ karakteri ile ifade yazımı (string template) yapılabilir.

    6.
    String sınıfının format metodu Java'daki format metoduna benzer.

        String sınıfının format metodu Java'daki format metoduna benzer:

    Bazı format karakterleri:
    d       -> decimal tamsayı türü
    x, X    -> hexadecimal tamsayı türü
    o       -> octal tamsayı türü
    c       -> Char
    f       -> Float veya Double
    s       -> String
    b       -> Boolean

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    one027()
    println("---------------------------------------------------------------------")
    two027()
    println("---------------------------------------------------------------------")
    three027()
    println("---------------------------------------------------------------------")
    four027()
    println("---------------------------------------------------------------------")
    five027()
    println("---------------------------------------------------------------------")
    six027()
}

fun one027()
{
    val fahrenheit: Double = 60.0
    val s = "Bugün hava ${5.0 / 9.0 * (fahrenheit - 32)} derece"
    println(s)

    println("****************")

    val s1 = "c:\\test\\numbers.txt"

    println(s1)
}

fun two027()
{
    val s = """c:\test\numbers.txt"""
    println(s)
}

fun three027()
{
    val s = """c:\test\numbers.txt
                ali"""

    println(s)
}

fun four027()
{
    val s = """"ankara"""
    println(s)

    println("****************")

    val s1 = """'ankara'"""
    println(s1)
}

fun five027()
{
    val a = 10
    val s = """a = $a"""

    println(s)
}

fun six027()
{
    val s = "Hello =>>> (%03d, %X %03f, %c, %b)".format(10, 15, 10.56, 'h', true)
    println(s)

    println("****************")

    val day = 11
    val mon = 7
    val year = 1983
    val hour = 12
    val minute = 9
    val second = 0

    println("%02d/%02d/%04d %02d:%02d:%02d".format(day, mon, year, hour, minute, second))
}