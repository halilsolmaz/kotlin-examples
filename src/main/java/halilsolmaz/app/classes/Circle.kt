/*-----------------------------------------------------------------------------------------------------
    Circle Class
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.classes

import java.awt.geom.Area
import kotlin.math.PI
import kotlin.math.abs

private const val DELTA = 0.00001

open class Circle(radius: Double = 0.0) {
    var radius: Double = abs(radius)
        set(value) {
            field = abs(value)
        }

    val area : Double
        get() = PI * radius * radius

    val circumference : Double
        get() = 2 * PI * radius

    fun copy() = Circle(radius)
    operator fun component1() = radius
    operator fun component2() = area
    operator fun component3() = circumference
    override fun hashCode() = radius.hashCode()
    override operator fun equals(other: Any?) = other is Circle && abs(radius - other.radius) < DELTA;
    override fun toString() = "Radius = %.2f, Area =  %.2f, Circumference = %.2f".format(radius, area, circumference)
}

/* Yaklaşık Java karşılığı
    public class Circle {
        private double m_r;

        public Circle()
        {}

        public Circle(double r)
        {
            setRadius(r);
        }

        public double getRadius()
        {
            return m_r;
        }

        public void setRadius(double r)
        {
            m_r = abs(r);
        }

        public double getArea()
        {
            return PI * m_r * m_r;
        }

        public double getCircumference()
        {
            return 2 * PI * m_r;
        }
    }
 */