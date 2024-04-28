/*-----------------------------------------------------------------------------------------------------

    1.
    Aşağıdaki örnekte FilePath isimli bir yol ifadesi üzerinde işlem yapan basit bir sınıf yazılmıştır. Detayları
    gözardı etmek koşuluyla div operatör fonksiyonuna yüklenen göreve dikkat ediniz.

    2.
    Aşağıdaki örneği inceleyiniz
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{
    println("-------------------------------one----------------------------------")
    one044()
    println("-------------------------------two-----------------------------------")
    two044()
}

fun one044()
{
    var filePath1 = FilePath("/home/halil/study")
    var filePath2 = FilePath("/home/halil/study/")
    filePath1 /= "names.txt"
    filePath2 += "names.txt"

    println(filePath1)
    println(filePath2)
}

class FilePath(var path: String) {
    operator fun div(filePath: FilePath) = this / filePath.toString()
    operator fun div(path: String) = FilePath("${this.path}/$path")
    operator fun plus(path: String) = FilePath("${this.path}$path")
    operator fun plus(filePath: FilePath) = this + filePath.toString()
    override fun toString() = path
    //...
}

/***********************************************************************************************************/

fun two044()
{
    var vec = Vector3(2.4F, 6.7F, 0F)
    println(vec)
    vec *=  3F
    println(vec)
}

data class Vector3(val x: Float, val y: Float, val z: Float) {
    operator fun times(value: Float) = Vector3(x * value, y * value, z * value)
    //...
}