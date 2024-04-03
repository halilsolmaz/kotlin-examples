/*-----------------------------------------------------------------------------------------------------
    İki zar atma deneyinde çift (ikisinin aynı olması) gelme olasılığını yaklaşık olarak hesaplayan
    basit simülasyon programını yazınız
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.homeworks
import kotlin.random.Random

fun main() = runSameDiceProbabilitySimulation()

fun runSameDiceProbabilitySimulation()
{
    while (true) {
        print("Atış sayısını giriniz:")
        val n = readln().toInt()

        if (n <= 0)
            break

        println("Yazı Gelme Olasılığı:${findSameDiceProbability(n)}")
    }

    println("Tekrar yapıyor musunuz?")
}

fun rollDice() = Random.nextInt(1, 7)

fun areSame() = rollDice() == rollDice()

fun findSameDiceProbability(n: Int) : Double
{
    var total = 0;

    for (i in 1..n)
        if (areSame())
            ++total


    return total.toDouble() / n
}