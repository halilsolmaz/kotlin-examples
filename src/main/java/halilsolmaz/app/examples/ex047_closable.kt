/*-----------------------------------------------------------------------------------------------------
    1.
    Kullanılabilmesi için mantıksal olarak açılması (open) gereken ve kullanım sonunda mantıksal
    olarak kapatılması gereken bir kaynağın (resource) bir sınıf tarafından kullanılnası durumunda
    bu sınıf bir convention olarak Closeable arayüzünü destekler. Başka bir deyişle Closeable
    arayüzünü destekleyen bir sınıf için böylesi bir kullanum söz konusudur algılanır.

    2.
    Closeable arayüzünün close isimli bir metodu bulunur. Yani kaynağı kullanan sınıfta bu arayüzün close
    metodunu kaynağın kullanımını serbest bırakacak şekilde override edilir. Bunu kullanan programcı da
    close çağırması gerektiğini bilir ve çağırır.

    Kotlin'de Closeable arayüzünü destekleyen sınıfların use isimli extension fonksiyonları vardır.
    Bu fonksiyon başka bir fonksiyonu callback olarak alır.

    Callback kavramı ileride detaylandırılacağından ilgili konuya gelene kadar use kullamını bir kalıp
    biçiminde düşüneceğiz. use fonksiyonu çağrısı bitikten sonra o sınıf için close fonksiyonu
    otomatik olarak çağrılır. Bu durumda programcının ayrıca close çağırması gerekmez.

    3.
    use extension fonksiyonu;
    Bu, aslında Java'daki try-with-resources deyiminin Kotlin'deki karşılığıdır. Aşağıdaki
    kodun Java karşılığı:

    try (Sample s = new Sample()) {
        s.foo(-10);
    }

    4.
    Aşağıdaki örnekte exception oluşsa bile (exception yakalanamayacak) close çağrılır.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import java.io.Closeable
import kotlin.random.Random

fun main()
{
    println("-------------------------------three-----------------------------------")
    three047()
    println("-------------------------------four-----------------------------------")
    four047()
}

fun three047()
{
    val s = Sample047()

    try {
        s.use {
            s.foo(Random.nextInt(-10, 10)) // pos ve neg değerler için çalıştır.
        }
    }
    catch (ex: IllegalArgumentException) {
        println(ex.message)
    }
}

class Sample047 : Closeable {
    fun foo(a: Int) {
        if (a < 0)
            throw IllegalArgumentException("a must be positive")

        println("foo")
    }
    override fun close()
    {
        println("close")
    }
}

fun four047()
{
    val s = Sample047()

    s.use {
        s.foo(-5)
    }
}