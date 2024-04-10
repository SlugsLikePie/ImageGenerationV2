import java.awt.Color;
import java.awt.image.BufferedImage;

public class NoiseImage extends GeneratedImage {
    public NoiseImage() throws Exception {
        super();
        newNoiseImage();
    }
    public NoiseImage(int sizeX, int sizeY) throws Exception {
        super(sizeX, sizeY);
        newNoiseImage();
    }

    public NoiseImage(int sizeX, int sizeY, int type) throws Exception {
        super(sizeX, sizeY, type);
        newNoiseImage();
    }

    public NoiseImage(String path) throws Exception {
        super(path);
    }

    public void newNoiseImage() throws Exception {
        for (int x = 0; x < img.getWidth(); x++)
        for (int y = 0; y < img.getHeight(); y++) {
            img.setRGB(
                x, y, new Color(
                (int)(Math.random() * 256),
                (int)(Math.random() * 256),
                (int)(Math.random() * 256)
                ).getRGB()
            );
        }
        writeFile();
    }

    public void overlayNoiseImageMultiply(double iterations) throws Exception {
        for (int i = 0; i < iterations; i++)
        for (int x = 0; x < img.getWidth(); x++)
        for (int y = 0; y < img.getHeight(); y++) {
            Color o = new Color(img.getRGB(x, y));
            img.setRGB(
                x, y, new Color(
                (int)(o.getRed() * (Math.random())),
                (int)(o.getGreen() * (Math.random())),
                (int)(o.getBlue() * (Math.random()))
                ).getRGB()
            );
        }
        writeFile();
    }
}