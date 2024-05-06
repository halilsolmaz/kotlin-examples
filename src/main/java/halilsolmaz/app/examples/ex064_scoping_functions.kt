/*-----------------------------------------------------------------------------------------------------
    1.
    Scoping functions:
    LET us ALSO RUN WITH APPLY

    2.
    apply eklenti fonksiyonu: apply eklenti fonksiyonunun callback'ine this geçirilir
    "apply the following assignments or calls to the object"
    apply fonksiyonu çağrıldığı referansa geri döner

    - two
    Yukarıdaki örnekte işlemler ayrı bir func'ta tanımlayıp apply ile çağırılabilir.

    3.
    let eklenti fonksiyonu bir türün başka bir türe dönüştürülmesi için kullanılabilir. let fonksiyonunun
    callback'ine this geçirilmez.

    let fonksiyonunun kullanımı ile ilgili örnekler aşağıdadır.

    4.
    with global fonksiyonu. Bu fonksiyon en son çalıştırılan ifadenin ürettiği değere geri döner
    "with this object do the following"

    5.
    also eklenti fonksiyonu. Bu fonksiyon da çağrıldığı referansa geri döner. Bu fonksiyonun callback olarak
    aldığı fonksiyonun parametresi ilgili türdendir. apply fonksiyonunda ise parametresizdir. also fonksiyonun calback'ine
    this geçirilmez
    "also do the followings for that object"

    Not:Bu örnek let ile de yapılmıştır. Ancak okunabilirlik açısından also daha uygundur.

    6.
    run eklenti fonksiyonu ile bir türe ilişkin bir takım işlemler yapılabilir. run fonksiyonu en son yapılan
    işlemin değerini döndürür. run fonksiyonunun callback'ine this geçirilir.

    - two
    run global bir fonksiyondur


-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.console.kotlin.readString
import halilsolmaz.app.util.number.countDigits
import kotlin.random.Random

fun main()
{
    println("-------------------------------two-one--------------------------------")
    two064one()
    println("-------------------------------two-two--------------------------------")
    two064two()
    println("-------------------------------three-one------------------------------")
    three064one()
    println("-------------------------------three-two------------------------------")
    three064two()
    println("-------------------------------four-----------------------------------")
    four064()
    println("-------------------------------five-----------------------------------")
    five064()
    println("-------------------------------six-one--------------------------------")
    six064one()
    println("-------------------------------six-two--------------------------------")
    six064two()
}

class Sample064 {
    var a: Int = 0
    fun foo()
    {
        println("foo")
    }

    fun bar()
    {
        println("bar")
    }

    fun tar() : Int
    {
        println("tar")
        return  10;
    }

    override fun toString() = "Sample"
}

fun two064one()
{
    var x: Int

    val s = Sample064().apply {
        a = readInt("Bir sayı giriniz:")
        this.foo()
        bar()
        println("Merhaba")
        x = tar()
    }

    println("s.a = ${s.a}")
    println("x = $x")
    println(s)
}

/*********************************************************************************************************************/

fun Sample064.applySampleCallback()
{
    a = readInt("Bir sayı giriniz:")
    this.foo()
    this.bar()
    println("Merhaba")
}

fun two064two()
{
    var x: Int

    val s = Sample064().apply{this.applySampleCallback(); x = tar()}

    println("s.a = ${s.a}")
    println("x = $x")
    println(s)
}

/*********************************************************************************************************************/

fun three064one()
{
    while (true) {
        val s = readString("Bir yazı giriniz:")

        if ("elma" == s)
            break

        val newS = s.let { "text: $it" }

        println(newS)
    }
}

/*********************************************************************************************************************/

data class Persons(val citizenID: String, var name: String, var address: String)
data class PersonViewModel(var name: String, var address: String)

fun three064two()
{
    val p = Persons("1234", "Lokman", "Mecidiyeköy")

    val pvm = p.let {
        val name = p.name.uppercase()

        //...
        PersonViewModel(name, p.address)
    }

    println(pvm)
}

/*********************************************************************************************************************/

fun personToPersonViewModel(p: Persons) = PersonViewModel(p.name.uppercase(), p.address)

fun three064three()
{
    val p = Persons("1234", "Lokman", "Mecidiyeköy")
    val pvm = p.let(::personToPersonViewModel)

    println(pvm)
}

/*********************************************************************************************************************/

fun three064four()
{
    val p = Persons("1234", "Lokman", "Mecidiyeköy")
    val pvm = p.let {personToPersonViewModel(p)}

    println(pvm)
}

/*********************************************************************************************************************/

fun four064()
{
    val s = Sample064()

    val x = with(s) {
        val a = Random.nextInt(100)

        println("a = $a")
        foo()
        bar()
        tar()
    }

    println("x = $x")
}

/*********************************************************************************************************************/

fun five064()
{
    val a: Int = readInt("Bir sayı giriniz:")

    //...

    val str = a
        .also { println("Number of digits:${it.countDigits()}") }
        .toString()

    println(str)

    println("***************************************************")

    val a2: Int = readInt("Bir sayı giriniz:")

    //...

    val str2 = a2.let { println("Number of digits:${it.countDigits()}"); "$it" }

    println(str2)
}

/*********************************************************************************************************************/

fun six064one()
{
    val a = readInt("Bir sayı giriniz:")

    val result: Int = a.run {
        val x = readInt("Çarpanı giriniz:")

        this * x
    }

    println(result)
}

/*********************************************************************************************************************/

fun six064two()
{
    val a: Int = readInt("Bir sayı giriniz:")

    val result: Int = run {
        val x = readInt("Çarpanı giriniz:")

        a * x
    }

    println(result)
}
