

public class App {
    public static void main(String[] args) throws Exception {
        MathImage img = new MathImage(1000, 1000);

        img.mosaic(1, 10, 10, false);
        //img.rectangularAreaColorBlur(1, 6, 4, false);
        // img.overlayNoiseImageMultiply(1);
        //img.cosColorAbsolute(1, false);
        //img.sinColorAbsolute(1, false);
        
    }
}
