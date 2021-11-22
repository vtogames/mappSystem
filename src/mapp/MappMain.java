package mapp;
import java.io.File;

import mapp.interpreter.MappInterpreter;

public class MappMain {

    private static MappMain main = new MappMain();
    public static String path;

    public static void main(String[] args) {
        startMappSystem();
    }

    public static void startMappSystem() {

        path = new File(".").getAbsolutePath();
        path = path.substring(0, path.length() - 2);

        MappInterpreter.addDefaultCommands();

    }

    public static MappMain getMain() {
        return main;
    }

    public static void setMain(MappMain main) {
        MappMain.main = main;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        MappMain.path = path;
    }

    
}
