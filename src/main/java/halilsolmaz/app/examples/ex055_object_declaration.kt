/*-----------------------------------------------------------------------------------------------------
    1.
    object bildirimleri bir sınıf içerisinde yapılabilir.

  * 2.
    Aşağıdaki örnekte ** ile belirtilen ifade için invoke metodu çağrılır. A(10) ifadesi ctordur.
    val A = A(10) ifadesin de A gölgelenmiştir. A artık A türünden bir referanstır. O yüzden alt satırda
    A(20) ifadesi invoke metodunu çağırır.

    Daha iyi anlamak için two055two() örneğini inceleyiniz.

  * 3.
    Aşağıdaki örnekte ** ile belirtilen ifade için yeni bir nesne yaratılmış olur. Çünkü A her ne kadar
    gölgelenmiş olsada invoke metodu olmadığı için nesne yaratılır.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one-----------------------------------")
    one055()
    println("-------------------------------two-one-----------------------------------")
    two055one()
    println("-------------------------------two-two-----------------------------------")
    two055two()
    println("-------------------------------three-----------------------------------")
    three055()
}

fun one055()
{
    Sample055.Mample.foo()
}

class Sample055 {
    object Mample {
        fun foo()
        {
            println("foo")
        }
    }
}

/*********************************************************************************************************************/

fun two055one()
{
    val A055 = A055(10)
    val s = A055(20) //**

    println(s)
}

fun two055two()
{
    val y = A055(10)
    val s = A055(20)
    val A055 = A055(30)
    val z = A055(40)
    val t = A055(50)

    println(s)
}

class A055(x: Int) {
    init {
        println("A.ctor, int")
    }

    operator fun invoke(x: Int) : Int
    {
        println("A.invoke")

        return x
    }
}

/*********************************************************************************************************************/

fun three055()
{
    val AA055 = AA055(10)
    val s = AA055(20) //**

    println(s)
}

class AA055(x: Int) {
    init {
        println("A.ctor, int")
    }
}
