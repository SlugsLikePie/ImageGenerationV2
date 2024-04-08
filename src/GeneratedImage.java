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
    
    // Blurs
    private int rectangularAreaColorAverage(int x, int y, int xSize, int ySize, String color) {
        int sum = 0;
        int numPx = 0;
        for (int xI = x - xSize; xI <= x + xSize; xI++)
        for (int yI = y - ySize; yI <= y + ySize; yI++) {
            if (xI > 0 && xI < img.getWidth() && yI > 0 && yI < img.getHeight()) {
                Color col = new Color(img.getRGB(xI, yI));
                switch (color) {
                    case "Red":
                        sum += col.getRed();
                        break;

                    case "Green":
                        sum += col.getGreen();
                        break;

                    case "Blue":
                        sum += col.getBlue();
                        break;
                
                    default:
                        sum += col.getAlpha();
                        break;
                }
                numPx++;
            }
        }

        int average = sum / numPx;

        return average;
    }

    public void rectangularAreaColorBlur(int iterations, int xSize, int ySize, Boolean outputIndividual) throws Exception {
        for (int i = 0; i < iterations; i++)
        for (int x = 0; x < img.getWidth(); x++)
        for (int y = 0; y < img.getHeight(); y++) {
            img.setRGB(
                x, y, new Color(
                rectangularAreaColorAverage(x, y, xSize, ySize, "Red"), 
                rectangularAreaColorAverage(x, y, xSize, ySize, "Green"), 
                rectangularAreaColorAverage(x, y, xSize, ySize, "Blue")
                ).getRGB()
            );
        }

        if (outputIndividual) {
            writeFile("BlurredImage");
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
