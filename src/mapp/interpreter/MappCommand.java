package mapp.interpreter;

import mapp.exceptions.MappSintaxException;

public abstract class MappCommand {

    public abstract String command();

    public abstract void call(String suffix) throws MappSintaxException;
    
}
