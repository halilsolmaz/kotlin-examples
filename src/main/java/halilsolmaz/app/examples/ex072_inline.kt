/*-----------------------------------------------------------------------------------------------------
    1.
    inline fonksiyon çağrıları byte code'a çağrı biçiminde değil doğrudan kodlarıyla birlikte yazılır. inline fonksiyonlar
    eğer fonksiyon parametreli ise (high order function) dışarıdan almış olduğu callback fonksiyon da inline yapılmış
    olur.

    2.
    inline high order fonksiyonların callback olarak aldıkları fonksiyonların inline olmaması isteniyorsa
    parametre noinline olarak bildirilmelidir. Bu durumda ilgili callback fonksiyon inline olmaz, fonksiyon çağrısı
    byet code'a eklenir

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one--------------------------------")
    one072()
    println("-------------------------------two--------------------------------")
    two072()
}

/*********************************************************************************************************************/

fun one072()
{
    10.doWork {println(it)}
    "ankara".doWork{println(it.length)}
    3.4.doWork(::display072)
}

fun <T> display072(t: T) = println(t)

inline fun <T> T.doWork(callback: (T) -> Unit) = callback(this)

/*********************************************************************************************************************/

fun two072()
{
    "ankara".doWork({it.uppercase()}) {println(it); println(it.lowercase())}
}

inline fun <T> T.doWork(block: (T) -> T, noinline callback: (T) -> Unit) = callback(block(this))

/*********************************************************************************************************************/
