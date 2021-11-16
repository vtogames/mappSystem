package mapp.interpreter;

import java.util.HashSet;

import mapp.file.MappReader;
import mapp.types.MappImage;

public class MappInterpreter {

    private static HashSet<MappCommand> commands = new HashSet<>();

    public static MappImage[] fromPath(String path) {

        HashSet<MappImage> imageSet = new HashSet<>();
        MappImage act_image = null;

        String mappFile = MappReader.readFile(path, " ");

        String[] mapp0 = mappFile.split(" ");
        for(int i = 0; i < mapp0.length; i++) {
            String mapp1 = mapp0[i];
            String[] words = mapp1.split("=");
            for(MappCommand command : commands) {
                if(command.command().hashCode() == words[0].hashCode()) {
                    command.call(act_image, imageSet, words[1]);
                }
            }
        }
        return imageSet.toArray(new MappImage[imageSet.size()]);
    }

    public static void addDefaultCommands() {
        commands.add(new MappCommand() {
            @Override
            public String command() {
                return "<";
            }
            @Override
            public void call(MappImage act_image, HashSet<MappImage> imageSet, String suffix) {
                MappFileAct.act_name = suffix;
            }
        });
    }

}
