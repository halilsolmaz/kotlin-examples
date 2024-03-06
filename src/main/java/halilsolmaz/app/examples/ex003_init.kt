/*-----------------------------------------------------------------------------------------------------
    Kotlinde temel türler sınıf olmalarına rağmen kategori olarak değer türleridir(Value Type).
    Yani referans değildirler ve içerisinde adres tutulmaz.
-----------------------------------------------------------------------------------------------------*/
package halilsolmaz.app.examples
fun main()
{
    var a = 10
    val b = a

    println("a = $a and b = $b")
    a = 45
    println("a = $a and b = $b")
}