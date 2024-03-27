/*-----------------------------------------------------------------------------------------------------
    Circle Class
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.classes
fun main()
{
    val  c = Circle(-3.4)

    println(c.area)
    println(c.circumference)
    println("------------------------------")

    c.r = -4.4

    println(c.area)
    println(c.circumference)
    println("------------------------------")
}

class Circle(r: Double = 0.0) {
    var r: Double = kotlin.math.abs(r)
        set(value) {
            field = kotlin.math.abs(value)
        }

    val area : Double
        get() = Math.PI * r * r

    val circumference : Double
        get() = 2 * Math.PI * r
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