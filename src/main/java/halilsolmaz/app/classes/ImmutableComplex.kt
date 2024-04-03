/*-----------------------------------------------------------------------------------------------------
    Immutable Complex Class

    Bir karmaşık sayıyı temsil eden Complex isimli immutable sınıfı yazınız.
    Sınıf karmaşık sayının 0 + 0i sayısına uzaklığı olan Norm bilgisini de verecektir
    |a + bi| = sqrt(a * a + b * b)
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.classes

class ImmutableComplex (val real: Double = 0.0, val imag: Double = 0.0) {
    val norm: Double
        get() = kotlin.math.sqrt(real * real + imag * imag)

    val length: Double
        get() = norm

    val conjugate: ImmutableComplex
        get() = ImmutableComplex(real, -imag)

    //val conjugate: ImmutableComplex = ImmutableComplex(real, -imag) // Error, sonsuz döngü

    override fun toString() = "(%.2f, %.2f)".format(real, imag)
}