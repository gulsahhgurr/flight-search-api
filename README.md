
🧱 Proje Yapısı
flight-search-api/
│
├── flight-common
│   └── Ortak model, DTO ve yardımcı sınıflar
│
├── flight-provider-a
│   └── Provider A uçuş servisi (mock/dummy veri)
│
├── flight-provider-b
│   └── Provider B uçuş servisi (mock/dummy veri)
│
├── flight-service
│   └── Provider A ve B’den gelen sonuçları birleştiren ana servis
│
├── http
│   └── Örnek HTTP request dosyaları (IntelliJ HTTP Client için)
│
└── pom.xml
⚙️ Kullanılan Teknolojiler
Java 17
Spring Boot
Maven
Multi-module mimari
RESTful servisler
▶️ Çalıştırma
1️⃣ Projeyi build et
Proje kök dizininde:

mvn clean install
2️⃣ Servisleri çalıştır
Her modül ayrı bir Spring Boot uygulamasıdır ve ayrı ayrı çalıştırılmalıdır.

IntelliJ ile
Her modülde ilgili *Application sınıfını Run et.

Maven ile
Her modül için ayrı ayrı:

mvn spring-boot:run
Örnek:

cd flight-provider-a
mvn spring-boot:run
🧩 Varsayılan Portlar
Servis	Port
Provider A	8080
Provider B	8081
Flight Service	8082
✈️ Ne Yapar?
Provider A & Provider B
Uçuş arama isteği alır
Mock / örnek uçuş listesi döner
Flight Service
Provider A ve B servislerini çağırır
Gelen uçuşları birleştirir
Case gereksinimine göre gruplayıp en ucuz uçuşu seçebilir
🧪 HTTP İstekleri
http/ klasörü altında örnek request dosyaları bulunur. IntelliJ HTTP Client ile doğrudan çalıştırılabilir.

📝 Notlar
Ortak sınıflar flight-common modülünde tutulur
Modüller arası bağımlılık Maven üzerinden yönetilir
Proje demo / case amaçlıdır
