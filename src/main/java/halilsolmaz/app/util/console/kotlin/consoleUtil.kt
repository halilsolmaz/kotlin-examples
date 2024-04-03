package halilsolmaz.app.util.console.kotlin

fun readInt(prompt: String = "", errMessage: String = "") : Int
{
    print(prompt)
    return readln().toInt()
}

fun readDouble(prompt: String = "", errMessage: String = "") : Double
{
    print(prompt)
    return readln().toDouble()
}

fun readString(prompt: String = "", errMessage: String = "") : String
{
    print(prompt)
    return readln().toString()
}