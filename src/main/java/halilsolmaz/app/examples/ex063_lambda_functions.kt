/*-----------------------------------------------------------------------------------------------------
    1.
    Dizilerin fonksiyon parametresi alan fonksiyonları vardır. Bunların bazıları extension olarak yazılmıştır. Bu fonksiyonlardan
    bazıları burada anlatılacaktır, bazıları ise ileride ele alınacaktır.

    2.
    Dizilerin forEach fonksiyonu dizinin her bir elemanına callback olarak aldığı fonksiyonu uygular
    Dizilerin any fonksiyonu callback olarak aldığı predicate fonksiyona göre koşula uyan en az bir tane eleman varsa
    true değerine döner. all fonksiyonu callback olarak aldığı predicate fonksiyona göre tüm elemanlar koşula uyuyor
    ise true değerine döner. none fonksiyonu callback olarak aldığı predicate fonksiyona göre hiç bir eleman koşula
    uymuyor ise true değerine geri döner.

    3.
    Dizilerin filter fonksiyonu

    4.
    Aşağıda örneklerde ilgili dosyadan okuma yapan fonskiyonların kodları şu aşamada önemsizdir. Proje içerisinde ilgili
    dosyalar ilgilşi formatlarda olduğu durumda örnekler çalıştırılabilir. Burada odaklanılması gereken bu dosyalardaki
    veriler veya bu dosyaları okuyan fonksiyonların nasıl yazıldığı değildir. Burada dizilere ilişkin fonksiyonların
    kullanımına odaklanılması gerekir.

    Aşağıdaki örneklerde stokta bulunmayan ürün varsa listelenmiştir.
    Not: Her ürün stokta var için "product-org.csv" kullanınız.

    5.
    - one
    Aşağıdaki örnekte klavyeden girilen minimum ve maksimum değerler arasındaki fiyata sahip stokta bulunan
    ürünler listelenmiştir. Örnekte JavaSE'de bulunan BigDecimal sınıfı Java bakış açısıyla kullanılmıştır.

    - two
    Aşağıdaki örnekte klavyeden girilen minimum ve maksimum değerler arasındaki fiyata sahip stokta bulunan
    ürünler listelenmiştir. BigDecimal sınıfı Comparable arayüzünü desteklediği ve dolayısıyla compareTo metodunu
    override ettiği için Kotlin'de <, >, <=, >= operatörleri ile de kullanılabilir. Artık kod Kotlin bakış açıksıyla
    yazılmıştır.

    - three
    Aşağıdaki örnekte filter fonksiyonu her koşul için ayrı çağrılmıştır. Kodun yukarıdaki koda göre ekstra bir
    maliyeti yoktur. Hatta bazı durumlarda birden fazla kez çağrılması okunabilirliği/algılanabilirliği artırır

    - four
    Aşağıdaki örnekte koşullara uyan verilerden oluşan yeni bir dizi elde edilmiştir. Şüphesiz sadece forEach kullanılacaksa
    bu durumda yeni dizi elde edilmeden devam edilmesi daha etkindir.

    - five
    Aşağıdaki örnekte koşullara uyan ürünlerin isimlerinden oluşan yeni dizi (Array<Product> dizisinden Array<String>)
    elde edilmiştir

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.test.data.loadProductsFromFileAsArray
import halilsolmaz.app.util.console.kotlin.readBigDecimal
import halilsolmaz.app.util.console.kotlin.readInt
import halilsolmaz.app.util.string.kotlin.randomTextEN
import kotlin.random.Random

fun main()
{
    println("-------------------------------two-----------------------------------")
    two063()
    println("-------------------------------three-----------------------------------")
    three063()
    println("-------------------------------four-one-----------------------------------")
    four063one()
    println("-------------------------------four-two-----------------------------------")
    four063two()
    println("-------------------------------four-three-----------------------------------")
    four063three()
    println("-------------------------------four-four-----------------------------------")
    four063four()
    println("-------------------------------five-one------------------------------------")
    five063one()
    println("-------------------------------five-two------------------------------------")
    five063two()
    println("-------------------------------five-three------------------------------------")
    five063three()
    println("-------------------------------five-four------------------------------------")
    five063four()
    println("-------------------------------five-five------------------------------------")
    five063five()
}

fun two063()
{
    val a = IntArray(2) { Random.nextInt(-10, 10)}

    a.forEach {print("$it ")}
    println()
    println(a.any {it % 2 == 0}) // En az biri predicate koşula uyarsa true döner.
    println(a.all {it > 0}) // Hepsi predicate koşula uyarsa true döner.
    println(a.none {it <= 0}) // Hiç biri predicate koşula uymazsa true döner.
}

/*********************************************************************************************************************/

