/*-----------------------------------------------------------------------------------------------------
    Bir paranın yazı gelme olasığını yaklaşık olarak hesaplayan basit bir simülasyon programını
    yazınız
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks

import kotlin.random.Random

fun main() = runCoinSimulationApp()

fun runCoinSimulationApp() {

    while (true) {
        println("Kaç kere atılsın?")
        val count = readln().toInt()

        if (count <= 0)
            break

        println("yazı gelme olasılığı: ${calculateSimulation(count)}")
    }
}

fun calculateSimulation (count: Int) : Double
{
    var heads = 0
    for (i in 0 until count) {
        if (Random.nextBoolean())
            heads++
    }

    return heads.toDouble() / count
}