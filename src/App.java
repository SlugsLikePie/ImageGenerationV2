

public class App {
    public static void main(String[] args) throws Exception {
        MathImage img = new MathImage("RomanianTrain.jpg");
        //img.rectangularAreaColorBlur(1 , 5, 5, false);
        img.cosColor(1, false);
        img.sinColor(1, false);
    }
}
