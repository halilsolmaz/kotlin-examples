/*-----------------------------------------------------------------------------------------------------
    Sınıf Çalışnası: Parametresi ile aldığı bir yazının büyük harfleri küçük, küçük harleri büyük harf yapılmış ve geri
    kalan karakteler aynı olacak şekilde yeni bir yazıya geri dönen changeCase isimli fonksiyonu yazınız ve aşağıdaki
    kod ile test ediniz

    Not: Dizi gibi davranan sınıfların indices denilen bir property elemanları vardır. 0 ile length - 1
    aralığına döner.

    Not: Aşağıdaki 4 versiyon da hemen hemen aynı performanstadır.
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks
fun main() = runChangeCaseTest()

fun runChangeCaseTest()
{
    while (true) {
        print("Input text:")
        val s = readln()

        if (s == "quit")
            break

        var str = changeCaseV1(s)
        println("($str)")
        str = changeCaseV2(s)
        println("($str)")
        str = changeCaseV3(s)
        println("($str)")
        str = changeCaseV4(s)
        println("($str)")
    }
}
fun changeCaseV1(s: String) : String
{
    val sb = StringBuilder(s)

    for (i in s.indices)
        sb[i] = if (s[i].isUpperCase()) s[i].lowercaseChar() else s[i].uppercaseChar()

    return sb.toString()
}

fun changeCaseV2(s: String) : String
{
    val sb = StringBuilder(s)

    for (i in s.indices)
        sb[i] = when {s[i].isUpperCase() -> s[i].lowercaseChar() else -> s[i].uppercaseChar()}

    return sb.toString()
}

fun changeCaseV3(s: String) : String
{
    val sb = StringBuilder(s.length)

    for (c in s) // c artık bir Char türünden
        if (c.isUpperCase())
            sb.append(c.lowercaseChar())
        else
            sb.append(c.uppercaseChar())

    return sb.toString()
}

fun changeCaseV4(s: String) : String
{
    val sb = StringBuilder(s.length)

    for (c in s) // c artık bir Char türünden
        when {
            c.isUpperCase() -> sb.append(c.lowercaseChar())
            else -> sb.append(c.uppercaseChar())
        }

    return sb.toString()
}