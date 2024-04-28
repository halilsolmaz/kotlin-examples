package halilsolmaz.app.examples

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.nio.charset.StandardCharsets

fun main() = runReaderApplication()

fun runReaderApplication()
{
    val fileName = "cities.txt"

    try {
        BufferedReader(FileReader(fileName, StandardCharsets.UTF_8)).use {
            while (true) {
                val str = it.readLine() ?: break

                println(str)
            }
        }
    }
    catch (ignore: IOException) {
        println("IO Problem occurs")
    }
    catch (ignore: Throwable) {
        println("Problem occurs")
    }
}
