package me.acablade.sonoyuncuutils.plugin;

public class PluginNotEnabledException extends RuntimeException{

    public PluginNotEnabledException(String name){
        super(name);
    }

}
