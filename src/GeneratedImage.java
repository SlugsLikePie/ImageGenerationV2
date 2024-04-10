import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GeneratedImage {
    public BufferedImage img;

    // Constructors
    public GeneratedImage() {
        img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
    }
    public GeneratedImage(int sizeX, int sizeY) {
        img = new BufferedImage(sizeX, sizeY, BufferedImage.TYPE_INT_ARGB);
    }

    public GeneratedImage(int sizeX, int sizeY, int type) {
        img = new BufferedImage(sizeX, sizeY, type);
    }

    public GeneratedImage(String path) {
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
        }
    }
    
    // Pixel Average
    private int rectangularAreaColorAverage(int x, int y, int xSize, int ySize, int color) {
        int sum = 0;
        int numPx = 0;
        for (int xI = x - xSize; xI <= x + xSize; xI++)
        for (int yI = y - ySize; yI <= y + ySize; yI++) {
            if (xI >= 0 && xI < img.getWidth() && yI >= 0 && yI < img.getHeight()) {
                Color col = new Color(img.getRGB(xI, yI));
                switch (color) {
                    case 1:
                        sum += col.getRed();
                        break;

                    case 2:
                        sum += col.getGreen();
                        break;

                    case 3:
                        sum += col.getBlue();
                        break;
                
                    default:
                        sum += col.getAlpha();
                        break;
                }
                numPx++;
            }
        }
        return sum / numPx;
    }

    // Blur
    public void rectangularAreaColorBlur(int iterations, int xSize, int ySize, Boolean outputIndividual) throws Exception {
        for (int i = 0; i < iterations; i++)
        for (int x = 0; x < img.getWidth(); x++)
        for (int y = 0; y < img.getHeight(); y++) {
            img.setRGB(
                x, y, new Color(
                rectangularAreaColorAverage(x, y, xSize, ySize, 1), 
                rectangularAreaColorAverage(x, y, xSize, ySize, 2), 
                rectangularAreaColorAverage(x, y, xSize, ySize, 3)
                ).getRGB()
            );
        }

        if (outputIndividual) {
            writeFile("BlurredImage");
        } else {
            writeFile();
        }
    }

    // Mosaic calculate
    private int mosaicCalculate(int x, int y, int xSize, int ySize, int color) {
        int sum = 0;
        int numPx = 0;
        for (int xI = x - xSize; xI <= x + xSize; xI++)
        for (int yI = y - ySize; yI <= y + ySize; yI++) {
            if (xI > 0 && xI < img.getWidth() && yI > 0 && yI < img.getHeight()) {
                Color col = new Color(img.getRGB(xI, yI));
                switch (color) {
                    case 1:
                        sum += col.getRed();
                        break;

                    case 2:
                        sum += col.getGreen();
                        break;

                    case 3:
                        sum += col.getBlue();
                        break;
                
                    default:
                        sum += col.getAlpha();
                        break;
                }
                numPx++;
                c++;
            }
        }
        return sum / numPx;
    }

    public static int c = 0;
    // Mosaic
    public void mosaic(int iterations, int xSize, int ySize, Boolean outputIndividual) throws Exception {
        for (int i = 0; i < iterations; i++)
        for (int x = xSize; x < img.getWidth(); x += 2 * xSize + 1)
        for (int y = ySize; y < img.getHeight(); y += 2 * ySize + 1) {
            Color o = new Color(
                mosaicCalculate(x, y, xSize, ySize, 1), 
                mosaicCalculate(x, y, xSize, ySize, 2), 
                mosaicCalculate(x, y, xSize, ySize, 3)
                );
            for (int xI = x - xSize; xI <= x + xSize; xI++)
            for (int yI = y - ySize; yI <= y + ySize; yI++) {
                if (xI >= 0 && xI < img.getWidth() && yI >= 0 && yI < img.getHeight()) {
                    img.setRGB(xI, yI, o.getRGB());
                    c++;
                }
            }
        }
        System.out.println(c);

        if (outputIndividual) {
            writeFile("MosaicImage");
        } else {
            writeFile();
        }
    }

    // Writes image to file
    public void writeFile() throws Exception {
        File f = new File("Output.png");
        ImageIO.write(img, "PNG", f);
        System.out.println("Finished");
    }

    public void writeFile(String name) throws Exception {
        File f = new File(name + ".png");
        ImageIO.write(img, "PNG", f);
        System.out.println("Finished");
    }
}
