package halilsolmaz.app.util.tuple.kotlin

import java.io.Serializable

data class Value<out T>(val value: T) : Serializable {
    fun toList() : List<T> = listOf(value)
}