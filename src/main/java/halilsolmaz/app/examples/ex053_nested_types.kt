/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin' de içiçe tür (nested types) bildirimi yapılabilmektedir. İçiçe sınıf bildirimi genel olarak 4(dört) şekilde
    yapılabilir:

    - Local classes
    - Nested classes
    - Inner classes
    - Anonymous classes

    2.
    - Local classes

    Kotlin'de yerel sınıflar bildirilebilir. Yerel fonksiyonların varlığından dolayı Kotlin'de yerel sınıfların
    kullanımına neredeyse gerek olmamaktadır.

    3.
    - Nested classes

    Nested sınıf türünden nesne sınıf dışında kapsayan sınıf ve nokta operatörü ile yaratılabilir

    Nested sınıf içerisinde kapsayan sınıf türünün private elemanlarına erişilebilir. Yani B sınıfı A sınıfının private
    elemanına erişebilir. Ancak A sınıfı B sınıfının private bölümüne erişemez. (Örneğe bakınız)

    4.
    - Inner classes

    Inner sınıf türünden bir nesne sınıf dışında kapsayan sınıf türünden referans ile yaratılabilir.

    Inner sınıf içerisinde kapsayan sınıf türünün private elemanlarına erişilebilir. Erişilen private elemanlar inner class
    nesnesinin yaratılmasında kullanılan kapsayan sınıf nesnesinin elemanlarıdır.

    four053three örneğin de inner sınıfın içerisinde recursive bir çağrı yapılmıştır(Yoruma alındı). "qualified this expression"
    ile inner sınıfın içerisinde kapsayan sınıfın foo metodu çağrılabilir.

    5.
    - Anonymous classes

    Anonim sınıflar object anahtar sözcüğü ile bildirilebilir. Anonim sınıf eğer bir interface ile klullanılırsa
    o interface'i destekleyen, bir sınıf ile kullanılırsa o sınıftan türetilmiş olan bir sınıf bildirimi yapmak
    aynı zamanda o sınıf türünden bir nesne yaratıp o nesnenin referansını elde etmek anlamındadır. Bildirilen
    sınıfa isim derleyici tarafından verilir.

    Anonim sınıflar tür belirtilmeden de kullanılabilir.

    Anonim sınıflar kendisinden önce bildirilen yerel değişkenleri ve parametre değişkenleri yakalayabilir (capture).
    five053three'de anonim sınıfın derleyici tarafından yazılışının yaklaşık karşılığı (closure):
       class halilsolmaz.app.examples.Ex053_nested_typesKt$five053three$ix$1(private var a: Int) : IX {
            override fun foo()
            {
                println("a = $a")
            }
        }

    6.
    Kotlin'de Java'dan farklı olarak yakalanan bir değişkenin değeri scope'u içerisinde değiştirilebilir.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readInt

fun main()
{
    println("-------------------------------two-----------------------------------")
    two053()
    println("-------------------------------three-----------------------------------")
    three053()
    println("-------------------------------four-one-----------------------------------")
    four053one()
    println("-------------------------------four-two-----------------------------------")
    four053two()
    println("-------------------------------four-three-----------------------------------")
    four053three()
    println("-------------------------------five-one-----------------------------------")
    five053one()
    println("-------------------------------five-two-----------------------------------")
    five053two()
    println("-------------------------------five-three-----------------------------------")
    five053three()
    println("-------------------------------six-----------------------------------")
    six053()
}

fun two053()
{
    val a = A053();

    a.foo(10)
}

class A053 {
    fun foo(value: Int)
    {
        class B {
            //..."
            fun bar()
            {
                println("bar")
            }
        }

        val b = B()

        b.bar()
    }
}

/*********************************************************************************************************************/

fun three053()
{
    // val a = AA053() // Error, çünkü ctor private
    val b = AA053.B()

    b.foo(20)
}

class AA053 private constructor()  {
    private var x = 10

    class B {
        fun foo(y: Int)
        {
            val a = AA053()

            println("a.x = ${a.x}")
            println("y = $y")
        }
    }
}

/*********************************************************************************************************************/

// Ancak A sınıfı B sınıfının private bölümüne erişemez.
// Aşağıdaki örnekte yorum satırlarını kaldırarak gözlemleyiniz.
class AAA053 {
    class B private constructor() {
        private var y = 10
        //...
    }

    fun bar()
    {
        // val b = B() //error

        // b.y = 20 //error
    }
}

/*********************************************************************************************************************/

fun four053one()
{
    val a = Ax053()
    val b = a.B()

    b.foo(20)
}

class Ax053 {
    private val x = 10

    inner class B {
        fun foo(y: Int)
        {
            println("y=$y")
        }
    }
}

/*********************************************************************************************************************/

fun four053two()
{
    val a = Axx053(10)
    val b = a.B()

    val a1 = Axx053(20)
    val b1 = a1.B()

    b.foo(40)
    b1.foo(30)
}

class Axx053 (x: Int){
    private var x = x

    inner class B {
        fun foo(y: Int)
        {
            println("x = $x")
            println("y = $y")
        }
    }
}

/*********************************************************************************************************************/

fun four053three()
{
    val b = Axxx053().B()

    b.foo(20)
}

class Axxx053 {
    fun foo(x: Int)
    {
        println("A.foo")
    }

    inner class B {
        fun foo(x: Int)
        {
            println("B.foo")
            // foo(x) // Dikkat recursive çağrı ve stack dolarak Error oluşur.
            // this.foo(x) // Yukarıdaki çağrıyla aynı anlamda
            this@Axxx053.foo(x)
        }
    }
}

/*********************************************************************************************************************/

interface IX {
    fun foo()
}

fun five053one()
{
    val ix = object: IX {
        override fun foo()
        {
            println("foo")
        }
    }

    println(ix.javaClass.name)
    ix.foo()
}

fun five053two()
{
    val a = object {
        var x = 10
        var y = 3.4
        //...
    }

    println(a.javaClass.name)
    println(a.x)
    println(a.y)
}

fun five053three()
{
    val a = readInt("Bir sayı giriniz:")

    val ix = object: IX {
        override fun foo()
        {
            println("a = $a")
        }
    }
    println(ix.javaClass.name)

    ix.foo()
}

fun six053()
{
    var a = readInt("Bir sayı giriniz:")

    val ix = object: IX {
        override fun foo()
        {
            println("a = $a")
        }
    }
    ++a
    ix.foo()
    ix.foo()

}

