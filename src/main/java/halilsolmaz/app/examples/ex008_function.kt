/*-----------------------------------------------------------------------------------------------------
    1.
    Bir fonksiyonun default argümanları olabilir.

    2.
    Bir fonksiyon çağrılırken isimli argümanlar verilebilir

    Not: Kullanımı çoğu zaman default argümanla anlamlıdır.

    3.) Method overloading durumunda "best match" e bakılır. (Bkz: voo())

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    foo(1, 2, 3)
    foo(b = 2, c = 3, a = 1)
    // foo(b = 2, a = 1, 3) // error
    foo(b = 2, a = 1, c = 3)
    foo( 1 , 2 , c = 3)

    println("-------------------------------------------------------------------------")

    // boo(2, 3) // error
    boo(c = 3, b = 2)

    println("-------------------------------------------------------------------------")

    yoo()
    yoo(1)

    println("-------------------------------------------------------------------------")

    voo(1)
    voo()
}
fun foo(a: Int , b: Int, c:Int)
{
    //...
}
fun boo(a: Int = 1 , b: Int, c:Int)
{
    //...
}
fun yoo(a: Int = sumNumbers(3, 5)) = println(a)
fun voo(a: Int = 1) = println("voo() with parameter and a = $a")
fun voo() = println("Non-parameter voo()")
