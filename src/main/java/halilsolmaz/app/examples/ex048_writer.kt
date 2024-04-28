package halilsolmaz.app.examples

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.nio.charset.StandardCharsets

fun main() = runWriterApplication()

fun runWriterApplication()
{
    val fileName = "cities.txt"

    try {
        BufferedWriter(FileWriter(fileName, StandardCharsets.UTF_8, true)).use {
            while (true) {
                print("Input text:")
                val str = readln()

                if ("quit" == str)
                    break

                it.write("$str\r\n")
            }
            it.flush()
        }
    }
    catch (ignore: IOException) {
        println("IO Problem occurs")
    }
    catch (ignore: Throwable) {
        println("Problem occurs")
    }
}