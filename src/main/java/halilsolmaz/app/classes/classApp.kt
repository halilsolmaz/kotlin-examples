package halilsolmaz.app.classes

fun main()
{
    println("**************************************circle******************************************")
    circleExample()
    println("**************************************immutableComplex******************************************")
    immutableComplexExample()
    println("**************************************mutablePoint******************************************")
    mutablePointExample()
    println("**************************************point******************************************")
    pointExample()
    println("**************************************analyticalCircle1******************************************")
    analyticalCircleExample1()
    println("**************************************analyticalCircle2******************************************")
    analyticalCircleExample2()
    println("**************************************analyticalCircle3******************************************")
    analyticalCircleExample3()
}
fun circleExample()
{
    val  c = Circle(-3.4)

    println(c.area)
    println(c.circumference)
    println("------------------------------")

    c.radius = -4.4

    println(c.area)
    println(c.circumference)
    println("------------------------------")
}

fun immutableComplexExample() {
    val z = ImmutableComplex(3.4, 5.6)
    val zc = z.conjugate;

    println("|${z.real} + i.${z.imag}| = ${z.norm}")
    println("|${zc.real} + i.${zc.imag}| = ${zc.norm}")
}

fun mutablePointExample()
{
    val p = MutablePoint(100.0, 100.0)

    println("(${p.x}, ${p.y})")

    p.offset(20.0, -20.0)

    println("(${p.x}, ${p.y})")

    p.offset(30.0)

    println("(${p.x}, ${p.y})")
}

fun pointExample()
{
    val p = Point(100.0, 100.0)

    println("(${p.x}, ${p.y})")

}

fun analyticalCircleExample1()
{
    val ac = AnalyticalCircle()

    println("Radius:${ac.radius}")
    println("Area:${ac.area}")
    println("Circumference:${ac.circumference}")
    println("Center:${ac.x}, ${ac.y}")

    ac.radius = -2.3
    ac.x = 200.0
    ac.y = 12.3

    println("Radius:${ac.radius}")
    println("Area:${ac.area}")
    println("Circumference:${ac.circumference}")
    println("Center:${ac.x}, ${ac.y}")
}

fun analyticalCircleExample2()
{
    val ac = AnalyticalCircle(-2.3, 23.5, 56.7)

    println("Radius:${ac.radius}")
    println("Area:${ac.area}")
    println("Circumference:${ac.circumference}")
    println("Center:${ac.x}, ${ac.y}")

    ac.radius = 2.3
    ac.x = 200.0
    ac.y = 12.3

    println("Radius:${ac.radius}")
    println("Area:${ac.area}")
    println("Circumference:${ac.circumference}")
    println("Center:${ac.x}, ${ac.y}")
}

fun analyticalCircleExample3()
{
    val ac1 = AnalyticalCircle(3.0, 100.0, 200.0)
    val ac2 = AnalyticalCircle(2.0, 97.0, 204.0)
    val centerDistance = ac1.centerDistance(ac2)

    println("Center distance:$centerDistance")
    println(if (ac1.isTangent(ac2)) "Teğet" else "Teğet değil")
}