package mapp;
import java.io.File;

import mapp.interpreter.MappInterpreter;

public class MappMain {

    private static MappInterpreter mappInterpreter;
    public static String path;

    public static void main(String[] args) {
        startMappSystem();
    }

    public static void startMappSystem() {

        path = new File(".").getAbsolutePath();
        path = path.substring(0, path.length() - 2);

        mappInterpreter = new MappInterpreter();

        MappInterpreter.addDefaultCommands();

        MappInterpreter.fromPath("/mapp/test.txt");

    }

    public static MappInterpreter getMappInterpreter() {
        return mappInterpreter;
    }

    public static void setMappInterpreter(MappInterpreter mappInterpreter) {
        MappMain.mappInterpreter = mappInterpreter;
    }

}
