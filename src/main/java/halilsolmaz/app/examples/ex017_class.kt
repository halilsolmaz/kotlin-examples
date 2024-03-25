/*-----------------------------------------------------------------------------------------------------
    1.
    Sınıf bildiriminde herhangi bir veri elemanı eklenmeyecekse küme parantezi konmayabilir. Kotlin'de
    new operatörü yoktur.

    2.
    Anahtar Notlar: Kotlin'de sınıfın bir elemanına (member) herhangi bir erişim belirleyici anahtar sözcük
    yazmamak (no-modifier) "public" anlamına gelir. Biz yazmamayı tercih edeceğiz

    Anahtar Notlar: Anımsanacağı gibi Java'da no-modifier bir eleman aynı paketteki diğer sınıflar için "public",
    farklı paketteki sınıflar için "private" anlamındadır.

    3.
    Java dan hatırlanacağı üzere bir sınıfın birçok ctoru olduğunda bazı tasarımlarda asıl işi tek bir ctor
    yapar ve diğer ctorlar uygun parametrelerle o ctor'u çağırırlar. Bu ana işi yapan ctora primary ctor, onu
    çağıran ctorlara secondary ctors denir.

    Sınıfın public primary ctor'u aşağıdaki yazılır. Sınıfın primary ctor'unun bildiriminde constructor
    anahtar sözcüğü kullanılabilir.

    4.
    Sınıfın primary constructor bildiriminde sınıf isminden sonra,  ctor bildiriminden önce bildirime ilişkin bazı
    özellikler yazılacak constructor anahtar sözcüğü zorunludur. Örneğin erişim belilrleyicisi yazılacaksa constructor
    anahtar sözcüğü zorunludur.

    Default olarak zaten public olsa bile açıkça yazılırsa yine constructor yazılması zorunludur.

    5.
    Kotlinde teknik olarak programcı bir sınıfa veri elemanı bildiremez. Property elemanı ile derleyci
    bunu kendi üretebilir. Daha sonra ele alınacaktır.

    6.
    primary constructor'ın parametreleri var veya val olarak bildirildiklerinde sınıfın property elemanları
    bildirilmiş olur. property elemanı doğrudan veri elemanı değildir. Şimdilik adeta veri elemanıymış gibi
    diyebiliriz.

    Aşağıda Six017 sınıfının parametreleri artık o sınıfın property elemanlarıdır. Property ancak gönlümüzün
    veri elemanı :)

    7.
    Sınıfın property elemanları primary ctor içerisinde bildirilmişse erişim belirleyicisi de verilebilir.
    Şüphesiz default erişim belirleyici public'tir

    8.
    Sınıfın primary constructor'ının kodları init isimli bir blok içerisinde yazılabilir. init bloğu içerisinde
    primary constructor'ın parametrelerine veya primary constructor içerisinde bildirilmiş property elemanlarına
    erişilebilir.

    9.
    Bir sınıfın  primary ctor'u olmak zorunda değildir. Bu kural bazı sınıflar için söz konusu değildir. Örneğin
    "data sınıfları (data class)" için primary ctor yazmak zorunludur. "data sınıfları" ileride ele alınacaktır
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    val t = Three017one(10, 3.4)

    println("---------------------------------------------------------------------")

    val s = Six017(10, 3.4)
    println("s.a = ${s.a}, s.b = ${s.b}")
    ++s.a
    println("s.a = ${s.a}, s.b = ${s.b}")

    println("---------------------------------------------------------------------")

    val p = Seven017(10, 3.4)
    println("p.a = ${p.a}")
    // println("p.b = ${p.b}") // Error, çünkü private

    println("---------------------------------------------------------------------")

    val e = Eight018(10, 3.4)
}

class Three017one (a:Int, b:Double)
class Three017two constructor (a:Int, b:Double)

class Four017one private constructor (a:Int, b:Double)
// class Four017two public (a:Int, b:Double) // Error
class Four017two public constructor (a:Int, b:Double)

class Six017 (var a: Int, val b: Double)

class Seven017 (var a: Int, private var b: Double)

class Eight018 (var a: Int, private var b: Double) {
    init {
        println("Eight018 primary ctor: a = $a, b = $b")
        //...
    }
    //...
}