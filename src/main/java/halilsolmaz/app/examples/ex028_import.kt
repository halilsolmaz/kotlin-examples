/*-----------------------------------------------------------------------------------------------------
    1.
    Aşağıda anlatılan import bildirimlerinde kullanılan "yıldızlı import bildirimi" ve "yıldızsız impoprt bildirimi"
    terimleri sırasıyla "import on demand declaration" ve "import single type/name declaration" anlamında
    kullanılmaktadır. Türkçe karşılıkları tamamen Oğuz Karan tarafından uydurulmuştur.

    2.
    Yıldızsız import bildiriminde (import single type declaration) ilgili isme takma isim (alias) verilebilir.

    Not: Java da böyle bir özellik bulunmamaktadır.

    3.
    alias sayesinde farklı paketlerdeki aynı isimli metotları takma isim vererek kullanabiliriz.
    Ex:
        import test.foo
        import mest.foo as mFoo

    Not: Java da böyle bir durumda en az birini name qualified olarak çağırmak gerekirdi.

    4.
    Kotlin dosyaları için tipik IDE programlar (IntelliJ Idea, Android Studio, Eclipse vb.) Java dosyalarında
    olduğu gibi hangi paket içerisinde bulunuyorsa o dizinde bulunur zorunluluğunu uygulamaz. Ancak Kotlin JVM kullanan
    programcılar genelde Java'daki gibi dosyaları konumlandırırlar
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

import halilsolmaz.app.util.console.kotlin.readInt as rInt

fun main()
{
    val a = rInt("Sayı giriniz")

    println(a)
}