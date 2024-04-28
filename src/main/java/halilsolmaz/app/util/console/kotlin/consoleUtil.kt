package halilsolmaz.app.util.console.kotlin

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
fun readString(prompt: String = "", errMessage: String = "") : String
{
    print(prompt)
    return readln().toString()
}