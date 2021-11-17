package mapp.interpreter;

import java.util.HashSet;

import mapp.exceptions.MappSintaxException;
import mapp.file.MappReader;
import mapp.types.MappImage;

public class MappInterpreter {

    private static HashSet<MappCommand> commands = new HashSet<>();

    public static MappImage[] fromPath(String path) {

        HashSet<MappImage> imageSet = new HashSet<>();

        String mappFile = MappReader.readFile(path, " ");
        MappFileAct.act_line = 0;

        try {
            String[] mapp0 = mappFile.split(" ");
            for (int i = 0; i < mapp0.length; i++) {
                MappFileAct.act_line++;
                String mapp1 = mapp0[i];
                String[] words = mapp1.split("=");
                for (MappCommand command : commands) {
                    if (command.command().hashCode() == words[0].hashCode()) {
                        try {
                            if (words.length > 1) {
                                words[1] = words[1].replace("\\s", " ");
                                command.call(words[1]);
                            } else {
                                command.call(null);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception ignore) {
        }
        return imageSet.toArray(new MappImage[imageSet.size()]);
    }

    public static void addDefaultCommands() {

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return ".mappversion";
            }

            @Override
            public void call(String suffix) throws MappSintaxException {
                if (suffix == null) {
                    throw new MappSintaxException(command() + " suffix can't be null!");
                }
                MappFileAct.mapp_file_version = suffix;
            }
        });

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return "path";
            }

            @Override
            public void call(String suffix) throws MappSintaxException {
                if (suffix == null) {
                    throw new MappSintaxException(command() + " suffix can't be null!");
                }
                if (suffix.charAt(0) != '/') {
                    suffix = "/" + suffix;
                }
                MappFileAct.act_imageSet = new HashSet<>();
                MappFileAct.act_main_image = new MappImage();
                try {
                    MappFileAct.act_main_image.setImage(MappImage.fromPath(suffix));
                } catch (Exception e) {
                    System.out.println(suffix);
                    throw new MappSintaxException(e.getMessage());
                }
            }
        });

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return "<";
            }

            @Override
            public void call(String suffix) {
                MappFileAct.act_image = new MappImage();
                MappFileAct.act_image.setName(suffix);
            }
        });

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return ">";
            }

            @Override
            public void call(String suffix) {
                if (MappFileAct.act_width == 0) {
                    MappFileAct.act_width = MappFileAct.act_main_image.getImage().getWidth() - MappFileAct.act_x;
                }
                if (MappFileAct.act_height == 0) {
                    MappFileAct.act_height = MappFileAct.act_main_image.getImage().getHeight() - MappFileAct.act_y;
                }
                MappFileAct.act_image.setImage(MappFileAct.act_main_image.getImage().getSubimage(MappFileAct.act_x,
                        MappFileAct.act_y, MappFileAct.act_width, MappFileAct.act_height));
                MappFileAct.act_imageSet.add(MappFileAct.act_image);
                System.out.println(MappFileAct.act_imageSet);
            }
        });

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return "x";
            }

            @Override
            public void call(String suffix) {
                MappFileAct.act_x = Integer.parseInt(suffix);
            }
        });

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return "y";
            }

            @Override
            public void call(String suffix) {
                MappFileAct.act_y = Integer.parseInt(suffix);
            }
        });

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return "width";
            }

            @Override
            public void call(String suffix) {
                MappFileAct.act_width = Integer.parseInt(suffix);
            }
        });

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return "height";
            }

            @Override
            public void call(String suffix) {
                MappFileAct.act_height = Integer.parseInt(suffix);
            }
        });

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return "pathsame";
            }

            @Override
            public void call(String suffix) throws MappSintaxException {
                if (suffix == null) {
                    throw new MappSintaxException(command() + " suffix can't be null!");
                }
                if (suffix.charAt(0) != '/') {
                    suffix = "/" + suffix;
                }
                try {
                    MappFileAct.act_main_image.setImage(MappImage.fromPath(suffix));
                } catch (Exception e) {
                    System.out.println(suffix);
                    throw new MappSintaxException(e.getMessage());
                }
            }
        });

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return "newl";
            }

            @Override
            public void call(String suffix) throws MappSintaxException {
                if (suffix == null) {
                    throw new MappSintaxException(command() + " suffix can't be null!");
                }
                MappFileAct.act_imageSet = new HashSet<>();
            }
        });

        commands.add(new MappCommand() {
            @Override
            public String command() {
                return "prints";
            }

            @Override
            public void call(String suffix) {
                System.out.println(suffix);
            }
        });
    }

}
