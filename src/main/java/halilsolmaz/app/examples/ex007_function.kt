/*-----------------------------------------------------------------------------------------------------
    1.
    Fonksiyonların geri dönüş değeri bilgisi fonksiyon bildiriminde gövdeden önce : ile belirtilir.
    Fonksiyonun geri dönüş değeri yoksa ya hiçbir şey yazılmaz ya da :'den sonra Unit türü yazılır

    Not: Java da ki void Kotlin de unit demektir.

    2.
    Kotlin'de tek bir ifade içeren fonksiyonlar (single expression functions) için gövde yazmaya gerek yoktur. Tek
    ifadeli fonksiyonlar için geri dönüş değeri bilgisi yazılmasına da gerek yoktur

    3.
    Fonksiyonların parametre değişkenleri var veya val anahtar sözcüğü ile bildirilemez

    4.
    Fonksiyonların parametre değişkenlerinin fonksiyon içerisinde değerin değiştirilmesi geçersizdir

    5.
    Bir fonksiyon içerisinde bir parametre değişken ismi ile aynı olaran yerel değişken bildirimi geçerlidir. Ancak
    bazı programcılar özellikle kullanmaz
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    val number = readln().toInt();
    val result = isEven(number)
    if (result) println("$number is even") else println("$number is not even")

    foo()
    hello()

    val sum = sumNumbers(5, 10)
    println("sum = $sum")

    val x = increase(10)
    println("$x")
}

fun isEven(number: Int) = number % 2 == 0
fun foo() : Int = 10
fun hello() = println("hello")
fun sumNumbers(num1: Int, num2: Int) = num1 + num2

fun increase(x: Int): Int {
    //x++ // error
    var x = x // önerilmediği için ide shadowed uyarısı yapar.
    return ++x
}



