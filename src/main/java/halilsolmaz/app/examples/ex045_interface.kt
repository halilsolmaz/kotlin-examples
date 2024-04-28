/*-----------------------------------------------------------------------------------------------------
    1.
    Interface: Interface bildirimi yine bir tür bildirimidir (user defined type). interface
    nesne özelliği göstermez. interface içerisinde gövdesiz yazılan metotlar abstract olarak
    bildirilmiş olur. Bu anlamda interface'ler abstract sınıflara benzerler. Bir interface'den
    bir sınıf türetilmezi, bir sınıf bir interface'i destekler (implementation). Interface'ler
    ile "multiple inheritance" da belirli ölçüde desteklenmiş olur.

    2.
    interface bildirimi interface anahtar sözcüğü ile yapılır. interface ismini okunabilirlik açısından I ile
    başlatacağız. Kotlin'deki standart interface'lerde bu convention'a uyulmamıştır

    3.
    interface başına ve içerisinde ki gövdesiz fonksiyonların başına abstract yazılabilir ama gereksizdir.
    Çünkü zaten default olarak abstractır.

    4.
    Interfacelerin property elemanları olabilir ancak veri elemanı olamaz. (Hatırlanacağı üzere Classlar da
    bile veri elemanı kavramı yoktur onun yerine property elemanı kullanılır.)

    5.
    Bir sınıf birden fazla interface'i implemente etmişse farklı interface'lerdeki aynı metotlar için bir tane metot
    yazılması yeterlidir

    6.
    super<tür ismi> sentaksı ile taban türlere (sınıf, interface vb.) ilişkin istenilen default metot çağrılabilir

    Not: Java da bu özellik yoktur.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one-----------------------------------")
    one045()
    println("-------------------------------five-----------------------------------")
    five045()
    println("-------------------------------six-----------------------------------")
    six045()
}

fun one045()
{
    val a = A045()

    doWork045(a)
}

fun doWork045(ix: IX045)
{
    ix.foo()
    println(ix.value)
    ix.bar()
}

class A045 : IX045 {
    override fun foo()
    {
        println("foo")
    }

    override var value : Int = 10
}

interface IX045 {
    fun foo()

    fun bar()
    {
        println("bar")
    }

    var value: Int
}

/*******************************************************************************************************************/

fun five045()
{
    val a = AA045()
    val ix: IXX045 = a

    ix.foo()
    ix.bar()
    val iy: IYY045 = a

    iy.foo()
}

open class Sample045

class AA045 : Sample045(), IXX045, IYY045 {
    override fun foo()
    {
        println("foo")
    }

    override fun bar()
    {
        println("bar")
    }
}

interface IXX045 {
    fun foo()
    fun bar()
}

interface IYY045 {
    fun foo()
}

/*****************************************************************************************************************/
fun six045()
{
    val a = AAA045()

    a.bar()
}

class AAA045 : BBB045(), IXXX045, IYYY045 {
    override fun foo()
    {
        println("foo")
    }

    override fun bar()
    {
        println("A bar")
        super<BBB045>.bar()
        super<IXXX045>.bar()
        super<IYYY045>.bar()
    }
}

open class BBB045 {
    open fun bar()
    {
        println("B.bar")
    }
}

interface IXXX045 {
    fun foo()
    fun bar() //default metot
    {
        println("IX.bar")
    }
}

interface IYYY045 {
    fun foo()
    fun bar() //default metot
    {
        println("IY.bar")
    }
}