/*-----------------------------------------------------------------------------------------------------
    Immutable Complex Class

    Bir karmaşık sayıyı temsil eden Complex isimli immutable sınıfı yazınız.
    Sınıf karmaşık sayının 0 + 0i sayısına uzaklığı olan Norm bilgisini de verecektir
    |a + bi| = sqrt(a * a + b * b)
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.classes
fun main()
{
    val z = Complex(3.4, 5.6)
    val zc = z.conjugate;

    println("|${z.real} + i.${z.imag}| = ${z.norm}")
    println("|${zc.real} + i.${zc.imag}| = ${zc.norm}")
}

class Complex (val real: Double = 0.0, val imag: Double = 0.0) {
    val norm: Double
        get() = kotlin.math.sqrt(real * real + imag * imag)

    val length: Double
        get() = norm

    val conjugate: Complex
        get() = Complex(real, -imag)

    //val conjugate: Complex = Complex(real, -imag) // Error, sonsuz döngü
}