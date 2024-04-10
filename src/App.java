

public class App {
    public static void main(String[] args) throws Exception {
        MathImage img = new MathImage(100, 100);

        img.mosaic(200, 25, 25, false);
        // img.overlayNoiseImageMultiply(1);
        // img.cosColorAbsolute(1, false);
        // img.sinColorAbsolute(1, false);
        // img.rectangularAreaColorBlur(1, 6, 4, false);
    }
}
