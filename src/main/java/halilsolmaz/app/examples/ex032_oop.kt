/*-----------------------------------------------------------------------------------------------------
    1.
    Kotlin'de sınıfların private property elemanlarını Java'daki gibi "m_" ile değil, "m" öneki ile başlatacağız.

    2.
    Sınıflararası ilişkiler aslında nesneler arasındaki ilişkiler olarak düşünülmelidir.
    İki sınıf arasında genel olarak aşağıdaki ilişkilerden ya hiçbirisi yoktur ya da bir tanesi vardır:
    - İçerme (Composition) (has a)
    - Birleşme (Aggregation) (holds a)
    - Çağrışım (Association)
    - Türetme/Kalıtım (Inheritance) (is a)

    3.
    Kotlin'de ve Java'da bir sınıf birden fazla (doğrudan) taban sınıfa sahip olamaz. Yani çoklu türetme (multiple inheritance)
    yoktur. Bir sınıf yalnızca tek bir sınıftan türetilebilir.

    Anahtar Notlar: Kotlin'de ve Java'da çoklu türetmenin gerektiği yerlerde kısmi (partial) olarak desteklenmesini sağlayan
    "interface" denilen bir tür bulunmaktadır. Çoklu türetmenin pratikteki gerekliliği "interface"'ler ile
    karşılanabilmektedir. "interface" konusu ileride ele alınacaktır.

    4.
    Anımsanacağı gibi Java'da bir sınıf final anahtar sözcüğü ile bildirilmemişse türetmeye açıktır. Yani bu durumda Java'da
    bir sınıf default olarak türetmeye açıktır denebilir. Ancak Kotlin'de bir sınıf default olarak türetmeya açık değildir.
    Bir sınıfın türtilebilir olması yani türetmeye açık olması için open anahtar sözcüğü ile bildirilmesi gerekir.

    5.
    Türetme işlemi : atomu ile yapılır

    6.
    Anımsanacağı gibi türemiş sınıf nesnesi içerisinde taban sınıf nesnesi kadarlık bir bellek bölgesi de bulunmaktadır.
    Bu anlamda türemiş sınıf nesnesi taban sınıf nesnesini kapsar durumdadır. Bu kapsama mantıksal değildir. Yani bellek
    kapsamadır.

    7.
    Anımsanacağı gibi Java'da (dolayısıyla Kotlin JVM'de) bir nesnenin yaratılması adımları şunlardır:
    - 1. Bellekte yer ayrılır
    - 2. non-static olan ve final olmayan veri elemanlarına default değerler atanır.
    - 3. ctor çağrılır

    Bir nesnenin yartılmasının tamamlanması yani adresinin elde edilmesi bu 3 adımın düzgün bir biçimde tamamlanmasıyla
    olur. Bu adımlar herhangi birinde problem olursa nesne yaratılmamış olur. Örneğin ctor'da bir exception oluştuğunda
    nesne yaratılması adımları düzgün bir biçimde tamamlanmadığı için nesne yaratılmış olmaz

    8.
    Taban sınıfın herhangi bir ctor'unun çağrılmasının sağlanması

    9.
    Taban sınıfın herhangi bir ctor'unun super anahtar sözcüğü kullanılarak çağrılmasının sağlanması. Taban sınıfın
    primary ctor'u yoksa türetmede :'den sonra doğrudan sınıf ismi kullanılır

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("--------------------------------eight-------------------------------------")
    eight032()
    println("--------------------------------nine-------------------------------------")
    nine032()
}

fun eight032()
{
    var x = B(10)
    println("-------------------------------------")
    var y = B(1.0)
    println("-------------------------------------")
    var z = C()

    //...
}

class C : A() {
    init {
        println("default ctor of C")
    }
}

class B(x: Int) : A(x) {
    init {
        println("ctor(Int) of B")
    }

    constructor(x: Double) : this(x.toInt())
    {
        println("ctor(Double) of B")
    }
}

open class A(c: Int) {
    init {
        println("ctor(Int) of A")
    }

    constructor() : this(10)
    {
        println("default ctor of A")
    }
}



/* ******************************************************************   */

fun nine032()
{
    Y()
    println("-------------------------------------")
    Y(10)
}

class Y : X {
    constructor() //: super()   // yazılmadığında zaten default ctor çağrılır.
    {
        println("default ctor of Y")
    }

    constructor(Y: Int) : super(Y)
    {
        println("ctor(Int) of Y")
    }
}

open class X {
    constructor(Y: Int)
    {
        println("ctor(Int) of X")
    }

    constructor()
    {
        println("default ctor of X")
    }
}