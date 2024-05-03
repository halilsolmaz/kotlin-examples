/*-----------------------------------------------------------------------------------------------------
    1.
    Aşağıdaki örnekte add değişkeninin türü belirtilmelidir. Çünkü derleyici Lambda fonksiyon içerisinde
    a ve b değişkenleri için tür tespiti (type inference/deduction) yapamaz.

    2.
    Tek parametreli Lambda fonksiyonlarda "it" built-in olarak parametre ismi olarak kullanılabilir.

    3.
    Lambda fonksiyonlar

    4.
    Aşağıdaki kodda bir fonksiyon sabiti bildirilmiş ve fonksiyon çağırma operatör fonksiyonu uygulanmıştır
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one-----------------------------------")
    one060()
    println("-------------------------------two-----------------------------------")
    two060()
    println("-------------------------------three-----------------------------------")
    three060()
    println("-------------------------------four-----------------------------------")
    four060()
}

fun one060()
{
    val add: (Int, Int) -> Int  = {a, b -> a + b }
    val add2 = {a: Int, b: Int -> a + b }


    println(add(10, 20))
    println(add2(10, 20))
}

fun two060()
{
    val f: (Int) -> Int = {it * it}
    val f2 : (String) -> String = {it.uppercase()}

    println(f(10))
    println(f2("ankara"))
}

fun three060()
{
    val f1 : (String, String) -> String = {s1, s2  -> "$s1 $s2"}
    val f2 : (String) -> String = {
        println("Yazı:$it")
        it.uppercase()
    }
    val f3 : (String) -> String = {s ->
        println("Yazı:$s")
        s.toUpperCase()
    }

    println(f1("ankara", "istanbul"))
    println(f2("ankara"))
    println(f3("ankara"))
}

fun four060()
{
    { println("Merhaba") }()
}
