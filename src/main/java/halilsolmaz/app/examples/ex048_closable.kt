/*-----------------------------------------------------------------------------------------------------
    1.
    Bir dosyanın verileri (byte'ları) üzerinde işlem yapabilmek için işletim sisteminin çekirdeği düzeyinde bir takım
    işlemlerin yapılması gerekir. Bu işlemlere mantıksal olarak "dosyayı açmak" denir. Bir dosya ile ilgili işlemler
    bittiğinde yine çekirdek düzeyin yapılması gereken işlemler vardır. Buna da mantıksal olarak "dosyayı kapatmak"
    denir. JavaSE'de bulunan dosya işlemlerine yönelik (aslında IO işlemlerine yönelik) sınıfların bir çoğu
    Closeable arayüzünü destekler. Bu durumda programcının dosyayı kapatmak için close fonksiyonunu çağırması veya
    use fonbksiyonunu kullanması gerekir.

    Aşağıdaki birinci örnekte bir dosyaya klavyeden girilen yazılar satır satır
    eklenmektedir. İkinci örnekte ise dosyadan satır satır veriler okunmaktadır. Uygulamaya yönelik detaylar şu an
    önemsizdir. Yalnızca use fonksiyonunun kullanımına odaklanınız

    Not: Örnekleri test etmek için ilk önce yazma yapan programı çalıştırınız
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{

}