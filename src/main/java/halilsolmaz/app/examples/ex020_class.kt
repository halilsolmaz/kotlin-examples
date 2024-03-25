/*-----------------------------------------------------------------------------------------------------
    1.
    One020'de iki anlamlılıktan dolayı ambiguity oluşur.

    2.
    Two020'de best match ile ilk foo() çağrılır.

    3.
    Three020'de float parametreli olan foo'ya default değer atanmadığı için best match yarışmasında
    Double kazanmıştır. Eğer float değerede default değer atansaydı ambiguity error oluşurdu.

    4.
    Four020'de Int, Float ve Long, Double parametreli foo metotları "uygun (applicable)" metotlardır. Çünkü
    metot çağrısında argüman olarak verilen Int türden ifade bir sabit olduğundan Long türüne de doğrudan (implicit)
    dönüşebilir.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    val x = One020()
    // x.foo() // Error, ambiguity

    println("---------------------------------------------------------------------")

    val y = Two020()
    y.foo()

    println("---------------------------------------------------------------------")

    val z = Three020()
    z.foo(10)

    println("---------------------------------------------------------------------")

    val t = Four020();
    val num = 10
    t.foo(num) //Bir sabit ifade olmadığı için tek applicable olan foo(Int, Float) dır. Çünkü Long'a Int atanamaz.
    println("************************")
    t.foo(10) // foo(Int, Float) ve foo(Long, Double) applicabledır ancak best match Int'li olandır.
}

class One020 {
    fun foo(a: Int = 0, b: Double = 0.0) = println("foo(Int, Double)")
    fun foo(a: One020 = One020(), b: Int = 0) = println("foo(One020, Int)")
}

class Two020 {
    fun foo(a: Int = 0) = println("foo(Int)")
    fun foo(a: Int = 0, b: Double = 0.0) = println("foo(Int, Double)")
    fun foo(a: One020 = One020(), b: Int = 0) = println("foo(One020, Int)")
}

class Three020 {
    fun foo(a: Int = 34, b: Float) = println("foo(Int, Float)")
    fun foo(a: Int = 0, b: Double = 4.5) = println("foo(Int, Double)")
    fun foo() = println("foo()")
}

class Four020 {
    fun foo(a: Int = 34, b: Float = 4.5F) = println("foo(Int, Float)")
    fun foo(a: Long = 0, b: Double = 4.5) = println("foo(Long, Double)")
    fun foo() = println("foo()")
}