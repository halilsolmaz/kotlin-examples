/*-----------------------------------------------------------------------------------------------------
    1.
    SAM (Single Abstract Method) interface. Bu arayüzlerin bir ve yalnız bir tane abstract metotları olmalıdır. Aksi durumda
    error oluşur. Bu arayüzler fun olarak bildirilirler. Bu kavram Java'daki "functional interface" ile uyumlu olması
    açısından eklenmiştir. Programcı özel bir durum yoksa Kotlin'de SAM arayüzleri yerine fonksiyon türlerini kullanmalıdır.
    Örnek durumu göstermek için yazılmıştır.

    2.
    Kotlin 1.4'den itibaren virgülle ayrılan her liste tarzı ifadenin sonunda kullanılan virgül geçerlidir (trailing comma)
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one--------------------------------")
    one075()
    println("-------------------------------two--------------------------------")
    two075()
}

fun one075()
{
    MySample.doWorkSAM(10) {it % 2 == 0}
    MySample.doWork(10) {it % 2 == 0}
}

fun interface IIntPredicate {
    fun test(a: Int) : Boolean
}

class MySample {
    companion object {
        fun doWorkSAM(a: Int, pred: IIntPredicate)
        {
            println("doWork(a: Int, pred: IIntPredicate)")
            if (pred.test(a))
                println(a)
        }

        fun doWork(a: Int, pred: (Int) -> Boolean)
        {
            println("doWork(a: Int, pred: (Int) -> Boolean)")
            if (pred(a))
                println(a)
        }
    }
}

/*******************************************************************************************************************************/

fun two075()
{
    foo076(b = 3, c = 1, a = 10,) //Since 1.4
    val a = intArrayOf(10, 30, 20,) //Since 1.4
    println("ankara",) //Since 1.4
}

enum class Colorr {
    RED, GREEN, BLUE,  BLACK, WHITE,  //Since 1.4
}

fun foo076(a: Int, b: Int, c: Int = 10,) //Since 1.4
{
    println("a=$a")
    println("b=$b")
    println("c=$c")
}
