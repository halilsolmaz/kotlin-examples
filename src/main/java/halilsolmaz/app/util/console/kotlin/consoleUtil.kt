package halilsolmaz.app.util.console.kotlin

import java.math.BigDecimal

fun readInt(prompt: String = "", errMessage: String = "", end: String = "") : Int
{
    while (true) {
        try {
            print(prompt + end)
            return readln().toInt()
        }
        catch (ignore: NumberFormatException) {
            print(errMessage + end)
        }
    }
}

fun readLong(prompt: String = "", errMessage: String = "", end: String = "") : Long
{
    while (true) {
        try {
            print(prompt + end)
            return readln().toLong()
        }
        catch (ignore: NumberFormatException) {
            print(errMessage + end)
        }
    }
}

fun readShort(prompt: String = "", errMessage: String = "", end: String = "") : Short
{
    while (true) {
        try {
            print(prompt + end)
            return readln().toShort()
        }
        catch (ignore: NumberFormatException) {
            print(errMessage + end)
        }
    }
}

fun readByte(prompt: String = "", errMessage: String = "", end: String = "") : Byte
{
    while (true) {
        try {
            print(prompt + end)
            return readln().toByte()
        }
        catch (ignore: NumberFormatException) {
            print(errMessage + end)
        }
    }
}


fun readDouble(prompt: String = "", errMessage: String = "", end: String = "") : Double
{
    while (true) {
        try {
            print(prompt + end)
            return readln().toDouble()
        }
        catch (ignore: NumberFormatException) {
            print(errMessage + end)
        }
    }
}

fun readFloat(prompt: String = "", errMessage: String = "", end: String = "") : Float
{
    while (true) {
        try {
            print(prompt + end)
            return readln().toFloat()
        }
        catch (ignore: NumberFormatException) {
            print(errMessage + end)
        }
    }
}

fun readChar(prompt: String = "", errorMessage: String = "", end: String = "") : Char
{
    while (true) {
        val str = readString(prompt)

        if (str.length == 1)
            return str[0];

        print("$errorMessage $end")
    }
}

fun readString(prompt: String = "", errMessage: String = "") : String
{
    print(prompt)
    return readln().toString()
}

fun readBigDecimal(prompt: String, errMessage: String = "", end: String = "") : BigDecimal
{
    while (true) {
        try {
            print(prompt + end)

            return BigDecimal(readln())
        }
        catch (ignore: NumberFormatException) {
            print(errMessage + end)
        }
    }
}