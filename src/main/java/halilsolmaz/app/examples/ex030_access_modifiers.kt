/*-----------------------------------------------------------------------------------------------------
    Kotlin'de erişim belirleyiciler iki kategoriye ayrılırlar:

    Global düzeyde erişim belirleyiciler:
    - Hiçbir şey yazmamak default erişimdir. public'dir
    - public: Bir global elemanın dosyası dışından da erişilebilmesi demektir
    - internal: Module düzeyinde erişimdir. İleride ele alınacak
    - private: Yalnızca kendi dosyası içerisinde erişilebilirdir

    Sınıf elemanlarının erişim belirleyicileri:
    - Hiçbir şey yazmamak default erişimdir. public'dir
    - public: Sınıf dışından da erişilebilirdir
    - internal: Modül düzeyinde erişimdir
    - protected: Yalnızca türemiş sınıflar erişebilir
    - private: Yalnızca kendi sınıfı içerisinde erişilebilir elemanlardır

    Kotlin'de Java'da ki gibi pakete özgü (package private) erişim belirleyiciler yoktur. Kotlin'de bu durum modül (module)
    düzetinde ele alınmıştır. Module kavramı ileride ele alınacaktır
-----------------------------------------------------------------------------------------------------*/

package halilsolmaz.app.examples

fun main()
{

}