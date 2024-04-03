/*-----------------------------------------------------------------------------------------------------
    1.
    Polymorphism (çok biçimlilik):
    Biyolojiden programlamaya aktarılmıştır. Biyoloji'de "polymorphism", farklı doku ya da organların evrim süreci
    içerisinde temel hedefleri aynı kalması koşuluyla o hedefe nasıl ulaşılacağının değişebilmesidir.

    Aslında polymorphism ikiye ayrılır: run time polymorphism, compile time polymorphism. Bu bölümde anlatılan ve
    Biyoloji'den gelen "runtime polymophism"'dir. Polymorphism dendiğinde "runtime polymorphism" anlaşılır.
    Compile time polymorphism Kotlin'de "generic"'ler ile gerçekleştirilir. Bu konu ileride ele alınacaktır

    Çok biçimliliğin programlama açısından 3(üç) tane tanımından bahsedilebilir:
    - 1. Biyolojik Tanım: Taban sınıfın bir fonksiyonunun türemiş sınıfta yeniden gerçekleştirilmesi (implementation)
    - 2. Yazılım Mühendisliği Tanımı: Türden bağımsız kod yazmak
    - 3. Aşağı Seviyeli Tanım: Önceden yazılmış kodların sonradan yazılmış kodları çağırabilmesi

    2.
    Çok biçimlilik sanal metotlar (virtual method) kullanılarak gerçekleştirilir.
    Kotlin'de bir metodun sanal olması için "open" anahtar sözcüğü ile bildirilmesi gerekir.
    Ayrıca türemiş sınıfta override edilen metot için de override anahtar sözcüğü kullanılmalıdır.
    "open" ile bildirilmiş sanal bir metodun türemiş sınıfta override edilmesi zorunlu değildir

    Anahtar Notlar: Java'da non-static olan, final olmayan veya abstract olarak bildirilmiş bir metot sanaldır.
    Kotlin'de ise bir metodun sanal olması programcı tarafından bildirilmelidir. private metotlar sanal olamazlar

    Not: Global fonksiyonlar sanal olamazlar

    3.
    Derleyici sanal bir metot çağrısı gördüğünde şu şekilde bir kod üretir:
    Derleme zamanında referansın dinamik türüne bak.
    Dinamik türe ilişkin sınıfta sanal metot override edilmişse onu çağır.
    Edilmemişse sırasıyla taban sınıfına ve dolaylı sınıflarına da bak ilk bulduğun metodu çağır.

    4.
    final override metot artık override işlemine kapatılmıştır

    Not: Bir base metodun override edilmemesi için open anahtar sözcüğünü kaldırmak yeterlidir.

 *  5.
    Yorumaa alınmış aşağıdaki örnek Kotlin'de geçersizdir. Ana sınıfta ki bit metod türetilmiş sınıfta
    yeni bir sanallık başlatamaz. Hatta final ile metod türetme kapatılsa bile yine de yeniden sanallık
    başlatılamaz.

    Not: C# 'de böyle bir özellik bulunmaktadır.

    6.
    print ve println metotlarının Any? parametreli overload'ları toString metodunu çağırırlar ve
    elde edilen yazıyı stdout'a basarlar.

    Any sınıfının toString metodu nesneye yönelik tekil bir yazıya döner. Bu yazının nasıl elde edildiğinin
    programcı açısından önemi yoktur.

    7.
    Not: ImmutableComplex ve Point sınıfına toString metodu eklenmiştir.

    8.
    Eğer taban sınıfın toString metodu çağırılmak isteniyorsa super anahtar kelimesi kullanılır.
    MutablePoint, Circle ve Analytic Circle sınıflarının toString metotlarını inceleyiniz.

    9.
    Any sınıfının equals metodu bir sınıf türünden nesnelerin eşitlik karşılaştırması için kullanılır. Bu durumda bu
    metot sınıfa özgü olarak override edilir. Bu metot aynı zamanda o sınıf referansların == ve != operatörleri ile
    kullanıldıklarında da çağrılır.

    Not: Point, Circle, AnalyticCircle sınıflarına equals operator override eklenmiştir.

    Not: Java da operator overloading olmadığı için == ve != operatörüyle referansların eşitlik karşılaştırılması
    yapılır. (İki refernas aynı nesneyi mi gösteriyor kontrolü yapılır.)
    Nesnelerin eşitlik karşılaştırılması (değer karşılaştırılması için) equals metodu kullanılır.

    10.
    Temel türlere ilişkin sınıfların (Short, Int, Long, Byte, Float, Double, Boolean, Char) toString ve
    equals metotları da override edilmiştir. toString metotları ilgili değerin yazı karşılığına geri döner.

    11.
    CompanyDemoApp örneğine polymorphism konusu ile birlikte yeni eklemeler yapılmıştır.

    Employee sınıfına calculateInsurancePayment metodu eklenmiş ve diğer türemiş sınıflar tarafından override
    edilmiştir.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.classes.AnalyticalCircle
import halilsolmaz.app.classes.ImmutableComplex
import halilsolmaz.app.classes.Point
import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.random.Random

fun main()
{
    println("-------------------------------three-----------------------------------")
    three035()
    //five
    println("-------------------------------six-----------------------------------")
    six035()
    println("-------------------------------seven-----------------------------------")
    seven035()
    println("-------------------------------eight-----------------------------------")
    eight035()
    println("-------------------------------nine-----------------------------------")
    nine035()
}

fun three035()
{
    val n = readInt("Input count:")

    for (i in 1..n) {
        val x: K1 = createRandomK()

        println("-----------------------------------------------------------")
        println(x.javaClass.name)
        x.foo()
        println("-----------------------------------------------------------")
    }
}

fun createRandomK(random: Random = Random) : K1
{
    return when(random.nextInt(4)) {
        0 -> K1()
        1 -> K2()
        2 -> K3()
        else -> K4()
    }
}

open class K4 : K3() {
    override fun foo() //override
    {
        println("K4.foo")
    }
}

open class K3 : K2() {

}

open class K2 : K1() {
    override fun foo() //override
    {
        println("K2.foo")
    }
}

open class K1 {
    open fun foo() //sanal metot (virtual method)
    {
        println("K1.foo")
    }
}



/* ************************************five*****************************************

open class L1 {
    open fun foo()
    {
        println("L1.foo")
    }
    //...
}

open class L2 : L1() {
    override fun foo()    //  "final override fun foo()" olsa bile yine de foo artık türetilemez.
    {
        println("L2.foo")
    }
}

open class L3 : L2() {
    open fun foo() //error
    {
        //...
    }
}

******************************************************************************* */

fun six035()
{
    val s1 = Sample035()
    val s2 = Sample035()

    println(s1)
    println(s2)

    println("**********************************")

    val s3 = Mample035()
    val s4 = Mample035()

    println(s3)
    println(s4)
}

class Sample035 {

}

class Mample035 {
    override fun toString() = "Mample035"
}

fun seven035()
{
    val p = Point(3.41, 4.55)
    val c = ImmutableComplex( 5.24, 6.28)

    println(p)
    println(c)
}

fun eight035()
{
    val ac = AnalyticalCircle(100.5, 8.54,20.42  )

    println(ac)
}

fun nine035()
{
    val p1 = Point(2.345, 5.678)
    val p2 = Point(2.345, 5.678)

    println(p1 == p2)
    println(p1 != p2)
}