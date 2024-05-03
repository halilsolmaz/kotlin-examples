/*-----------------------------------------------------------------------------------------------------
    1.
    Collection<T>/MutableCollection<T> arayüzünden Set<T>/MutableSet<T> arayüzü türetilmiştir. Set<T> ve MutableSet<T>
    arayüzleri matematik'teki küme kavramını temsil eden arayüzlerdir. Yani, elemanların eklenme sırasının önemi yoktur ve
    bir elemandan birden fazla aynı küme collection'ında olamaz.

    2.
    Set tarzı collection sınıflar Set<T> veya MutableSet<T> arayüzünü desteklerler.

    3.
    toHashSet: Elemanların sırasının değişebildiğine (çünkü önemi yok) dikkat ediniz.
    Ayrıca elemanları tekrarlamaz.

    Not:
    toSet: Dönüştürülen kümenin türü, orijinal koleksiyonun türüne bağlıdır.
        Örneğin, bir listeyi toSet ile dönüştürürseniz, LinkedHashSet tipinde bir küme elde edersiniz.
        Bir diziyi toSet ile dönüştürürseniz, HashSet tipinde bir küme elde edersiniz.
     toHashSet: Her zaman HashSet tipinde bir küme üretir.

     Not: hashSet bir sınıf, set ise bir interfacedir. hashSet, set'i implement etmiştir.

    4.
    Set tarzı collection'larda, "hash" kullananlar eşitlik kontrolü için equals ve hashCode metotlarının geri dönüş
    değerine bakarlar. Bu durumda programcı bir tür durumlar için bu metotları gerekirse override etmelidir.

    Anahtar Notlar: Hash code üretmek ayrı bir kavramdır ve bir çok durumda üretmenin farklı yöntemleri vardır. Aşağıdaki
    örnekte ürünün id değeri Int olduğundan ve aynı id'ye sahip birden fazla ürünün "set" içerisinde bulunmaması gerektiği
    varsayımıyla düşünülmüştür.

    Not: Product'ın override edilmiş hashCode ve equals metotları:

    data class Product(var id: Int = 0,
                   var name: String = "",
                   var stock: Int = 0,
                   var cost: BigDecimal = BigDecimal.ZERO,
                   var price: BigDecimal = BigDecimal.ZERO) {

    override fun hashCode(): Int = id

    override fun equals(other: Any?) = other is Product && other.id == id

    5.
    TreeSet sınıfı elemanları sıralı biçimde tutar

    6.
    Aşağıdaki örneklerde ürünler isimlerine göre ascending ve descending sıralanmıştır.
    Burada loadProductsFromFileAsTreeSet fonksiyonunun aldığı Comparator<Product> parametresi TreeSet'in ilgili ctor'una
    argüman olarak geçilmektedir. Yani TreeSet sıralama kriterini callback olarak almıştır.

    Not: Kotlin de sıralama anlaşması Comparable ve/veya Comparator denilen iki tane arayüzle yapılır.
    Sralama için ya Comparable tür istenir ya da Comparator ile sıralama kriteri istenir. Örnekte sıralama
    kriteri verilmiştir.

    7.
    Aşağıdaki örneği inceleyiniz.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.test.data.Product
import halilsolmaz.app.test.data.loadProductsFromFileAsIterable
import halilsolmaz.app.test.data.loadProductsFromFileAsSet
import halilsolmaz.app.test.data.loadProductsFromFileAsTreeSet
import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.iterable.kotlin.write
import java.util.*
import kotlin.random.Random

fun main()
{
    println("-------------------------------two---------------------------------")
    two070()
    println("-------------------------------three-one---------------------------------")
    three070one()
    println("-------------------------------three-two---------------------------------")
    three070two()
    println("-------------------------------four---------------------------------")
    four070()
    println("-------------------------------five---------------------------------")
    five070()
    println("-------------------------------six-one---------------------------------")
    six070one()
    println("-------------------------------six-two---------------------------------")
    six070two()
    println("-------------------------------seven---------------------------------")
    seven070()
}

fun two070()
{
    val mutableSet = mutableSetOf(89, 1, 2, 3, 1, 3, 4, 5)

    println(mutableSet.javaClass.name)
    println(mutableSet.add(45))
    println(mutableSet.add(45))
    mutableSet.add(450)
    write(mutableSet)
}

/*********************************************************************************************************************/

fun three070one()
{
    val a = IntArray(Random.nextInt(100)) { Random.nextInt(10, 20) }

    a.forEach { print("$it ") }
    println()

    val hasSet = a.toHashSet()
    hasSet.forEach{print("$it ") }
    println()
}

fun three070two()
{
    val a = IntArray(Random.nextInt(100)) { Random.nextInt(10, 20) }

    a.forEach { print("$it ") }
    println()

    val hasSet = a.toSet()
    hasSet.forEach{print("$it ") }
    println()
}

/*********************************************************************************************************************/

fun four070()
{
    try {
        val allProducts = loadProductsFromFileAsIterable("products.csv")
        val products = loadProductsFromFileAsSet("products.csv")

        println(products.javaClass.name)

        products.forEach(::println)
        println("Count:${products.count()}")
        println("All products Count:${allProducts.count()}")
    }
    catch (ex: Throwable) {
        ex.printStackTrace()
    }
}

/*********************************************************************************************************************/

fun five070()
{
    try {
        val products = loadProductsFromFileAsTreeSet("products.csv")

        products.forEach(::println)
        println("Count: ${products.count()}")
    }
    catch (ex: Throwable) {
        ex.printStackTrace()
    }
}

/*********************************************************************************************************************/

fun six070one()
{
    try {
        val products = loadProductsFromFileAsTreeSet("products.csv") {p1, p2 -> p1.name.compareTo(p2.name)}

        products.forEach(::println)
        println("Count: ${products.count()}")
    }
    catch (ex: Throwable) {
        ex.printStackTrace()
    }
}

/*********************************************************************************************************************/

fun six070two()
{
    try {
        val products = loadProductsFromFileAsTreeSet("products.csv") {p1, p2 -> p1.name.compareTo(p2.name)}

        products.forEach(::println)
        println("Count: ${products.count()}")
    }
    catch (ex: Throwable) {
        ex.printStackTrace()
    }
}

/*********************************************************************************************************************/

fun seven070()
{

    var count = readInt("Kaç tane kupon oynamak istersiniz?")

    while (count-- > 0) {
        val numbers = getNumericLotteryNumbers()

        numbers.forEach { print("%02d ".format(it)) }
        println()
    }
}

fun getNumericLotteryNumbers(random: Random = Random) : IntArray
{
    val treeSet = TreeSet<Int>()

    while (treeSet.size != 6)
        treeSet.add(random.nextInt(1, 50))

    return treeSet.toIntArray()
}