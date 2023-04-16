### SonOyuncuUtils

#### Roadmap:
- Hologramlar
- Tüm Bloklar (fonksiyonel olarak değil)

#### Nasıl Kurulur
- [BuildTools](https://www.spigotmc.org/wiki/buildtools/#running-buildtools) ile 1.8.8 sürümünü kurun
- mvn clean install(maven indirili olması gerek) ile buildledikten sonra SpigotAgent'ın jarını java agent olarak spigota ayarlayın. Plugin'in jarını da kendi plugins klasörüne atabilirsiniz

#### İtem Nasıl Eklenir
scripts klasörü içerisinde items.json var, ona dilediğiniz gibi ekledikten sonra ana klasördeki generate.bat'ı çalıştırın.
sonra "Nasıl Kurulur"da anlattığım gibi build alabilirsiniz.