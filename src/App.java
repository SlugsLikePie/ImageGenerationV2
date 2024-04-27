

public class App {
    public static void main(String[] args) throws Exception {
        MathImage img = new MathImage("R.jpg");

        img.mosaic(1, 1, 1, false);
        img.overlayNoiseImageMultiply(1);
        img.rectangularAreaColorBlur(1, 6, 6, false);
        img.sinColorAbsolute(1, false);
        img.cosColorAbsolute(1, false);
        img.sinColorAbsolute(1, false);
        
    }
}

//Please work