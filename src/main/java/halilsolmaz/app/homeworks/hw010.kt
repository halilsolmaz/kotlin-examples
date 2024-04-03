/*-----------------------------------------------------------------------------------------------------
   Parametresi ile aldığı Int türden bir dizinin elemanlarını stdout'a yazdıran write isimli
   fonksiyonu ve aldığı Int türden count, min ve bound ile random isimli Random türden parametreleri count elemanlı
   elemanları [min, bound) aralığında rasgele değerlerle doldurulmuş bir dizi referansına geri dönen randomIntArray isimli
   fonksiyonu yazınız ve test ediniz
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks

import halilsolmaz.app.util.console.kotlin.readInt
import kotlin.random.Random

fun main() = runRandomIntArrayTest()

fun runRandomIntArrayTest()
{
    while (true) {
        val count = readInt("Dizinin eleman sayısını giriniz:")

        if (count <= 0)
            break
        val a = randomIntArray(count, 0, 100)

        write(2, a)
    }

    println("Tekrar yapıyor musunuz?")
}

fun randomIntArray(count: Int, min: Int, bound: Int, random: Random = Random ) : IntArray
{
    val arr = IntArray(count)

    for (i in arr.indices)
        arr[i] = Random.nextInt(min, bound)

    return arr
}
fun write(a: IntArray) = write(1, a)

fun write(n: Int , a: IntArray)
{
    val fmt = "%%0%dd ".format(n)

    for (value in a)
        print(fmt.format(value))
}