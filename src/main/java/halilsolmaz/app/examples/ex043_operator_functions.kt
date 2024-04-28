/*-----------------------------------------------------------------------------------------------------
    1.
    Operatör Fonksiyonları:
    Anımsanacağı gibi Kotlin'de hemen hemen tüm operatörler bir fonksiyona karşılık gelir. Temel türlere ilişkin
    çeşitli operatör fonksiyonlar tanımlanmıştır. Programcı bildirdiği bir sınıf için de anlamlı olan operatörlere
    ilişkin fonksiyonları yazabilir. Örneğin Strşng sınıfının + operatörüne ilişkin plus fonksiyonları ile
    "string concat" yapılabilmektedir. Yine benzer şekilde equals fonksiyonu override edildiği için Strinbg'lerin
    özdeşlik karşılaştırması == ve != operatörleri ile yapılabilmektedir. Hatta bu anlamda Java'da yazılmış olan ve
    equals metodunu override eden sınıflar türünden nesnelerin mantıksal eşitlik karşılıkları == ve != operatörleri
    ile yapılabilmektedir.

    Programcı yazdığı sınıfa operatör fonksiyonlarını anlamsız olacak şekilde eklememelidir. Örneğin bir tarih işlemi
    yapan sınıf yazıldığında iki tarihin toplanması anlamsızdır ancak birbirinden çıkartılması anlamlıdır. Bu durumda
    programcı bu sınıf için minus operatör fonksiyonuu yazar ancak plus operatör fonksiyonunu yazmaz.

    2.
    MutableComplex sınıfına plus, minus, unaryplus ve unaryminus operator fonksıyonları eklenmıstır.
    Double sınıfına complex parametreli plus ve minus extension fonksiyonları eklenmiştir.

    3.
    ++ (inc) ve --(dec) operatör fonksiyonları yazılırken nesne için artırma/azaltma yapılmamalıdır. Artırılmış/azaltılmış
    yeni bir nesnenin referansına dönülmelidir. Derleyici uygun kodları üreterek bu operatörlerin prefix ve postfix olarak
    doğru kullanılmalarını sağlar.

    MutableComplex sınıfına inc ve dec operator funcs eklenmiştir.
    Not: Aynı nesneyi ve farklı nesneyi dönüp test ediniz ? ? ?

    4.
    Anımsanacağı gibi data sınıflarının equals operatör fonksiyonu primary ctor'da bildirilmiş karşılıklı property elemanları
    için == operatörü ile karşılaştırma yapacak şekilde override edilmiştir.

    5.
    Aşağıdaki örnekte MutableComplex sınıfında olmayan (anlamlı da olmayan) karşılaştırma operatörlerine ilişkin
    compareTo fonksiyonu extension olarak "müşteri kod (client code)" tarafından yazılmıştır

    6.
    Kotlin'de fonksiyon çağırma operatör fonksiyonu overload edilebilir. Bu durumda ilgili sınıf türünden referans
    ismi fonksiyon ismi gibi kullanılabilir. Bu operatör fonksiyonunun ismi invoke'dur. Fonksiyon çağırma operatör
    fonksiyonu overload edilmiş sınıflara programlamada "functor/function object" de denilmektedir. Bu operatör
    fonksiyonu bazı durumlarda callback/callable alan fonksiyonlarda (high order functions (HOF)) kullanılabilmektedir.
    HOF'lar ileride ele alınacaktır.

    7.
    !(not) operatörü overload edilebilir.

    8.
    Sınıfın get ve/veya set operatör fonksiyonları overload edildiğinde o sınıf türünden
    bir referans [] operatörü ile de kullanılabilir. Bu tarz kullanıma ilişkin fonksiyonlara
    bazı kaynaklar "indexer" da denmektedir. Bu terim Kotlin'e özgü değildir.

    Not: MutableComplex sınıfına get ve set metotları eklenmiştir.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.classes.MutableComplex
import halilsolmaz.app.classes.plus
import halilsolmaz.app.classes.random.nextMutableComplex
import kotlin.math.abs
import kotlin.random.Random

fun main()
{
    println("-------------------------------two-ex1----------------------------------")
    two043ex1()
    println("-------------------------------two-ex2----------------------------------")
    two043ex2()
    println("-------------------------------two-ex3----------------------------------")
    two043ex3()
    println("-------------------------------two-ex4----------------------------------")
    two043ex4()
    println("-------------------------------three-ex1----------------------------------")
    three043ex1()
    println("-------------------------------three-ex2----------------------------------")
    three043ex2()
    println("-------------------------------three-ex3----------------------------------")
    three043ex3()
    println("-------------------------------three-ex4----------------------------------")
    three043ex4()
    println("-------------------------------four----------------------------------")
    four043()
    println("-------------------------------five----------------------------------")
    five043()
    println("-------------------------------six----------------------------------")
    six043()
    println("-------------------------------seven----------------------------------")
    seven043()
    println("-------------------------------eight----------------------------------")
    eight043()
}

fun two043ex1()
{
    val z1 = Random.nextMutableComplex(-10, 10)
    val z2 = Random.nextMutableComplex(-10, 10)
    val z = z1 + z2

    println(z1)
    println(z2)
    println(z)
}

fun two043ex2()
{
    val z1 = Random.nextMutableComplex(-10, 10)
    val value = Random.nextDouble(10.0)
    val z = z1 + value

    println(z1)
    println("value = $value")
    println(z)
}

fun two043ex3()
{
    val z1 = Random.nextMutableComplex(-10, 10)
    val value = Random.nextDouble(10.0)
    val z = value + z1

    println(z1)
    println("value = $value")
    println(z)
}

fun two043ex4()
{
    val z = Random.nextMutableComplex(-10, 10)
    val result = -z

    println(z)
    println(result)
}

fun three043ex1()
{
    var z = Random.nextMutableComplex(-10, 10)

    println(z)
    val result = z++

    println(z)
    println(result)
}

fun three043ex2()
{
    var z = Random.nextMutableComplex(-10, 10)

    println(z)
    val result = ++z

    println(z)
    println(result)
}

fun three043ex3()
{
    var z = Random.nextMutableComplex(-10, 10)

    println(z)
    val result = z--

    println(z)
    println(result)
}

fun three043ex4()
{
    var z = Random.nextMutableComplex(-10, 10)

    println(z)
    val result = --z

    println(z)
    println(result)

}

fun four043()
{
    val z1 = MutableComplex(3.0, 4.0)
    val z2 = MutableComplex(3.0, 4.0)

    println(if (z1 == z2) "Aynı sayı" else "Farklı sayılar")
    println(if (z1 != z2) "Farklı sayılar" else "Aynı sayı")
}

/**************************************************************************************************/

const val delta = 0.00001

operator fun MutableComplex.compareTo(other: MutableComplex) : Int
{
    val diff = norm - other.norm

    return when {
        abs(diff) < delta -> 0
        diff > 0 -> 1
        else -> -1
    }
}

fun five043()
{
    val z1 = MutableComplex(3.0, 4.0)
    val z2 = MutableComplex(3.0, 4.0)

    println(z1 <= z2)
    println(z1 < z2)
    println(z1 >= z2)
    println(z1 > z2)
}

/**************************************************************************************************/

operator fun MutableComplex.invoke() = println(this)
fun six043()
{
    val z = Random.nextMutableComplex(-10, 10)

    z()
    println(z(2.3, 4.5))
    z()
    println(z(8.9))
    z()
}

/**************************************************************************************************/

operator fun MutableComplex.not() = this.conjugate

fun seven043()
{
    val z = Random.nextMutableComplex(-10, 10)

    println(z)
    println(!z)
}

fun eight043()
{
    val z = Random.nextMutableComplex(-10, 10)

    println(z)
    ++z[0]
    println("${z[0]}")
    println(z)
    --z[1]
    println("${z[1]}")
    println(z)
}
