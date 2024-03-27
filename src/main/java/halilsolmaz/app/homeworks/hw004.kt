/*-----------------------------------------------------------------------------------------------------
    Aşağıdaki sonsuz döngünün nedeni:
        -


    val nextNumber: Number
        get() = Number(value + 1)
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks
fun main() {
    val number = Number(1)
    println(number.value)
}

class Number(val value: Int) {
    init {
        println("Number object created with value: $value")
    }

    val nextNumber: Number = Number(value + 1)


}