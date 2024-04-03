/*-----------------------------------------------------------------------------------------------------
    1.
    Bazı sınıflar bir kavramın soyut halini temsil ederler. Tek başlarına nesne olmalarının anlamı yoktur. Ondan türeyen
    sınıfların anlamı vardır. Bu tarz sınıflar abstract olarak bildirilirler. Bu anlamda bu sınıfların bazı metotlarının
    kodlarının da yani gövdesinin olması anlamsızdır. Bu durumda metot abstract olarak bildirilir. abstract metotların
    gövdeleri olmaz ve sanal metotlardır. Bu durumda abstract sınıf bir sınıf gören programcı o sınıfın abstract
    metotlarının olabileceğini ve somut (concrete) bir sınıf türetmek için o abstract metotları da override etmesi
    gerektiğini anlar. Ya da abstract bir sınıftan türetilmiş abstract olmayan (concrete) bir sınıf gördüğünde taban
    sınıfının tüm abstract metotlarını override ettiğini anlar

    2.
    abstract sınıf türünden nesne programcı tarafından yaratılamaz. En az bir tane abstract metodu olan bir sınıf abstract
    olarak bildirilmelidir. abstract metotlar sanaldır.

    Not: Somut sınıflar nesne özelliği gösterirken, soyut sınıflar nesne özelliği göstermezler.

    Not: abstract sınıf türünden nesne dolaylı olarak yaratılabilir. Kendi başına abstarct sınıftan bir nesne zaten
    anlamsızdır. Ancak abstract bir sınıfdan türetilen abstarct olmayan bir sınıftan yaratılan bir nesne, taban
    sınıfıda barındırdığı için bu sınıftan bir nesne yaratılmış olur.

    3.
    abstract sınıfların abstract metotlarının gövdesi olmadığı için türeöiş sınıfta super anahtar sözcüğü
    ile çağrılması errordur.

    Not: Abstract sınıflar default olarak open'dır. abstarct yazıldığında artık open yazmanın bir gereği yoktur.

    4.
    Employee sınıfı ve sınıfın calculateInsurancePayment metodu abstract yapılmıştır.

    5.
    abstract sınıfların property elemanı olabilir, ctor elemanı olabilir.

    6.
    abstract bir bir sınıftan türeyen sınıf en az bir tane abstract metodu override etmezse o da
    abstract bildirilmelidir

    7.
    Kotlinde abstract property elemanları olabilir. Çünkü property elemanının VERİ ELEMANI OLMADIĞINI
    hatırlayınız. Değişken kılığına girmiş metotlardır.

    Not: Java da abstract veri elemanı olmaz.

    8.
    eight036'da CC sınıfı içerisindeki x property elemanı "readonly" olduğundan error oluşur. Örnekte abstract
    bir readonly property elemanı read-write olarak override edilmiştir

    Not: Taban sınıfta var olarak bildirilmiş bir property elemanı türemiş sınıfta val olarak bildirilemez.
    Taban sınıftaki property elemanı read-write anlamında yükseltilebilir, ancak düşürülemez
    Yani erişim olarak yükseltilebilir ama düşürülemez.


-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import kotlin.math.absoluteValue

fun main()
{
    println("-------------------------------oneToThree-----------------------------------")
    oneToThree036()
    println("-------------------------------five-----------------------------------")
    five036()
    println("-------------------------------seven-----------------------------------")
    seven036()
    println("-------------------------------eight-----------------------------------")
    eight036()
}

fun oneToThree036()
{
    // var a = A036() // Error
}

abstract class A036 {
    abstract fun foo()

}

class B036 : A036() {
    override fun foo()
    {
        println("B.foo")
       // super.foo() // Error
    }
}

fun five036()
{
    val c: C036 = D036("ankara", 6) //upcasting

    c.foo()

    println("**********************")

    val c2: D036 = D036("ankara", 6) //upcasting

    c2.foo()
}

class D036(str: String, x: Int, var y: Int = 0) : C036(str, x) {
    override fun foo()
    {
        println("D036.foo")
        println("y=$y")
        super.bar()
    }
}

abstract class C036(val str: String = "", value: Int = 0) {
    var x: Int = value

    abstract fun foo()

    fun bar()
    {
        println("x=$x, str=$str")
        println("C036.bar")
    }
}

fun seven036()
{
    val a: AA036 = BB036()

    a.x = -5

    println("a.x = ${a.x}")
}

class BB036 : AA036() {
    override var x: Int = 0
        set(value) {field = value.absoluteValue}
}

abstract class AA036 {
    abstract var x: Int
}

fun eight036()
{
    val c: CC036 = DD036()

    // c.x = -5 // Error, çünkü CC'de x read-only'dir

    println("c.x = ${c.x}")

    val d = DD036()

    d.x = 10;

    println("d.x = ${d.x}")
}


class DD036 : CC036() {
    override var x: Int = 0
        set(value) {field = value.absoluteValue}
}

abstract class CC036 {
    abstract val x: Int
}
