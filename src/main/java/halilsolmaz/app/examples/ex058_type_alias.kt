/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'de bir türe eş isim (alias) verilebilmektedir. Bu işlem typealias anahtar sözcüğü ile yapılır. Genel olarak
    isimleri daha basit hale getirmek ve/veya isim çakışmalarını engellemek amaçlı kullanılmaktadır. Kotlin'de JavaSE ile
    aynı isimdeki bazı sınıflar kolay kullanım açısından typealias yapılmıştır.

    typealias StringArrayList = ArrayList<String>
    typealias IntArrayList = ArrayList<Int>
    typealias int = Int
    typealias double = Double
    typealias IntPairList = ArrayList<Pair<Int, Int>>
    typealias IntTripleList = ArrayList<Triple<Int, Int, Int>>
    typealias DoublePairList = ArrayList<Pair<Double, Double>>
    typealias DoubleTripleList = ArrayList<Triple<Double, Int, Double>>
    ..

    2.
    type alias yapıldığında iki tür birden de kullanılabilir. Yani Hem orijinal hem de alias ismi kullanılabilir.

    3.
    Aşağıdaki ilginç örnek geçerlidir

    4.
    typealias olarak bildirilmiş isimler yine import bildirimleri ile kullanılabilmektedir

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{

}

/*

typealias Int = String

fun one058()
{

    val b: Int = "ankara"
    // val c: Int = 5 // Error, Artık Int yazılan her yer String
    val d = 5 // Geçerli

    // foo(5) // Error
    foo("izmir")

    println(b)
}

fun foo(a: Int)
{
    println(a)
}

*/

/*******************************************************************************************************************/


/*

typealias int = Int
typealias Int = String

fun two058()
{
    var a: Int = "ankara"
    var b: Int = 10 // Error
    var c: int = 10 // Error
}

*/