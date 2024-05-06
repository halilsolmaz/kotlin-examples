/*-----------------------------------------------------------------------------------------------------
    1.
    object bildirimleri bir sınıf içerisinde companion yapılabilir. Bu durumda object içerisindeki metotlara kapsayan
    sınıf ismi ile de erişilebilir.

    2.
    companion object bildirimlerinde object'e isim verilmeyebilir. (Genel de verilmez)

    companion object'e bir isim verilmediğinde o object'ib ismi Companion olarak verilmiş olur. Bu durumda sınıf
    dışından bu isme yani aslında o tek olan companşon object referansına Companion ismi ile erişilebilir.

    3.
    companion object içeren bir sınıf ismi doğrudan kullanıldığında Companion object referansı elde edilmiş olur.

    4.
    Bir sınıf içerisinde sadece tek bir companion object olabilir

    5.
    Bir sınıf içerisinde tek bir companion object fakat istenildiği kadar başka object'ler olabilir
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one-----------------------------------")
    one056()
    println("-------------------------------two-----------------------------------")
    two056()
    println("-------------------------------three-----------------------------------")
    three056()
    println("-------------------------------five-----------------------------------")
    five056()
}

fun one056()
{
    Sample056.foo() // Sample.Mample.foo() 'e karşılık gelir

    val s = Sample056()
    s.bar()
}

class Sample056 {
    fun bar()
    {
        println("bar")
    }
    companion object Mample { // Mample yazılmayabilirdi.(Bunu tercih edeceğiz)
        fun foo()
        {
            println("foo")
        }
    }
}

/*********************************************************************************************************************/

fun two056()
{
    val singleton = Mample056.Companion
    singleton.foo()
}

class Mample056 {
    companion object {
        fun foo()
        {
            println("foo")
        }
    }
}

/*********************************************************************************************************************/

fun three056()
{
    val singleton: Cample056.Companion = Cample056

    singleton.foo()
    //...
}
class Cample056 {
    companion object {
        fun foo()
        {
            println("foo")
        }
    }
}

/*********************************************************************************************************************/

fun five056()
{
    Dample056.foo() // Dample burada bir sınıf ismi değil, referanstır.
    Dample056.Mample.foo() // Dample burada sınıf ismi, Mample referanstır
    Dample056.Test.foo()
}

class Dample056 {
    companion object {
        fun foo()
        {
            println("Companion.foo")
        }
    }

    object Mample {
        fun foo()
        {
            println("Mample.foo")
        }
    }

    object Test {
        fun foo()
        {
            println("Test.foo")
        }
    }
}