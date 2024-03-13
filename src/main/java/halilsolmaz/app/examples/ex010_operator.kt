/*-----------------------------------------------------------------------------------------------------
    1.
    Operator && and || ;
    A || B && C ---->  A || (B && C)   Not: A çağrılır, B False ise C çağrılmaz
    A && B || C ---->  (A && B) || C   Not: A False ise B çağrılmaz, C çağrılır.
    Matematikte önce parantez içerisinde ki and işlemi yapılsa da
    Java ve Kotlin gibi diller önce her zaman soldan başlanır.

    2.
    Atama operatörü Kotlin'de bir ifade biçiminde ele alınmaz. Dolayısıyla aşağıdaki işlem geçersizdir.
    Atama operatörü bir değer üretmez.

    Not: Java da ve benzeri diğer dillerde böyle bir kullanıma izin verilmiştir.
    a = b = c  - > Kotlinde geçersiz, Java da geçerli

    3.
    İşlemli atama operatörleri işlem önceliğinden dolayı daha yalın kodların yazılmasını sağlayabilir.

-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{

}