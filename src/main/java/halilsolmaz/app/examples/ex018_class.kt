/*-----------------------------------------------------------------------------------------------------
    1.
    Sınıfın secondary ctor elemanı. Bir secondary ctor constructor anahtar sözcüğü ile bildirilir. Sınıfın secondary
    ctor'u overload edilebilir. primary ctor bir tanedir.

    2.
    Sınıfın primary ctor'u varsa tüm secondary ctor'ların doğrudan ya da dolaylı olarak bu ctor'u çağırıyor olmaları
    gerekir. Bu işlem :this ctor sentaksı ile yapılır.

    Not: Eğer secondary ctorlardan birisinin bile primary ctoru çağırması istenmiyorsa o zaman design yanlıştır ve
    tüm ctorlar secondary tanımlanmalıdır.

    3.
    Sınıfın secondary constructor'larının parametreleri property elemanı olamaz. Yani var veya val anahtar sözcükleri
    bu değişkenler için kullanılamaz.

    4.
    Secondary ctor'lar gövdesiz olabilir.

    5.
    default ctor primary ctor yapılabilir.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    val x = One018(3)
    val y = One018(3.2)

    println("---------------------------------------------------------------------")

    val a = Two018(5)
    println("-----------------------------------------------")
    val b = Two018(5.4)
    println("-----------------------------------------------")
    val c = Two018(5F)

    println("---------------------------------------------------------------------")
    val t = FourFive018()
    println("-----------------------------------------------")
    val u = FourFive018(5.2)
    println("-----------------------------------------------")
    val v = FourFive018(5)
    println("-----------------------------------------------")
    val f = FourFive018(4F)
}

class One018 {
    constructor(a: Int)
    {
        println("a = $a")
    }

    constructor(a: Double)
    {
        println("a = $a")
    }
}

class Two018(var x: Double) {
    init {
        println("i am core ctor and x = $x")
    }

    constructor(a: Int) : this(a.toFloat()) {
        println("i am secondary ctor with parameter int and a = $a")
    }

    constructor(a: Float) : this(a.toDouble()) {
        println("i am secondary ctor with parameter float and a = $a")
    }
}

class FourFive018() {
    init {
        println("primary constructor")
    }

    constructor(a: Double) : this()
    {
        println("constructor(Double)")
    }

    constructor(a: Int) : this(a.toDouble())
    {
        println("constructor(Int)")
    }

    constructor(a: Float) : this(a.toInt())
}