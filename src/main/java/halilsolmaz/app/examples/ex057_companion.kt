/*-----------------------------------------------------------------------------------------------------


     Aşağıdaki örnekte Console isimli sınıf Java bakış açısıyla mantıksal static olarak bildirilmiştir.
     Anımsanacağı gibi tüm elemanları static olarak bildirilen sınıflara mantıksal static sınıflar ya da "utility" sınıflar
     denir ve utility sınıfların ctor'ları private yapılır. Örnek Java düşüncesiyle yazılmıştır. Kotlin açısından iyi
     yazılmamıştır
----------------------------------------------------------------------------------------------------------------------*/

/*

package org.csystem.app

fun main()
{
    val a = ConsoleUtil.readInt("Birinci sayıyı giriniz:")
    val b = Console.readInt("İkinci sayıyı giriniz:")

    println("$a * $b = ${a * b}")
}

object ConsoleUtil {
    fun readInt(message: String, errorMessage: String = "", end: String = "") : Int
    {
        while (true) {
            try {
                return Console.readString(message, end).toInt()
            }
            catch (ex: Throwable) {
                print(errorMessage + end)
            }
        }
    }
}
class Console private constructor() {
    companion object {
        fun readString(message: String, end: String = "") : String
        {
            print(message + end)

            return readLine()!!
        }

        fun readInt(message: String, errorMessage: String = "", end: String = "") : Int
        {
            while (true) {
                try {
                    return readString(message, end).toInt()
                }
                catch (ex: Throwable) {
                    print(errorMessage + end)
                }
            }
        }

        fun readLong(message: String, errorMessage: String = "", end: String = "") : Long
        {
            while (true) {
                try {
                    return readString(message, end).toLong()
                }
                catch (ex: Throwable) {
                    print(errorMessage + end)
                }
            }
        }


        fun readDouble(message: String, errorMessage: String = "", end: String = "") : Double
        {
            while (true) {
                try {
                    return readString(message, end).toDouble()
                }
                catch (ex: Throwable) {
                    print(errorMessage + end)
                }
            }
        }
    }
}

*/

/*----------------------------------------------------------------------------------------------------------------------
     Yukarıdaki örnek Kotlin bakış açısıyla aşağıdaki gibi daha iyi yazılabilir. Her iki durumda da unutlmamalıdır ki
     object'in ve companion object'in metotları static metotlar değildir
----------------------------------------------------------------------------------------------------------------------*/
/*

package org.csystem.app

fun main()
{
    val a = Console.readInt("Birinci sayıyı giriniz:")
    val b = Console.readInt("İkinci sayıyı giriniz:")

    println("$a * $b = ${a * b}")
}


object Console {
    fun readString(message: String, end: String = "") : String
    {
        print(message + end)

        return readLine()!!
    }

    fun readInt(message: String, errorMessage: String = "", end: String = "") : Int
    {
        while (true) {
            try {
                return readString(message, end).toInt()
            }
            catch (ex: Throwable) {
                print(errorMessage + end)
            }
        }
    }

    fun readLong(message: String, errorMessage: String = "", end: String = "") : Long
    {
        while (true) {
            try {
                return readString(message, end).toLong()
            }
            catch (ex: Throwable) {
                print(errorMessage + end)
            }
        }
    }


    fun readDouble(message: String, errorMessage: String = "", end: String = "") : Double
    {
        while (true) {
            try {
                return readString(message, end).toDouble()
            }
            catch (ex: Throwable) {
                print(errorMessage + end)
            }
        }
    }
}

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{

}

