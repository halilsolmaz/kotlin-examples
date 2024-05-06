/*-----------------------------------------------------------------------------------------------------
    1.
    Aşağı seviyede fonksiyonların da adresleri vardır. Aslında bir fonksiyon çağrısı o fonksiyonun kodlarının bulunduğu
    adrese gidip çalıştırılmasıdır. Bazı programlama dillerinde fonksiyonların adreslerini tutan türler bulunur. Bu türlere
    genel olarak "function type" denir.

    Not: C'de ki func pointer'a denk gelmektedir. Java da yoktur.

    2.
    Function tür bildirimi:
    ([parametre listesi]) -> <Geri dönüş değeri türü>

    val f1: (Int, String) -> String
    val f2: (Int) -> Int
    val f3: (Int) -> Unit
    var f4: () -> Unit
    val f5: (Int, Int) -> Int
    //...

    3.
    Kotlin'de bir fonksiyonun ismi fonksiyonun yapısına (yani parametri yapı ve geri dönüş değeri) uygun bir function
    türüne atanabilir. Fonksiyon türü bir referans türüdür. Fonksiyon türünden bir referans ile fonksiyon çağırma operatörü
    kullanıldığında, referansı (adresi) tutulan fonksiyon çağrılmış olur. Bu anlamda bakıldığında aslında fonksiyon ismi
    o fonklsiyonun adresi (referansı) gibi düşünülebilir.

    Bir fonksiyon türüne global bir fonksiyon ismi method reference operatörü (::) ile değer olarak verilebilir. Aşağıdaki
    örnek durumu göstermek için yazılmıştır.

    4.
    Bir fonksiyon türüne bir sınıfın üye fonksiyonu (metot) da atanabilir. Bu durumda referans ve :: ile metot ismi verilerek
    atama yapılır. Aşağıdaki örnek durumu göstermek için yazılmıştır

    5.
    Kotlin'de fonksiyonlar ismine Lambda function ya da function literal bir sentaks ile de bildirilebilir.
    Lambda function bir fonksiyon türündendir. Yazılışına göre tür derleyici tarafından tespit edilir
    ve istenirse uygun bir function türünden referansa atanabilir.
    Lambda fonksiyonlarda son yazılan ifadenin değerine geri dönülmiş olur. Ya da başka bir deyişle geri dönüş değeri
    olan bir fonksiyon türü için lambda fonksiyon yazıldığında son yazılan ifade adeta return deyimi ile yazılmış olur.

    6.
    Aşağıdaki örnekte bir function literal yazılmış ve fonksiyon çağırma operatörü uygulanmıştır. Bu durumda derleyici
    Kotlin anlamında aşağıdaki gib bir fonksiyon yazar:
        fun _xyz(a: Int, b: Int) : Int = a + b
    Fonksiyon çağrısını da şu şekilde yapar:
        _xyz(10, 20)

    Bu işlemin Java karşılığı yaklaşık şu şekildedir:

    class _xyz {
        public int abc(int a, int b)
        {
            return a + b;
        }
     }

     var x = new _xyz();

     x.abc(10, 20);

     7.
     Parametresiz bir lambda fonksiyonu/fonksiyon sabiti lambda function/function literal bildirimi aşağıda
     örnekte verilmiştir.

     Not: -> kullanımı zorunlu değildir.

     Not: Geri dönüş değeri verilerekte yazılabilir.

     8.
     Parametreli bir fonksiyon türü için parametre değişkenleri fonksiyon sabiti içerisinde bildirilebilir. Eğer
     lambda fonksiyonun atandağı değişkenin türü belirli ise parametre değişkenlerine türler yazılmayabilir.

     Aşağıdaki örnekte f'nin türü yazılmadığından a parametre değişkeninin türü yazılmalıdır



-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import kotlin.random.Random

fun main()
{
    println("-------------------------------three-----------------------------------")
    three059()
    println("-------------------------------four-----------------------------------")
    four059()
    println("-------------------------------six-----------------------------------")
    six059()
    println("-------------------------------seven-----------------------------------")
    seven059()
    println("-------------------------------eight-----------------------------------")
    eight059()
}

fun three059()
{
    val f1: (Int, String) -> String = ::toStr059
    val f2: (Int) -> Int = ::square059
    val f3 : (Int) -> Unit = ::display059
    val f4 : () -> Unit = ::printRandomIntValue059
    val f5 : (Int, Int) -> Int = ::add059

    println(f1(10, "Value"))
    println(f2(10))
    f3(20)
    f4()
    println(f5(10, 20))
}
fun toStr059(a: Int, msg: String) = "$msg:$a"
fun square059(a: Int) = a * a

fun display059(a: Int) = println("a = $a")
fun printRandomIntValue059() = println(Random.nextInt())
fun add059(a: Int, b: Int) = a + b

/*********************************************************************************************************************/

typealias IntBinaryOperator = (Int, Int) -> Int

fun four059()
{
    val op = BinaryOperation(10)
    val f1: IntBinaryOperator = op::add
    val f2: IntBinaryOperator = Operation059::add

    println(f1(20, 30))
    println(f2(10, 35))
}

data class BinaryOperation(val value: Int) {
    fun add(a: Int, b: Int) = value + a + b
}

object Operation059 {
    fun add(a: Int, b: Int) = a + b
}

/*********************************************************************************************************************/

fun six059()
{
    println({a: Int, b: Int -> a + b}(10, 20)) // lamda function ya da function literal denir.
}

/*********************************************************************************************************************/

fun seven059()
{
    val f1 = {-> println("Merhaba")}
    val f2 = {println("Merhaba")}
    val f3: () -> Unit = {println("Merhaba")}

    f1()
    f2()
    f3()
}

/*********************************************************************************************************************/

fun eight059()
{
    val f = {a: Int -> println(a)}

    f(10)
}

/*********************************************************************************************************************/
