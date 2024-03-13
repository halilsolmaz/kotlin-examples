/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'de temel türlere ilişkin dönüşümler (explicit veya implicit) aslında operatör fonksiyonları ile
    yapılır. Burada basitleştirmek için işlem öncesi otomatik tür denüşümü diyeceğiz.

    İşlem öncesi otomatik tür dönüşümlerine ilişkin operatör fonksiyonları bulunmaktadır.

  * 2. Bazı durumlarda tür dönüştürme işlemi yapılmazsa bilgi kaybı oluşabilir.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    one016()
    println("---------------------------------------------------------------------")
    two016()
}

fun one016()
{
    val a: Int = 10
    val b: Long = 500
    val c = a + b // Int'in Long parametreli plus func çağrılır.
    val d = b + a // Long'un Int parametreli plus func çağrılır.

    println(c.javaClass.name)
    println(d.javaClass.name)

    println("c = $c")
    println("d = $d")
}

fun two016()
{
    val a:Int = 2_000_000_000
    val b:Int = 2_000_000_000

    val c = a + b
    println(c.javaClass.name)
    println("c = $c")

    val d = a.toLong() + b
    println(d.javaClass.name)
    println("d = $d")

}