@echo off
python generator.py ../items.json
javac -cp "../spigot-1.8.8.jar" Material.java