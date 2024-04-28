/*-----------------------------------------------------------------------------------------------------
    1.
    data sınıfları open olarak bildirilemez. Dolayısıyla türetmeye kapalıdır

    2.
    data sınıfı olamayan sınıflar için de componentN fonksiyonları yazılabilir. Bu durumda yine parçalama yapılabilir.

    3.
    data sınıflarının copy isimli metotları bulunur. copy metodu data sınıfının bir kopyasını çıkartır. copy metodu
    data sınıfı içersinde programcı tarafından yazılmaz.. copy metodu parametre olarak primary ctor'da bildirilen
    property elemanlarına ilişkin parametrelere sınıf property elemanlarını default argüman olarak geçecek şekilde yazılır.
    Örnek bir temsili sınıf:
    class Person(var id: Int, var name: String) {
        fun copy(id: Int = this.id, name: String = this.name) = Person(id, name)
        //...
    }

    Dikkat yukarıdaki temsili sınıf bir data sınıfı olmadığı için diğer metotlar yazılmaz.

    4.
    Circle sınıfı data sınıfı olmamasına rağmen elemanları anlamlı olduğunda componentN fonksiyonları yazılmıştır.
    Circle sınıfının copy metodu programcı tarafından yazılmıştır

    Circle sınıfını inceleyiniz.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.classes.Circle

fun main()
{
    println("-------------------------------two-----------------------------------")
    two038()
    println("-------------------------------three-----------------------------------")
    three038()
    println("-------------------------------four-----------------------------------")
    four038()
}

fun two038()
{
    val (id, name) = Person038(1, "ali")

    print("$id, $name")
}

class Person038(var id: Int, var name: String) {
    operator fun component1() = id
    operator fun component2() = name
    //...
}

fun three038()
{
    val p = Person038two(1, "ali")
    val pcopy = p.copy()

    println(p == pcopy)     //true
    println(p === pcopy)    //false
    println(pcopy)

    val pcopy2 = p.copy(name = "Veli")

    println(pcopy2)
}

data class Person038two(var id: Int, var name: String)

fun four038()
{
    val (r, a, c) = Circle(3.4)

    println("r = $r, area = $a, circumference = $c")

    println("*********************")

    val x = Circle(-5.2)
    val xc = x.copy()

    println(x)
    println(xc)
}