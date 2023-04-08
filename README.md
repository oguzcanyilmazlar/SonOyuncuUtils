### SonOyuncuUtils

Bloklar tam ekli değil.

#### Eklenecekler:
- Blok yönleri
- Blok varyantları
- Paketler

#### Nasıl Kurulur
mvn clean install(maven indirili olması gerek) ile buildledikten sonra SpigotAgent'ın jarını java agent olarak spigota ayarlayın. Plugin'in jarını da kendi plugins klasörüne atabilirsiniz

#### İtem Nasıl Eklenir
scripts klasörü içerisinde items.json var, ona dilediğiniz gibi ekledikten sonra ana klasördeki generate.bat'ı çalıştırın.
sonra "Nasıl Kurulur"da anlattığım gibi build alabilirsiniz.