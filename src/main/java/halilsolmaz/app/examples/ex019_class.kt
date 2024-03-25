/*-----------------------------------------------------------------------------------------------------
    1.
    One019'da hem default hem de int/Int parametreli ctor Java/Kotlin arakodunda bulunacaktır.

    Not: Java da default değer atama yoktur.

    2.
    Two019 primary ctor'un parametresi için verilen default argüman artık kullanışsızdır. Çünkü best match den
    dolayı artık secondary ctor çağırılacaktır.

    3.
    primary ctor olmasa bile init bloğu yazılabilir. Bu durumda tüm ctor'ların başında bu blok çalıştırılır. Java'daki
    non-static initializer ile neredeyse aynı anlamdadır

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    val a = One019()
    println("************************")
    val b = One019(20)

    println("---------------------------------------------------------------------")

    val s = Two019()
    println("************************")
    val k = Two019(30)

    println("s.a = ${s.a}")
    println("k.a = ${k.a}")

    println("---------------------------------------------------------------------")

    var x = Three019()
    println("************************")
    var y = Three019(10)
}

class One019(a: Int = 10) {
    init {
        println("primary constructor: a = $a")
    }
}

class Two019(val a: Int = 10) {
    init {
        println("primary constructor: $a")
    }

    constructor() : this(20)
    {
        println("default constructor")
    }
}
class Three019 {
    init {
        println("init")
    }

    constructor()
    {
        println("default constructor")
    }

    constructor(a: Int)
    {
        println("Int constructor")
    }
}