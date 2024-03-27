/*-----------------------------------------------------------------------------------------------------
    Point Class
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.classes
fun main()
{
    val p = Point(100.0, 100.0)

    println("(${p.x}, ${p.y})")

    p.offset(20.0, -20.0)

    println("(${p.x}, ${p.y})")

    p.offset(30.0)

    println("(${p.x}, ${p.y})")

}

class Point(var x: Double = 0.0, var y: Double = 0.0) {
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble()) //optional
    fun distance(a: Double = 0.0, b: Double = 0.0) = kotlin.math.sqrt((x - a) * (x - a) + (y - b) * (y - b))
    fun distance(other: Point) = distance(other.x, other.y)

    fun offset(dx: Double, dy: Double = dx)
    {
        x += dx
        y += dy
    }
}