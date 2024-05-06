package halilsolmaz.app.util.tuple.kotlin

import java.io.Serializable

data class Quadruple<out T1, out T2, out T3, out T4>(val first: T1, val second: T2, val third: T3, val forth: T4) : Serializable {
    override fun toString() = "($first, $second, $third, $forth)"
}