/*-----------------------------------------------------------------------------------------------------
    1.
    Temel ürlere ilişkin toChar metotları bulunmaktadır.

    2.
    Double ve Float sınıflarının toChar metotları Kotlin 1.5 ile birlikte deprecated olmuşlardır. Bu
    dönüşümün yapılması istendiğinde önce toInt metodu çağrılıp, sonra toChar metodu çağrılabilir

    3.
    İki Char toplama işlemine sokulamaz. Yani Char türünün Char türden parametreli toplama (plus)
    operatör fonksiyonu yoktur

    İki Char birbirinden çıkartılabilir. Bu durumda sonuç Int türden elde edilir. Bu bize iki karakterin karakter
    tablosundaki sıra numarası farkını verir. Şüphesiz yine bu işlem Char sınıfının Char parametreli minus operatör
    fonksiyonu ile yapılmaktadır

    Char türü ile Int türünün toplanması durumunda sonuç Char türden çıkar. Şüphesiz bu işlem Char sınıfının Int
    parametreli plus fonksiyonu ile yapılmaktadır

    Not: Int sınıfının Char parametreli plus fonksiyonu yoktur.

    Not2: Java da iki char'ın toplamı da farkı da int dönmektedir.

    4.
    Long türünden Int türüne dönüşüm toInt() ile yapılabilir. Java da ki gibi yüksek anlamlı byte'lar atılır.

    5.
    Byte sınıfının toChar metodu Kotlin 1.5 ile birlikte deprecated durumdadır. Bu metot yerine Int türüne
    dönüştürülüp toChar metodu çağrılmalıdır:
        a.toInt().toChar()

    6.
    Char sınıfının toInt metodu da deprecated olmuştur. Bunun Char türünün code property elemanı ile
    karaktere karşılık gelen sıra numarası Int türden elde edilebilir

    7.
    Gerçek sayı türlerinden Short ve Byte türlerine dönüştüren toShort ve toByte fonksiyonları kaldırılmıştır.
    Ayrıca gerçek sayı türlerinin toChar fonksiyonları da deprecated olmuştur.
    Bu anlamda bu 3 tür için toInt fonksiyonu çağrılarak Int türüne dönüştürme yapıp sonradan ilgili türlere
    dönüştürecek fonksiyonların çağrılması gerekir.
    Bu anlamda gerçek sayı türlerinden tamsayı türlerine dönüşüm ya Int türüne ya da Long türüne yapılabilmektedir.

 *  8.
    Gerçek sayı türünden tamsayı türüne dönüşüm aşağıdaki gibi gerçekleşir:
    1. Sayının noktadan sonraki kısmı atılır.
    2. Elde edilen sayı hedef türün sınırları içerisindeyse doğrudan atanır
       Elde edilen sayı hedef türün sınırları içerisinde değilse
       - Hedef tür Int türü ise sayının pozitif ve negatif olması durumuna göre Int türünün en büyük veya en küçük değeri
        alınır ve atanır
       - Hedef tür Long türü ise sayının pozitif veya negatif olma durumuna göre Long türünün en büyük ya da en küçük değer alınır.
       ve atanır
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
   /* oneTwo015()
    println("---------------------------------------------------------------------")
    three015()
    println("---------------------------------------------------------------------")
    four015()
    println("---------------------------------------------------------------------")
    fiveSix015()
    println("---------------------------------------------------------------------")
    seven015()
    println("---------------------------------------------------------------------")*/
    eight015()
}

fun oneTwo015()
{
    val a: Char = 67.toChar()

    // val b: Char = 67.2.toChar() // Kotlin 1.5 ile depracated olmuştur.
    val b: Char = 67.2.toInt().toChar() // Bu şekilde yapılabilir ancak anlamsız

    // val c: Char = 67.2F.toChar() // Kotlin 1.5 ile depracated olmuştur.
    val c: Char = 67.2F.toInt().toChar() // Bu şekilde yapılabilir ancak anlamsız
}

fun three015()
{
    val a = 'a'
    val c = 'c'

    // val ch = a + c // Error, ancak Java da  bu işlem geçerli ve  iki char türü toplamı int döndürür.

    val ch = a - c
    println(ch.javaClass.name) // Java da bu sonuç int döner.
    println(ch)

    val x = 10
    val y = 'y'

    println("---------------------------------------------------------------------")

    // Not: Int'e Char eklemek ile Char'a Int eklemek matematiksel olarak farklı anlamdadır.
    // val ch2 = x + y // Error, çünkü Int sınıfının Char parametreli plus fonksiyonu yoktur.
    val ch2 = y + x    // Doğru, çünkü Char sınıfının Int parametreli plus fonksiyonu vardır.

    println(ch2.javaClass.name) // Char sınıfının Int parametreli plus fonksiyonu Char döner.
    println(ch2)

    println("---------------------------------------------------------------------")
}

fun four015()
{
    print("Bir sayı giriniz:")
    val a = readln().toLong()
    val b: Int = a.toInt()

    println("a = %d".format(a))
    println("a = %016X".format(a))
    println("b = %d".format(b))
    println("b = %08X".format(b))
}

fun fiveSix015()
{
    while (true) {
        print("Bir sayı giriniz:")
        val a = readln().toByte()
        // val b: Char = a.toChar()      // deprecated oldu, çünkğ Kotlin manalı bir dönüşüm değil
        val b: Char = a.toInt().toChar() // ama dönüşüm yine de gerekliyse böyle yapılmalı.

        println("a = %d".format(a))
        println("a = %02X".format(a))
        println("b = %c".format(b))
        // println("b = %02X".format(b.toInt())) // depracated
        println("b = %02X".format(b.code.toShort()))

        // if (a == 0) // Error
        //    break

        if (a.toInt() == 0)
            break
    }
}

fun seven015()
{
    print("Bir sayı giriniz:")
    val a = readln().toDouble()
    // val b: Byte = a.toByte() //error
    val b: Byte = a.toInt().toByte()
    // var c: Short = a.toShort() //error
    val c: Short = a.toInt().toShort()

    val x = readln().toDouble()
    // val y: Char = x.toChar() //deprecated since Kotlin 1.5
    val y: Char = x.toInt().toChar()
}

fun eight015()
{
    val a: Double = 4_000_000_000.456
    /* a.toInt() yaparken önce .456 kısmı atılır ancak kalan sayı hala double'dır (Bu mantıklıdır çünkü
     * a sayısı Long sınırları dışında da olabilirdi). Bu yüzden  dönüşüm hala double'dan Int'dir.
     * Ancak 4_000_000_000.toInt() ifadesindeki dönüşüm Long'dan Int'e olduğu için sonuçlar farklıdır.
     */
    val b: Int = a.toInt()
    val c: Int = 4_000_000_000.toInt()
    val d: Int = Int.MAX_VALUE

    println("a = $a")
    println("b = $b")
    println("b = %08X".format(b))
    println("c = $c")
    println("c = %08X".format(c))
    println("d = $d")
    println("d = %08X".format(d))

    println("---------------------------------------------------------------------")

    val x: Double = -4_000_000_000.456
    val y: Int = x.toInt()
    val z: Int = (-4_000_000_000).toInt()
    val w: Int = Int.MIN_VALUE

    println("x = $x")
    println("y = $y")
    println("y = %08X".format(y))
    println("z = $z")
    println("z = %08X".format(z))
    println("w = $w")
    println("w = %08X".format(w))
}



