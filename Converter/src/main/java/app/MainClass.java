package app;

public class MainClass {
    public static final double CONV_K=2.20462;

    public static void main(String[] args) {
        System.out.println("Converter App.");

        double kgs=5;
        double pounds=convKgsToPounds(kgs);
        System.out.println("Result is "+pounds+" pounds.");
    }

    public static double convKgsToPounds(double kgs){
        return kgs*CONV_K;
    }
}
