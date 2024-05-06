/*-----------------------------------------------------------------------------------------------------
    1.
    Map<K, V>/MutableMap<K, V> arayüzü anahtara karşılık gelen değerlere ilişkin collection sınıflarının taban arayüzüdür.
    Map<K, V>/MutableMap<K, V> arayüzü hiç bir arayüzden türetilmemiştir. Bu arayüzü implemente eden sınıflar için anahtar
    türü Set<K> olarak tutulur. En çok kullanılan HashMap<K, V> ve TreeMap<K, V> sınıfları K türünü sırasıyla HashSet<T>
    ve TreeSet<T> olarak tutarlar.

    map tarzı colection'lar;

    put: Eğer ekleme yaptığımız key ilk kez ekleniyorsa null döner.
    Eğer var olmasına rağmen ekleniyorsa geri dönüş değeri artık yeni key yeni value ile eşleşir ancak
    geri dönüş değeri eski value olur.

    Ancak bir map'te value değeri null olabilir. Böyle bir senaryo varsa ilgili key'in var olup olmadığını
    dönüş değerin null olup olmamasından anlayamayız.
    Bu nedenle bir anahtarın varlığı containsKey metodu ile sorgulanır.(Bu anahtarın varlığını anlamak için
    bu metot;hashSet tarzı collectionlarda equals ve hashCode'a bakar. threeMap te ise equals'a bakar.)

    iki farklı kullanım örneği aşağıda verilmiştir.

    2.
    Aşağıdaki örnekleri inceleyiniz.

    Not: map tarzı colection'lar: Örnekte TreeMap kullanıldığından anahtar değerlerinin sıralanması gerekmez
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.test.data.loadNamesFromFileAsMap
import halilsolmaz.app.test.data.loadNamesFromFileAsTreeMap

fun main()
{
    println("-------------------------------one-one--------------------------------")
    one071one()
    println("-------------------------------one-two--------------------------------")
    one071two()
    println("-------------------------------two-one--------------------------------")
    two071one()
    println("-------------------------------two-two--------------------------------")
    two071two()
}

fun one071one()
{
    val cityMap = mutableMapOf<Int, String?>()

    println(cityMap.javaClass.name)

    cityMap.put(35, "izmir")
    cityMap.put(35, "smyrna")
    cityMap.put(6, "ankara")

    if (cityMap.containsKey(35))
        println(cityMap.get(35))
    else
        println("Aranan il bulunamadı")
}

/*********************************************************************************************************************/

fun one071two()
{
    val cityMap = mutableMapOf<Int, String?>()

    println(cityMap.javaClass.name)

    cityMap[34] = "istanbul"
    cityMap[6] = "ankara"

    if (cityMap.containsKey(78))
        println(cityMap[78])
    else
        println("Aranan il bulunamadı")
}

/*********************************************************************************************************************/

fun two071one()
{
    try {
        val namesMap = loadNamesFromFileAsMap("nameswithkeys.csv")

        println("Size: ${namesMap.size}")

        namesMap.keys.sortedBy { it }.forEach {print("$it -> "); namesMap[it]?.forEach { print("$it ") }; println()}

        println("Size: ${namesMap.size}")
    }
    catch (ex: Throwable) {
        ex.printStackTrace()
    }
}

fun two071two()
{
    try {
        val namesMap = loadNamesFromFileAsTreeMap("nameswithkeys.csv")

        println("Size: ${namesMap.size}")

        namesMap.keys.forEach {print("$it -> "); namesMap[it]?.forEach { print("$it ") }; println()}

        println("Size: ${namesMap.size}")
    }
    catch (ex: Throwable) {
        ex.printStackTrace()
    }
}
