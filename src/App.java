

public class App {
    public static void main(String[] args) throws Exception {
        MathImage img = new MathImage("FeelsVerySovietTrain.jpg");
        img.rectangularAreaColorBlur(5 , 5, 1, true);
        img.sineColor(1, true);
    }
}
