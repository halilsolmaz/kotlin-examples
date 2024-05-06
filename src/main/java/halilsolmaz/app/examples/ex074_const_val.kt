/*-----------------------------------------------------------------------------------------------------
    1.
     const val değişkenler:
    - Değeri derleme zamanında hesaplanan değişkenlerdir (constant folding)
    - const val değişkenlere sabit ifadesi verilmeldir. Aksi durumda error oluşur
    - Yerel olarak bildirilemez
    - Sınıfların veri elemanları olamazlar
    - Global olarak bildirilebilirler
    - object'lerin veri elemanı olabilir
    - Fonksiyon parametre değişkenleri val olarak bildirilemeyeceğinden const val de yapılamazlar
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

val e = 2.71
const val PI = 3.14
// const val E = e // Error, const val sadece sabit ifadeleri için kullanılır.
const val PI_SQUARE = PI * PI

/*

fun main()
{
    const val E = 2.71 // Error
}

fun foo(const val a: Int = 23) // Error
{
    //...
}

class Sample074 {
    const val E = 2.71 // Error
}
*/

object Mample074 {
    const val E = 2.71
}