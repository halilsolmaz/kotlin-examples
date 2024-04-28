/*-----------------------------------------------------------------------------------------------------
    1.
    object bildirimi (object declaration). object olarak bildirilmiş olan türe ilişkin bir tane nesne yaratılmış olur
    ve ismi o nesnenin referansı olarak kullanılır. Kullanım şekli itibariyla static elemanları varmış gibi erişilir.

    2.
    object bildirimleri başka bir sınıftan türetilebilir

    3.
    object bildirimleri

    4.
    Aşağıdaki örnekte nesne yaratılmamıştır. Fonksiyon çağırma operatör fonksiyonu çağrılmıştır. Dikkat edilirse
    s'nin türü Unit'dir

    5.
    Object bildirimleri (singleton) türetmeye kapalıdır Yani başka bir objectten türetilemez.

    object A
    object Singleton : A { //error
    ..
    }

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one-----------------------------------")
    one054()
    println("-------------------------------two-----------------------------------")
    two054()
    println("-------------------------------three-----------------------------------")
    three054()
    println("-------------------------------four-----------------------------------")
    four054()
}
fun one054()
{
    Singleton1.foo(23)
    Singleton1.bar()
}

object Singleton1 {
    private var mX : Int = 0

    fun foo(x: Int)
    {
        mX = x
    }

    fun bar()
    {
        println("mX = $mX")
    }
}

/*********************************************************************************************************************/

fun two054()
{
    Singleton2(23)
}

open class A054

object Singleton2 : A054() {
    operator fun invoke(b: Int)
    {
        println("b = $b")
    }

    fun foo(a: Int)
    {
        println("foo")
    }

    fun bar(b: Double)
    {
        println("bar")
    }
}

/*********************************************************************************************************************/

fun three054()
{
    val s = Singleton3
    s(23)

    Singleton3(23)
}

fun four054()
{
    val s = Singleton3(10) // Burada nesne yaratılmamıştır çünkü bu bir ctor çağrısı değildir.

    println(s.javaClass.name)
}

object Singleton3 : A() {
    operator fun invoke(b: Int)
    {
        println("b = $b")
    }

    fun foo(a: Int)
    {
        println("foo")
    }

}

