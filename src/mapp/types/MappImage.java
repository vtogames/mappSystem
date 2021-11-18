package mapp.types;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapp.MappMain;

public class MappImage {

    private BufferedImage image;
    private String name;
    private int xvalue, yvalue;

    

    public MappImage(BufferedImage image, String name) {
        this.image = image;
        this.name = name;
    }

    public MappImage() {
    }

    public int getXvalue() {
        return xvalue;
    }

    public void setXvalue(int xvalue) {
        this.xvalue = xvalue;
    }

    public int getYvalue() {
        return yvalue;
    }

    public void setYvalue(int yvalue) {
        this.yvalue = yvalue;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MappImage [name=" + name + ", width=" + image.getWidth() + ", height=" + image.getHeight() + "]";
    }

    public static BufferedImage fromPath(String path) {
        try {
            return ImageIO.read(MappMain.getMain().getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MappImage other = (MappImage) obj;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    
    
}
