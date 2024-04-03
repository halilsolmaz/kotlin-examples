/*-----------------------------------------------------------------------------------------------------
    Point Class
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.classes

class MutablePoint(var x: Double = 0.0, var y: Double = 0.0) {
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble()) //optional
    fun distance(a: Double = 0.0, b: Double = 0.0) = kotlin.math.sqrt((x - a) * (x - a) + (y - b) * (y - b))
    fun distance(other: MutablePoint) = distance(other.x, other.y)

    fun offset(dx: Double, dy: Double = dx)
    {
        x += dx
        y += dy
    }

    override fun toString() = "(%.2f, %.2f)".format(x, y)
}