fun three063()
{
    val count = readInt("Bir sayı giriniz:")
    val threshold = readInt("Eşik değerini giriniz:")
    val cities = Array(count) {Random.randomTextEN(Random.nextInt(5, 10))}

    cities.forEach{print("$it ")}

    println("\n------------------------------------------------------------------------")

    cities.filter{it.length > threshold}.forEach{print("$it ")}

    println()
}

/*********************************************************************************************************************/

fun four063one()
{
    try {
        val products = loadProductsFromFileAsArray("products.csv")

        if (products.any {it.stock <= 0}) {
            println("Stokta olmayan ürünler:")
            products.filter {it.stock <= 0}.forEach(::println)
        }
        else
            println("Her ürün stokta var")
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

fun four063two()
{
    try {
        val products = loadProductsFromFileAsArray("products.csv")

        if (products.any {it.stock <= 0}) {
            println("Stokta olmayan ürünler:")
            products.filter {it.stock <= 0}.map {it.name}.forEach(::println)
        }
        else
            println("Her ürün stokta var")
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

fun four063three()
{
    try {
        val products = loadProductsFromFileAsArray("products.csv")

        if (products.all{it.stock > 0})
            println("Her ürün stokta var")
        else
        {
            println("Stokta olmayan ürünler:")
            products.filter {it.stock <= 0}.map { it.name }.forEach(::println)
        }
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

fun four063four()
{
    try {
        val products = loadProductsFromFileAsArray("products.csv")

        if (products.none{it.stock <= 0})
            println("Her ürün stokta var")
        else {
            println("Stokta olmayan ürünler:")
            products.filter {it.stock <= 0}.map { it.name }.forEach(::println)
        }
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun five063one()
{
    try {
        val products = loadProductsFromFileAsArray("products.csv")
        val minPrice = readBigDecimal("Minimum fiyatı giriniz:")
        val maxPrice = readBigDecimal("Maximum fiyatı giriniz:")

        products.filter { it.stock > 0 && minPrice.compareTo(it.price) < 0  && it.price.compareTo(maxPrice) < 0 }
            .forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun five063two()
{
    try {
        val products = loadProductsFromFileAsArray("products.csv")
        val minPrice = readBigDecimal("Minimum fiyatı giriniz:")
        val maxPrice = readBigDecimal("Maximum fiyatı giriniz:")

        products.filter { it.stock > 0 && minPrice < it.price  && it.price < maxPrice }
            .forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun five063three()
{
    try {
        val products = loadProductsFromFileAsArray("products.csv")
        val minPrice = readBigDecimal("Minimum fiyatı giriniz:")
        val maxPrice = readBigDecimal("Maximum fiyatı giriniz:")

        products.filter {it.stock > 0}.filter {minPrice < it.price}.filter {it.price < maxPrice}
            .forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun five063four()
{
    try {
        val products = loadProductsFromFileAsArray("products.csv")
        val minPrice = readBigDecimal("Minimum fiyatı giriniz:")
        val maxPrice = readBigDecimal("Maximum fiyatı giriniz:")

        val result = products
            .filter {it.stock > 0}
            .filter {minPrice < it.price}
            .filter {it.price < maxPrice}
            .toTypedArray()

        //...

        result.forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/

fun five063five()
{
    try {
        val products = loadProductsFromFileAsArray("products.csv")
        val minPrice = readBigDecimal("Minimum fiyatı giriniz:")
        val maxPrice = readBigDecimal("Maximum fiyatı giriniz:")

        val result = products
            .filter {it.stock > 0}
            .filter {minPrice < it.price}
            .filter {it.price < maxPrice}
            .map {it.name}
            .toTypedArray()

        //...

        result.forEach(::println)
    }
    catch (ex: Throwable) {
        println(ex.message)
    }
}

/*********************************************************************************************************************/
