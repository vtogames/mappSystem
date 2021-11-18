package mapp.interpreter;

import java.util.HashSet;

import mapp.types.MappImage;

public class MappFileAct {

    public static String mapp_file_version = "1", act_path;
    public static int act_x, act_y, act_width, act_height, act_line;
    public static MappImage act_main_image, act_image;
    public static HashSet<MappImage> act_imageSet;
    public static boolean act_stop;
    public static double act_interpreter_version;
    
}
