/*-----------------------------------------------------------------------------------------------------
    Bazı println kullanımları
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples
fun main() {
    val a = 10
    val b = 3.4

    println("a = $a, b = $b")
    println("a = ${a + 1}, b = ${b + 1}")
    println("a = $a, b = $b, a + b = ${a + b}")
    println("a = %d, b = %f".format(a, b))
}