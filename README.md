# ÖZENLİ – Android başlangıç projesi

Bu proje Kotlin + Jetpack Compose ile hazırlanmış bir Android ana ekran prototipidir.

## GitHub üzerinden APK oluşturma

1. Bu klasörün içeriğini GitHub deposunun ana dizinine yükleyin.
2. GitHub deposunda **Actions** sekmesini açın.
3. **Build ÖZENLİ APK** iş akışını seçin.
4. **Run workflow** düğmesine basın (veya `main` dalına yükleme yapın).
5. İşlem tamamlanınca çalıştırmanın altındaki **Artifacts** bölümünden
   `OZENLI-debug-APK` dosyasını indirin.
6. ZIP içindeki `app-debug.apk` dosyasını Android telefona aktarın ve kurun.

## Yerel derleme

- JDK 17
- Android SDK Platform 35
- Gradle 8.7

Komut:
`gradle :app:assembleDebug`

APK çıktısı:
`app/build/outputs/apk/debug/app-debug.apk`

## Önemli: mevcut sürümün kapsamı

Bu sürüm şu an ana ekran prototipidir. Özellik kartları tıklandığında bilgi penceresi açar;
kartların arkasındaki gerçek işlevler, kullanıcı verisi saklama, hesaplamalar, bildirimler
ve çevrim içi özellikler henüz geliştirilmemiştir. Bu nedenle APK üretmek, uygulamanın
tüm özelliklerinin tamamlandığı anlamına gelmez.
