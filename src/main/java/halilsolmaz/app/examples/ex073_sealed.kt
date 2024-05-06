/*-----------------------------------------------------------------------------------------------------
    1.
    sealed bir sınıf default olarak abstract bildirilir. Dolayısıyla bu sınıf türünden nesne yaratılamaz

    2.
    sealed bir sınıftan türemiş bir sınıf aynı pakette bildirilmelidir. Bu durumda sealed olarak soyutlanmış
    bir sınıftan DOĞRUDAN (direct) türetilmiş tüm sınıflar da aynı pakette olmalıdır.
    (Amaç absraction'u tek bir paket altında toplamaktır).

    Aşağıdaki örnekte MySealedValue sealed olmadığından ondan türemiş sınıflar aynı pakette olmak zorunda değildir


-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.tuple.kotlin.MySealedValue

fun main()
{

}

/*

fun one073()
{
     val sv = SealedValue(20) //error
}

*/


/*********************************************************************************************************************/

/*

class MySealedValue(var a: Int) : SealedValue<Int>(a) { // Error
    //...
}

*/

/*********************************************************************************************************************/

class YourSealedValue : MySealedValue() {
    //..
}


