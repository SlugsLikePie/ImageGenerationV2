import java.awt.Color;

public class MathImage extends NoiseImage {
    public MathImage() throws Exception {
        super();
    }
    public MathImage(int sizeX, int sizeY) throws Exception {
        super(sizeX, sizeY);
    }

    public MathImage(int sizeX, int sizeY, int type) throws Exception {
        super(sizeX, sizeY, type);
    }

    public MathImage(String path) throws Exception {
        super(path);
    }

    public void sinColor(int iterations, Boolean outputIndividual) throws Exception {
        for (int i = 0; i < iterations; i++)
        for (int x = 0; x < img.getWidth(); x++)
        for (int y = 0; y < img.getHeight(); y++) {
            Color o = new Color(img.getRGB(x, y));

            img.setRGB(
                x, y, new Color(
                Math.abs((int)(Math.sin((((double)o.getRed()) / 255) * (2 * Math.PI)) * 255)),
                Math.abs((int)(Math.sin((((double)o.getGreen()) / 255) * (2 * Math.PI)) * 255)),
                Math.abs((int)(Math.sin((((double)o.getBlue()) / 255) * (2 * Math.PI)) * 255))
                ).getRGB()
            );
        }

        if (outputIndividual) {
            writeFile("SineImage");
        } else {
            writeFile();
        }
    }

    public void sinColorNoConversion(int iterations, Boolean outputIndividual) throws Exception {
        for (int i = 0; i < iterations; i++)
        for (int x = 0; x < img.getWidth(); x++)
        for (int y = 0; y < img.getHeight(); y++) {
            Color o = new Color(img.getRGB(x, y));

            img.setRGB(
                x, y, new Color(
                Math.abs((int)(Math.sin(o.getRed()) * 255)),
                Math.abs((int)(Math.sin(o.getGreen()) * 255)),
                Math.abs((int)(Math.sin(o.getBlue()) * 255))
                ).getRGB()
            );
        }

        if (outputIndividual) {
            writeFile("SineImage");
        } else {
            writeFile();
        }
    }

    public void cosColor(int iterations, Boolean outputIndividual) throws Exception {
        for (int i = 0; i < iterations; i++)
        for (int x = 0; x < img.getWidth(); x++)
        for (int y = 0; y < img.getHeight(); y++) {
            Color o = new Color(img.getRGB(x, y));

            img.setRGB(
                x, y, new Color(
                Math.abs((int)(Math.cos((((double)o.getRed()) / 255) * (Math.PI)) * 255)),
                Math.abs((int)(Math.cos((((double)o.getGreen()) / 255) * (Math.PI)) * 255)),
                Math.abs((int)(Math.cos((((double)o.getBlue()) / 255) * (Math.PI)) * 255))
                ).getRGB()
            );
        }

        if (outputIndividual) {
            writeFile("CosineImage");
        } else {
            writeFile();
        }
    }

    public void cosColorNoConversion(int iterations, Boolean outputIndividual) throws Exception {
        for (int i = 0; i < iterations; i++)
        for (int x = 0; x < img.getWidth(); x++)
        for (int y = 0; y < img.getHeight(); y++) {
            Color o = new Color(img.getRGB(x, y));

            img.setRGB(
                x, y, new Color(
                Math.abs((int)(Math.sin(o.getRed()) * 255)),
                Math.abs((int)(Math.sin(o.getGreen()) * 255)),
                Math.abs((int)(Math.sin(o.getBlue()) * 255))
                ).getRGB()
            );
        }

        if (outputIndividual) {
            writeFile("CosineImage");
        } else {
            writeFile();
        }
    }
}
