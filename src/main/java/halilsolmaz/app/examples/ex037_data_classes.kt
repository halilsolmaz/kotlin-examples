/*-----------------------------------------------------------------------------------------------------
    1.
    Data classes (Veri Sınıfları)
    Bir sınıf data anahtar sözcüğü ile bildirildiğinde o sınıfın primary ctor elemanı olmak zorundadır.
    Bu ctor elemanında belirtilen parametreler ya val ya da var olarak bildirilmelidir.
    Yani data sınıflarının primary ctor elemanlarında property'ler bildirilmelidir.
    data sınıfları içerisinde bir takım metotlar otomatik olarak override edilmektedir. Örneğin toString metodu
    her bir property elemanı için toString metodunu çağırarak yazıyı oluşturur.

    2.
    data sınıfları için yazılan metotların geneli istenirse progamcı tarafından da yazılabilir. Bu durumda artık
    derleyici metodu yazmaz.

    3.
    data sınıflarının equals metodu da otomatik olarak override edilir.  Bu metot primary ctor ile belirtilen property
    elemanlarını karşılıklı olarak == operatörü ile karşılaştırır.

    4.
    three037 deki örnekte otomatik olarak yazılan equals metodu id, name ve ipAddress kontrolü yapmaktadır.
    Senaryomuzda biz sadece ip ve name'e göre bir kontrol yapmak istediğimizi farz edelim. Bunun için 2 farklı
    yol izleyebiliriz.

       - 1.) ipAdress property elemanı dışarıda bildirilerek yapılabilir.
            Not: Artık otomatik olarak yazılan diğer metotlarda da ipAdress kullanılamaz.
       - 2.) equals metodu override edilerek kontrol manuel yapılır.

    5.
    data sınıfları componentN fonksiyonlarına sahiptir. Bu fonksiyonlar bildirim sırasına göre primary ctor ile
    bildirilen property elemanlarına ilişkin değerleri döndürürler

    Not: ImmutableComplex sınıfı data class olarak güncellenmiştir.

    6.
    component fonksiyonlarına sahip olan sınıflar six037 de ki gibi parçalanabilir.

    7.
    component fonksiyonlarına sahip olan sınıflar for döngüsü ile de seven037 de ki gibi parçalanabilir.

    8.
    Parçalanabilen bir sınıf için sıra önemli olarak tüm parçalar alınmayabilir.
    Parçalama işleminde alınması istenmeyen ara parçalar için _ karakteri kullanılabilir.

    9.
    Programcı data sınıfları için primary ctor'da bildirmediği property elemanları için de componentN fonksiyonlarını
    yazabilir. Bu fonksiyonlar aslında operatör fonksiyonu olduğundan operator anahtar sözcüğü ile bildirilmelidir. Aksi
    durumda fonksiyon operatör fonksiyonu olmaz. Bu durumda parçalama yapılamaz.

    Not: ImmutableComplex sınıfına
        operator fun component3() = norm
        operator fun component4() = conjugate
    eklenmiştir.

    10.
    Example için bkz: quadraticEquationDemo

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.classes.ImmutableComplex
import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.random.Random

fun main()
{
    println("-------------------------------two-----------------------------------")
    two037()
    println("-------------------------------three-----------------------------------")
    three037()
    println("-------------------------------four-one-----------------------------------")
    fourOne037()
    println("-------------------------------four-two-----------------------------------")
    fourTwo037()
    println("-------------------------------five-----------------------------------")
    five037()
    println("-------------------------------six-----------------------------------")
    six037()
    println("-------------------------------seven-----------------------------------")
    seven037()
    println("-------------------------------eight-----------------------------------")
    eight037()
    println("-------------------------------nine-----------------------------------")
    nine037()
}

fun two037()
{
    val device1 = Device1(1, "test", "192.168.2.123")
    val device2 = Device2(1, "test", "192.168.2.123")
    val device3 = Device3(1, "test", "192.168.2.123")

    println(device1)
    println("*****************")
    println(device2)
    println("*****************")
    println(device3)
}

class Device1(val id: Int, var name: String, var ipAddress: String)
data class Device2(val id: Int, var name: String, var ipAddress: String)
data class Device3(var id: Int, var name: String, var ipAddress: String) {
    override fun toString() = "{id : $id, name: $name, ipAddress: $ipAddress}"
}

fun three037()
{
    val d1 = Device4(1, "test", "192.168.2.123")
    val d2 = Device4(1, "test", "192.168.2.123")

    println(if (d1 == d2) "Aynı cihaz" else "Farklı cihazlar")
    println(if (d1 != d2) "Farklı cihazlar" else "Aynı cihaz")
}

data class Device4(var id: Int, var name: String, var ipAddress: String)

fun fourOne037()
{
    val d1 = Device5(1, "test", "192.168.2.34")
    val d2 = Device5(1, "test", "192.168.2.35")

    println(if (d1 == d2) "Aynı cihaz" else "Farklı cihazlar")
    println(d1)
    println(d2)
}

data class Device5(var id: Int, var name: String) {
    var ipAddress: String = ""

    constructor(id: Int, name: String, ipAddress: String) : this(id, name)
    {
        this.ipAddress = ipAddress
    }

    // override fun toString() = "Device(id=$id, name=$name, ipAddress=$ipAddress)"
}

fun fourTwo037()
{
    val d1 = Device6(1, "test", "192.168.2.34")
    val d2 = Device6(1, "test", "192.168.2.35")

    println(if (d1 == d2) "Aynı cihaz" else "Farklı cihazlar")
    println(d1)
    println(d2)
}

data class Device6(var id: Int, var name: String, var ipAddress: String = "") {

    //override fun toString() = "Device(id=$id, name=$name)"
    override fun equals(other: Any?) = other is Device6 && id == other.id && name == other.name
    //...
}

fun five037()
{
    val z = ImmutableComplex(3.5, 4.8)

    val re = z.component4()
    val im = z.component2()

    println("$re + $im * i")
}

fun six037()
{
    val (re, im) = createRandomComplex(-10.0, 10.0)

    println("$re + $im * i")
}

fun createRandomComplex(min: Double, bound: Double, random: Random = Random) = ImmutableComplex(random.nextDouble(min, bound), random.nextDouble(min, bound))

fun seven037()
{
    val n = readInt("Input a number:")

    for ((re, im) in createRandomComplexNumbers(n, -10.0, 10.0))
        println("$re + $im * i")
}

fun createRandomComplexNumbers(count: Int, min: Double, bound: Double, random: Random = Random) = Array<ImmutableComplex>(count) { createRandomComplex(min, bound, random) }


fun eight037()
{
    val (id, name, surname) = createPerson("ali", 1)

    println("$name $surname, $id")

    val (id2, name2, _, address) = createPerson("veli", 2)

    println("$name2 $address, $id2")
}

data class Person(val id:Int, var name:String, var surname:String, var address: String)

fun createPerson(name: String, id:Int) = Person(id, name, "veli","mecidiyeköy")

fun nine037()
{
    val n = readInt("Input a number:")

    for ((re, im, _, conj) in createRandomComplexNumbers(n, -10.0, 10.0))
        println("$re + $im * i -> $conj")
}