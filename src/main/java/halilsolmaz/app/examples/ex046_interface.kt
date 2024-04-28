/*-----------------------------------------------------------------------------------------------------
    1.
    Aşağıdaki örnekte ** ile belirtilen çağrıda açısal parantez kullanılmalıdır. Çünkü taban arayüzler içerisinde çağrılan
    metot ile aynı olan metot bulunmaktadır.
    Anahtar Notlar: Java'da super referansı nesnenin taban sınıf kımının adresi anlamına gelir, desteklediği
    imterface'ler ile bir bağlantısı yoktur. Ancak Kotlin'de super aynı zamanda desteklediği
    interface'ler için de kullanılır. Zaten bu sebeple açısal parantez kullanımı da dile eklenmiştir

    2.
    one046'da IX046 ve IY046 interfacelerinde bar() metodu olmasaydı ** ile belirtilen çağrıda açısal parantez
    kullanılmasına gerek kalmayacaktı. Çünkü taban arayüzler içerisinde çağrılan metot ile aynı olan metot bulunmayacaktı.
    Ancak sentaks olarak açısal parantez kullanımı da geçerlidir.

    3.
    Aşağıdaki örnekte ** ile belirtilen çağrıda açısal parantez kullanılmalıdır. IX içerisindeki bar metodunun private
    olması bu durumu etkilemez.

    4.
    interface'lerin default metotları yani gövdesi olan metotları olabilir. Bu metotlar sanaldır ancak
    abstract değildir. Bu durum Java ve Kotlin için de geçerlidir
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one-----------------------------------")
    one046()
    println("-------------------------------three-----------------------------------")
    three046()
}

fun one046()
{
    val a = A046()

    a.bar()
}

class A046 : B046(), IX046, IY046 {
    override fun foo()
    {
        println("foo")
    }

    override fun bar()
    {
        println("bar")
        super<B046>.bar() //**
    }
}

open class B046 {
    open fun bar()
    {
        println("B046.bar")
    }
}

interface IX046 {
    fun foo()
    fun bar() //default metot
    {
        println("IX046.bar")
    }
}

interface IY046 {
    fun foo()
    fun bar() //default metot
    {
        println("IY046.bar")
    }
}

/*****************************************************************************************************************/

fun three046()
{
    val a = AA046()

    a.bar()
}

class AA046 : BB046(), IXX046, IYY046 {
    override fun foo()
    {
        println("foo")
    }

    override fun bar()
    {
        println("bar")
        super<BB046>.bar() //**
    }
}

open class BB046 {
    open fun bar()
    {
        println("BB046.bar")
    }
}

interface IXX046 {
    fun foo()

    private fun bar()
    {
        //...
    }
}

interface IYY046 {
    fun foo()
}