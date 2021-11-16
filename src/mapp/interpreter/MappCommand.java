package mapp.interpreter;

import java.util.HashSet;

import mapp.types.MappImage;

public abstract class MappCommand {

    public abstract String command();

    public abstract void call(MappImage act_image, HashSet<MappImage> imageSet, String suffix);
    
}
