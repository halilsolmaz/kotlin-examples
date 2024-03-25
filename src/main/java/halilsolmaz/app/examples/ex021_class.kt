/*-----------------------------------------------------------------------------------------------------
    1.
    Bir property elemanının set bölümü ona atama yapıldığında çalışır. get bölümü ise değeri kullanılmak istendiğinde
    çalışır. Bir property elemanı için genel olarak arka planda yaratılan bir veri elemanı (backing field) bulunmaktadır.
    Property elemanı içerisinde, ilişkin olduğu veri elemanına erişmek için field bağlamsal anahtar sözcüğü
    (contextual keyword) kullanılabilir.

    2.
    Two021 de x ve y property elemanları için get ve set bölümleri otomatik olarak yazılmıştır.

    Not: Eğer var yerine val olarak bildirilseydi sadece get metodu oluşurdu.

    3.
    Three021 x property elemanı için private set yapılarak sınıf içerisinde atama yapılabilir ancak sınıf dışında
    readonly duruma getirilmiş olur.

    4.
    - Four021one sınıfında ise init bloğu içerisinde val olarak bildirilmiş x property elemanına değer
    verildiğinden artık ctor'lar içerisinde (aslında hiçbir yerde) değer verilemez.

    - Four021two sınıfında ise val olarak bildirilmiş x property elemanı için ilkdeğer verildiğinden
    ctor'lar içerisinde değer verilemez.

    - Four021three sınıfında ise default ctor içerisinde :this ctor sentaksı kullanıldığından, dolaylı
     olarak değer verilmiş olur. Tekrar default ctor içerisinde değer vermek hatalıdır.

    - Four021four sınıfının val olarak bildirilmiş property elemanına ilkdeğer (initialization) verilmediği
    için tüm ctor'larda değer verilmek zorundadır. Four021four sınıfında default ctor içerisinde :this ctor sentaksı
    kullanıldığından, dolaylı olarak değer verilmiş olur.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    val s = One021()
    s.x = 10
    println(s.x)
    println(s.x * 2)

    println("---------------------------------------------------------------------")

    val t = Two021()
    t.z = 3.4
    t.x = 34
    t.y = 345
    println("${t.x}, ${t.y}, ${t.z}")

    println("---------------------------------------------------------------------")

    val a = Three021()
    // a.x = 23 // Error
    println(a.x)
    a.foo(23)
    println(a.x)
}

class One021 {
    var x: Int = 0
        set(value)
        {
            println("set")

            field = value
        }
        get()
        {
            println("get")
            return field
        }
}

/*  One021 Java karşılığı :
    class App {
        public static void main(String [] args)
        {
            Sample s = new One021();

            s.setX(10);

            System.out.println(s.getX() * 2);
            System.out.println(s.getX());
        }
    }

    class One021 {
        private int field;

        public int getX()
        {
            System.out.println("getX");
            return field;
        }

        public void setX(int value)
        {
            System.out.println("set");
            field = value;
        }
    }
 */

class Two021 {
    var x = 0
    var y: Int
    var z: Double = 0.0
        set(value)
        {
            //...
            field = value //backing field
        }

    init {
        y = 20
    }
}

class Three021 {
    var x: Int = 0
        private set

    init {
        x = 34
    }

    fun foo(a: Int)
    {
        x = a
    }
}

/*
class Four021one {
    val x: Int

    init {
        x = 0
    }

    constructor(a: Int)
    {
        //...
        x = a //error
    }

    constructor() : this(0)
    {
        //...
    }

    //...
}

class Four021two {
    val x: Int = 10

    constructor(a: Int)
    {
        //...
        x = a //error
    }

    constructor() : this(0)
    {
        //...
    }
}

class Four021three {
    val x: Int

    constructor(a: Int)
    {
        //...
        x = a;
    }

    constructor() : this(0)
    {
        x = 10
    }

    //...
}
class Four021four {
    val x: Int

    constructor(a: Int)
    {
        //...
        x = a;
    }

    constructor() : this(0)
    {
        //...
    }

    //...
}
*/
