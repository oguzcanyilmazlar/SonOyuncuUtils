@echo off
python "scripts/items generator/generator.py" scripts/items.json Plugin/src/main/java/me/acablade/sonoyuncuutils/plugin/items/SonOyuncuItems.java
python "scripts/material generator/generator.py" scripts/items.json SpigotAgent/src/main/resources/Material.java
python "scripts/commons generator/generator.py" scripts/items.json Commons/src/main/java/me/acablade/Commons.java
javac -cp "scripts/spigot-1.8.8.jar" SpigotAgent/src/main/resources/Material.java
