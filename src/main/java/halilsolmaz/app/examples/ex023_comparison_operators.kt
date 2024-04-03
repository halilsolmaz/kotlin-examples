/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'de == ve != operatörleri ile karşılaştırma sırasında ileride daha detaylı olarak ele alacağımız equals metodu
    override edilmişse bu metot çağrılır ve geri dönüş değerine göre işlem yapar. Yani bu durumda referans karşılaştırması
    yapmaz. equals metodu override edilmemişse referans karşılaştırması yapar.

    data sınıflarının equals metodu içerisinde  property elemanlarını == işlemine sokacak şekilde otomatik
    olarak override edildiğinden örnekte == operatörü true değer üretir. Yani artık referans karşılaştırması yapmaz.
    data sınıfları ileride detaylı  olarak ele alınacaktır

    Aşağıdaki örneği sınıf bildiriminde data anahtar sözcüğünü kaldırarak test ediniz ve sonucu gözlemleyiniz.

    2.
    Kotlin'de referans karşılaştırmasının kesin olarak yapılabilmesi için iki tane ek eşitlik karşılaştırma
    operatörleri bulunmaktadır: ===, !==. Bu durumda programcı kesinlikle referans karşılaştırması yapmak istiyorsa
    bu operatörleri tercih etmelidir.

    3.
    Her ne kadar temel türler (yani temel türlere ilişkin sınıflar) için de ===, !== operatörleri kullanılabilse de
    anlamsız bir durum oluştuğundan bu operatörlerin temel türler için kullanımı deprecated olmuştur

    Not: Çünkü temel türden sınıflar diğer sınıflardan farklı olarak referans tutmazlar.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("---------------------------------------------------------------------")
    one023()
    println("---------------------------------------------------------------------")
    two023()
    println("---------------------------------------------------------------------")
    three023()
}

class One023Class(var value: Int)

data class One023ClassV1(var value: Int)
fun one023()
{
    val s = One023Class(10)
    val k = One023Class(10)

    println(if (s == k) "Aynı nesne" else "Farklı nesneler")

    println("****************************")

    val s1 = One023ClassV1(10)
    val k1 = One023ClassV1(10)

    println(if (s1 == k1) "Aynı nesne" else "Farklı nesneler")
}

fun two023()
{
    val s = One023Class(10)
    val k = One023Class(10)

    println(s === k)
    println(s !== k)
}

fun three023()
{
    print("Birinci sayıyı giriniz:")
    val a = readln().toInt()

    print("İkinci sayıyı giriniz:")
    val b = readln().toInt()

    println(a === b) //Deprecated
    println(a == b)
}