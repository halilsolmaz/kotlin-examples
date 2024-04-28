package halilsolmaz.app.classes.random

import halilsolmaz.app.classes.ImmutableComplex
import halilsolmaz.app.classes.MutableComplex
import kotlin.random.Random

fun Random.nextComplex(min: Double, bound: Double) = ImmutableComplex(this.nextDouble(min, bound), this.nextDouble(min, bound))
fun Random.nextComplex(min: Int, bound: Int) = ImmutableComplex(this.nextInt(min, bound).toDouble(), this.nextInt(min, bound).toDouble())

fun Random.nextMutableComplex(min: Double, bound: Double) = MutableComplex(this.nextDouble(min, bound), this.nextDouble(min, bound))
fun Random.nextMutableComplex(min: Int, bound: Int) = MutableComplex(this.nextInt(min, bound).toDouble(), this.nextInt(min, bound).toDouble())