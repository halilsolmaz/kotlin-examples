/*-----------------------------------------------------------------------------------------------------
    1.
    Generics: Kotlin'de ve Java'da generics derleme zamanında çok biçimli kodlar yazmak için kullanılır. Bu anlamda
    derleme zamanında türden bağımsız kod yazılabilmektedir.

    Java ve Kotlin'de generic kavramı temelde aynı amaçta olsa da birçok farklılığı da buklunmaktadır.
    Burada Kotlin'de generic kavramı ele alınacaktır. Generic kavramı genel olarak generic türler ve generic fonksiyonlar
    olmak üzere iki gruba ayrılabilir.

    2.
    Aşağıdaki örnekte açılım (instantiation) yapılmadığı halde generic tür tespit edilebildiğinden (type inference/deduction)
    sorun oluşmaz.

    Not: Java da generic bir sınıf açılımsız kullanıldığın da Object türden bir sınıf olur ve tür korunu mu sağlanmamış olur.

    3.
    Generic sınıflar için nesne yaratılırken generic parametrelerin türleri tespit edilemezse açılım kesinlikle
    kullanılmalıdır. Aksi durumda error oluşur.

    4.
    Referans bildiriminde açılım kullanılmalıdır. Tür tespiti dışında generic sınıflar açısal parantezsiz
    kullanılamaz.

    Not: Bilindiği gibi Java' da generic bir sınıf açılımsız kullanıldığında generic parametre yerine
    Object geçmiş olur ki bu durum da Java'da tavsiye edilen bir kullanımm değildir

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one-----------------------------------")
    one049()
    println("-------------------------------two-three-----------------------------------")
    twoThree049()
    println("-------------------------------four-----------------------------------")
    four049()
}

class Sample<T>(var x: T)
fun one049()
{
    val s1 = Sample<Int>(10)
    val s2 = Sample<Double>(4.5)
    val s3 = Sample<String>("csd")

    println(s1.x)
    println(s2.x)
    println(s3.x)
}

fun twoThree049()
{
    val s1 = Sample(10)
    val s2 = Sample(4.5)

    // val s3 = Sample() // error

    println(s1.x)
    println(s2.x)
}

fun four049()
{
    // val s: Sample // Error

    val s: Sample<String>
    s = Sample("ankara")

    val s1: Sample<String> = Sample("izmir")

    println(s.x)
    println(s1.x)
}
