/*-----------------------------------------------------------------------------------------------------
    Point Class
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.classes

import kotlin.math.abs
import kotlin.math.sqrt

private const val DELTA = 0.00001

class Point(val x: Double = 0.0, val y: Double = 0.0) {
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble()) //optional
    fun distance(a: Double = 0.0, b: Double = 0.0) = sqrt((x - a) * (x - a) + (y - b) * (y - b))
    fun distance(other: Point) = distance(other.x, other.y)

    override fun toString() = "(%.2f, %.2f)".format(x, y)

    override operator fun equals(other: Any?) = other is Point && abs(x - other.x) < DELTA && abs(y - other.y) < DELTA
}